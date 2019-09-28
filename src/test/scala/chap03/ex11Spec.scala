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

// ---------------------
// Test for example 3.11
// ---------------------

package chap03

import org.specs2.mutable._

object Ex11Spec extends Specification {
  "The sum function" should {
    "return 0 in an empty Int list" in {
      Ex11.sum(Nil: List[Int]) mustEqual 0
    }

    "return 0.0 in an empty Double list" in {
      Ex11.sum(Nil: List[Double]) mustEqual 0.0
    }

    "sum an Int list" in {
      Ex11.sum(List(1,2,3,4,5)) mustEqual 15
    }

    "sum a Double list" in {
      Ex11.sum(List(1.0,2.0,3.0,4.0,5.0)) mustEqual 15.0
    }
  }

  "The product function" should {
    "return 1 in an empty Int list" in {
      Ex11.product(Nil: List[Int]) mustEqual 1
    }

    "return 1.0 in an empty Double list" in {
      Ex11.product(Nil: List[Double]) mustEqual 1.0
    }

    "get the product of an Int list" in {
      Ex11.product(List(1,2,3,4,5)) mustEqual 120
    }

    "get the product of a Double list" in {
      Ex11.product(List(1.0,2.0,3.0,4.0,5.0)) mustEqual 120.0
    }
  }

    "The length function" should {
    "return 0 in an empty Int list" in {
      Ex11.length(Nil: List[Int]) mustEqual 0
    }

    "return 0 in an empty Double list" in {
      Ex11.length(Nil: List[Double]) mustEqual 0
    }

    "get the length of an Int list" in {
      Ex11.length(List(1,2,3,4,5)) mustEqual 5
    }

    "get the length of a Double list" in {
      Ex11.length(List(1.0,2.0,3.0,4.0,5.0)) mustEqual 5
    }
  }
}
