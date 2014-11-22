/* Copyright (c) 2014 Israel Herraiz <isra@herraiz.org>
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

// -------------------------------------
// Stream ADT for exercises in chapter 5
// -------------------------------------


package adt

sealed trait Stream[+A] {
  // Exercise 5.01
  def toList: List[A] = {

    @annotation.tailrec
    def loop(s: Stream[A], l: List[A]): List[A] = {
      s match {
        case Cons(h, t) => loop(t(), l :+ h())
        case Empty => l
      }
    }

    loop(this, Nil)
  }

  // Exercise 5.02
  def take(n: Int): Stream[A] = {

    @annotation.tailrec
    def loop(s: Stream[A], nloop: Int, so: Stream[A]): Stream[A] = {
    if (nloop == 0)
      so
    else
      s match {
        case Empty => so
        case Cons(h,t) => loop(t(), nloop-1, Cons(h, () => so))
      }
    }

    loop(this, n, Empty).reverse
  }


  def drop(n: Int): Stream[A] = {

    @annotation.tailrec
    def loop(s1: Stream[A], nloop: Int): Stream[A] = {
    if (nloop == 0)
      s1
    else
      s1 match {
        case Empty => Empty
        case Cons(h,t) => loop(t(), nloop-1)
      }
    }

    loop(this, n)
  }

  // For convenience with tail recursive implementations
  def reverse: Stream[A] = {
    @annotation.tailrec
    def loop(s1: Stream[A], s2: Stream[A]): Stream[A] = {
      s1 match {
        case Empty => s2
        case Cons(h,t) => loop(t(), Cons(h, () => s2))
      }
    }

    loop(this, Empty)
  }

  // Exercise 5.3 (commented for exercise 5.5)
//  def takeWhile(p: A => Boolean): Stream[A] = {

//    @annotation.tailrec
//    def loop(s: Stream[A], so: Stream[A]): Stream[A] = {
//      s match {
//        case Empty => so
//        case Cons(h,t) => if (p(h())) loop(t(), Cons(h, () => so)) else so
//      }
//    }

//    loop(this, Empty).reverse
//  }

  // Exercise 5.4
  def forAll(p: A => Boolean): Boolean = {

    @annotation.tailrec
    def loop(s: Stream[A]): Boolean = {
      s match {
        case Empty => true
        case Cons(h,t) => p(h()) && loop(t())        
      }
    }

    loop(this)
  }

  // Exercise 5.5
  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
    this match {
      case Cons(h,t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }
  }

  def takeWhile(p: A => Boolean): Stream[A] = {
    this.foldRight(Empty: Stream[A])((x,y) => if (p(x)) Cons(() => x,() => y) else Empty)
  }

  // Exercise 5.6
  def headOption: Option[A] = {
    this.foldRight(None: Option[A])((x,y) => Some(x))
  }
}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl

    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))    
  }
}
