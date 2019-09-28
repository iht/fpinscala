/*
 * Copyright (c) 2014-2019 Israel Herraiz <isra@herraiz.org>
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

// --------------------
// Test for example 2.3
// --------------------

package chap02

import org.specs2.mutable._
import chap02.Ex03.curry
import scala.math

object Ex03Spec extends Specification {
  "Curry" should {
    val f = (x: Double, y: Double) => math.pow(x, y)
    val g = (a: Int, b: Int) => (a-b).toString

    "apply power in one direction" in {
      curry(f)(3.0)(2.0) mustEqual 9.0
    }

    "apply power in opposite direction" in {
      curry(f)(2.0)(3.0) mustEqual 8.0
    }

    "apply substraction in one direction" in {
      curry(g)(5)(7) mustEqual "-2"
    }

    "apply substraction in opposite direction" in {
      curry(g)(7)(5) mustEqual "2"

    }
  }
}
