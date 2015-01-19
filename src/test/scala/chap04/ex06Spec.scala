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

// ---------------------
// Test for example 4.06
// ---------------------

package chap04

import org.specs2.mutable._
import errorhandling._

object Ex06Spec extends Specification {

  "The map function" should {
    "return Right with any Right" in {
      val x: Either[Nothing, Double] = Right(2.0)
      x.map(_*2) mustEqual Right(4.0)
    }

    "return the same Left with any Left" in {
      val x: Either[Double, Nothing] = Left(2.0)
      x.map(_.toString) mustEqual Left(2.0)
    }
  }

  "The flatMap function" should {
    "return Right with any Right" in {
      val x: Either[Nothing, Double] = Right(2.0)
      x.flatMap(x => Right(x*2)) mustEqual Right(4.0)
    }

    "return the same Left with any Left" in {
      val x: Either[Double, Nothing] = Left(2.0)
      x.flatMap(x => Left(x.toString)) mustEqual Left(2.0)
    }
  }

  "The orElse function" should {
    "return Right with any Right" in {
      val x: Either[Nothing, Double] = Right(2.0)
      x.orElse(Right(7.8)) mustEqual Right(2.0)
    }

    "return the default val with any Left" in {
      val x: Either[Double, Nothing] = Left(2.0)
      x.orElse(Right(7.8)) mustEqual Right(7.8)
    }
  }

  "The map2 function" should {
    "return Right with any Right" in {
      val x: Either[Nothing, Double] = Right(2.0)
      x.map2(Right(7.8))((x,y) => "%.2f".format(x*y)) mustEqual Right("15.60")
    }

    "return the Left with any Left" in {
      Left(2.0).map2(Right(7.8))((x,y) => y*2) mustEqual Left(2.0)
      Right(7.8).map2(Left(2.0))((x,y) => x*2) mustEqual Left(2.0)
    }

    "return the first Left with both Left" in {
      Left(1.0).map2(Left(2.0))((x,y) => x.toString) mustEqual Left(1.0)
      Left(2.0).map2(Left(1.0))((x,y) => x.toString) mustEqual Left(2.0)
    }

  }
}
