/* Copyright (c) 2015 Israel Herraiz <isra@herraiz.org>
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
// Example 4.07
// ------------

package chap04

// Use Either defined in this chapter
import errorhandling._

object Ex07 {

  def sequence[E,A](es: List[Either[E,A]]): Either[E, List[A]] = {
    Ex07.traverse(es)(identity)
  }

  def traverse[E,A,B](as: List[A])(f: A => Either[E,B]): Either[E, List[B]] = {

    @annotation.tailrec
    def loop(ls: List[A], b: Either[E, List[B]]): Either[E, List[B]] = {
      ls match {
        case Nil => b
        case x :: xs => (f(x), b) match {
          case (Right(y), Right(z)) => loop(xs, Right(z :+ y))
          case (Right(y), _) => loop(xs, Right(List(y)))
          case (Left(y), _) => Left(y)
        }
      }
    }

    loop(as, Right(Nil))
  }
}
