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

// --------------------
// Test for example 2.5
// --------------------

package chap02

import org.specs2.mutable._
import chap02.Ex05.compose

object Ex05Spec extends Specification {
  "Compose" should {
    val f1 = (x:Int) => x.toString
    val g1 = (y:Double) => y.toInt
    val c1 = g1 andThen f1

    val f2 = (x: Double) => (x*x).toString
    val g2 = (y: Int) => y*2.0
    val c2 = g2 andThen f2

    "transform Double to String" in {
      f1(g1(7.0)) mustEqual "7"
    }

    "tranform Int to String" in {
      f2(g2(3)) mustEqual "36.0"
    }

    "give same result as andThen with Double (7.0)" in {
      f1(g1(7.0)) mustEqual c1(7.0)
    }

    "give same result as andThen with Double (2.0)" in {
      f1(g1(2.0)) mustEqual c1(2.0)
    }

    "give same result as andThen with negative Double" in {
      f1(g1(-3.0)) mustEqual c1(-3.0)
    }

    "give same result as andThen with Int (7)" in {
      f2(g2(7)) mustEqual c2(7)
    }

    "give same result as andThen with Int (2)" in {
      f2(g2(2)) mustEqual c2(2)
    }

    "give same result as andThen with negative Int" in {
      f2(g2(-3)) mustEqual c2(-3)
    }
  }
}
