/* Copyright (c) 2105 Israel Herraiz <isra@herraiz.org>
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
// Example 4.05
// ------------

package chap04

// Use Option and None defined in this chapter
import errorhandling._

object Ex05 {

  def traverse[A,B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    @annotation.tailrec
    def loop(as: List[A], bs: Option[List[B]]): Option[List[B]] = {
      as match {
        case Nil => bs
        case x :: xs => f(x) match {
          case None => None
          case Some(z) => loop(xs, Some(bs.getOrElse(Nil) :+ z))
        }
      }
    }

    loop(a, None)
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    traverse(a)(identity)
  }

}
