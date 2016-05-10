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

// --------------------------------------
// Either type for exercises in chapter 4
// --------------------------------------

package errorhandling

// Hide real Scala Option and Either
import scala.{Option => _, Either => _, _}

sealed trait Either[+E, +A] {
  def map[B](f: A => B): Either[E, B] = {
    this match {
      case Right(x) => Right(f(x))
      case Left(x) => Left(x)
    }
  }

  def flatMap[EE >:E, B](f: A => Either[EE, B]): Either[EE, B] = {
    this match {
      case Right(x) => f(x)
      case Left(x) => Left(x)
    }
  }

  def orElse[EE >: E, B >: A](b: => Either[EE,B]): Either[EE,B] = {
    this match {
      case Right(x) => Right(x)
      case Left(x) => b
    }
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A,B) => C): Either[EE, C] = {
    (this, b) match {
      case (Right(x), Right(y)) => Right(f(x,y))
      case (Left(x), _) => Left(x)
      case (_, Left(x)) => Left(x)
    }
  }
 
}
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]
