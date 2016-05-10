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

// ---------------------
// Test for example 3.10
// ---------------------

package chap03

import org.specs2.mutable._

object Ex10Spec extends Specification {
  "The foldLeft function" should {
    "calculate the length of a list" in {
      Ex10.foldLeft(List(1,2,3,4,5), 0)((s,e) => 1 + s) mustEqual 5
    }

    "calculate the length of Nil" in {
      Ex10.foldLeft(Nil, 0)((s,e) => 1 + s) mustEqual 0
    }

    "calculate the sum of a list" in {
      Ex10.foldLeft(List(1,2,3,4,5), 0)(_ + _) mustEqual 15
    }

    "calculate the sum of Nil" in {
      Ex10.foldLeft(Nil: List[Int], 0)(_ + _) mustEqual 0
    }

    "calculate the product of a list" in {
      Ex10.foldLeft(List(1.0,2.0,3.0,4.0,5.0), 1.0)(_ * _) mustEqual 120
    }

    "calculate the product of Nil" in {
      Ex10.foldLeft(Nil: List[Double], 1.0)(_ * _) mustEqual 1.0
    }

    "behave like foldLeft" in {
      Ex10.foldLeft(List(1,2),List(3,4))((x,y) => y :: x) mustEqual
      (List(1,2)).foldLeft(List(3,4))((x,y) => y :: x)
    }

  }
}
