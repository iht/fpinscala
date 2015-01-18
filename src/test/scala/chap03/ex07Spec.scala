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

// --------------------
// Test for example 3.7
// --------------------

package chap03

import org.specs2.mutable._
import chap03.Ex07._

object Ex07Spec extends Specification {
  "The product2 function" should {
    "calculate the product" in {
      product2(List(1.0,2.0,3.0,4.0,5.0)) mustEqual 120.0
    }

    "produce zero" in {
      product2(List(1.0,2.0,0.0,3.0,4.0)) mustEqual 0.0
    }
  }

  "The sum2 function" should {
    "calculate the sum" in {
      sum2(List(1,2,3,4,5)) mustEqual 15
    }
  }

  "The productHalt function" should {
    "calculate the product" in {
      productHalt(List(1.0,2.0,3.0,4.0,5.0)) mustEqual 120.0
    }

    "stops at the middle (but it can't)" in {
      productHalt(List(1.0,2.0,0.0,3.0)) mustEqual 0.0
    }
  }
}

