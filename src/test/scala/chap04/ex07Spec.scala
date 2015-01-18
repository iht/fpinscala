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

// ---------------------
// Test for example 4.07
// ---------------------

package chap04

import org.specs2.mutable._
import errorhandling._

object Ex07Spec extends Specification {
  "The sequence function" should {
    "return Right(Nil) with an empty List" in {
      Ex07.sequence(Nil) mustEqual Right(Nil)
    }

    "return a Right with a list" in {
      val x = List(Right(1),Right(2),Right(3),Right(5))
      Ex07.sequence(x) mustEqual Right(List(1,2,3,5))
    }

    "return the first left found in the list" in {
      val x = List(Left(1),Right(2),Right(3),Right(5))
      Ex07.sequence(x) mustEqual Left(1)

      val y = List(Right(1),Right(2),Right(3),Left(5))
      Ex07.sequence(y) mustEqual Left(5)

      val z = List(Right(1),Left(2),Right(3),Left(5))
      Ex07.sequence(z) mustEqual Left(2)
    }
  }

  "The traverse function" should {


    def Try[A](a: => A): Either[String, A] =
      try Right(a)
      catch { case e: java.lang.NumberFormatException => Left("Str to int exception") }

    "return Right(Nil) with an empty List" in {
      val x: List[Double] = Nil
      Ex07.traverse(x)(x => Right(x*2)) mustEqual Right(Nil)
    }

    "return a Right with a list" in {
      val x = List("1","2","3","5")
      Ex07.traverse(x)(n => Try(n.toInt)) mustEqual Right(List(1,2,3,5))
    }

    "return the first left found in the list" in {

      val x = List("1","2","x","5")
      Ex07.traverse(x)(n => Try(n.toInt)) mustEqual Left("Str to int exception")

      val y = List("1","2","3","x")
      Ex07.traverse(y)(n => Try(n.toInt)) mustEqual Left("Str to int exception")

      val z = List("x","2","3","5")
      Ex07.traverse(z)(n => Try(n.toInt)) mustEqual Left("Str to int exception")
    }
  }
}
