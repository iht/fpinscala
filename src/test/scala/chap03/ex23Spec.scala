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
// Test for example 3.23
// ---------------------

package chap03

import org.specs2.mutable._

object Ex23Spec extends Specification {
  "The zipWith function" should {

    "return Nil with Nils" in {
      Ex23.zipWith(Nil: List[Double], Nil: List[Double])(_+_) mustEqual Nil
    }

    "fail with Lists of different size" in {
     Ex23.zipWith(List(1,2,3), List(4,5))(_*_) must throwA[java.lang.AssertionError]
    }

    "work with lists of integers" in {
      Ex23.zipWith(List(1,2,3), List(4,5,6))(_+_) mustEqual List(5,7,9)
    }

    "work with lists of doubles" in {
      Ex23.zipWith(List(1.0, 2.0, 3.0), List(4.0, 5.0, 6.0))(_*_) mustEqual List(4.0, 10.0, 18.0)
    }
  }
}
