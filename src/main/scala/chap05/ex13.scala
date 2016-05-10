/* Copyright (c) 2014-2016 Israel Herraiz <isra@herraiz.org>
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

// ------------
// Example 5.13
// ------------

package chap05

import adt._

object Ex13 {
  def map[A,B](s: Stream[A])(f: A => B): Stream[B] = {
    Stream.unfold(s) { x =>
      x match {
        case Empty => None
        case Cons(h,t) => Some((f(h()), t()))
      }
    }
  }

  def take[A](s: Stream[A], n: Int): Stream[A] = {
    Stream.unfold((s,n)) { case (x, nelems) =>

      if (nelems == 0)
        None
      else {
        x match {
          case Empty => None
          case Cons(h,t) => Some((h(),(t(),nelems-1)))
        }
      }
    }
  }

  def takeWhile[A](s: Stream[A])(p: A => Boolean): Stream[A] = {
    Stream.unfold(s) { x =>
      x match {
        case Empty => None
        case Cons(h,t) =>
          if (p(h())) Some((h(), t())) else None
      }
    }
  }


  def zipWith[A, B,C](s1: Stream[A], s2: Stream[B])(f: (A,B) => C): Stream[C] = {
    Stream.unfold((s1,s2)) { case (x1,x2) => 
      (x1,x2) match {
        case (Cons(h1,t1), Cons(h2,t2)) =>
          Some((f(h1(),h2()),(t1(),t2())))
        case _ => None
      }
    }
  }

  def zipAll[A,B](s1: Stream[A], s2: Stream[B]): Stream[(Option[A], Option[B])] = {
    Stream.unfold((s1,s2)) { case (x1,x2) =>
      (x1,x2) match {
        case (Empty, Empty) => None
        case (Empty, Cons(h,t)) =>
          Some(((None,Some(h())),(Empty,t())))
        case (Cons(h,t), Empty) =>
          Some(((Some(h()),None),(t(),Empty)))
        case (Cons(h1,t1),Cons(h2,t2)) =>
          Some(((Some(h1()),Some(h2())),(t1(),t2())))
      }
    }
  }
}
