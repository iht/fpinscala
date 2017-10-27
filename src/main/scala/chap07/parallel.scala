package chap07

/* Copyright (c) 2014-2017 Israel Herraiz <isra@herraiz.org>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// ----------------------------------
// Parallelism exercises in chapter 7
// ----------------------------------

import java.util.concurrent.{ Callable, ExecutorService, Future, TimeUnit }

// This makes the type Par visible when importing the package
package object par {
  type Par[A] = ExecutorService => Future[A]
}

object Par {
  import par.Par

  private case class UnitFuture[A](get: A) extends Future[A] {
    def isDone: Boolean = true
    def get(timeout: Long, units: TimeUnit): A = get
    def isCancelled: Boolean = false
    def cancel(eventIfRunning: Boolean): Boolean = false
  }

  def fork[A](p: => Par[A]): Par[A] = {
    es: ExecutorService => es.submit(new Callable[A] {
      def call = p(es).get
    })
  }

  def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)
  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

  def run[A](p: Par[A])(implicit s: ExecutorService): Future[A] = p(s)

  def runNow[A](p: Par[A])(implicit s: ExecutorService): A = run(p).get

  def sums(ints: IndexedSeq[Int]): Par[Int] = {
    if (ints.size <= 1) {
      Par.unit(ints.headOption.getOrElse(0))
    } else {
      val (l,r) = ints.splitAt(ints.length/2)
      Par.map2(sums(l), sums(r))(_ + _)
    }
  }

  // Exercise 7.1
  def map2[A,B,C](pa: Par[A], pb: Par[B])(f: (A,B) => C): Par[C] =
    (es: ExecutorService) => {
      val af = pa(es)
      val bf = pb(es)
      UnitFuture(f(af.get, bf.get))
    }
}
