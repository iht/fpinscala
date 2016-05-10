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
// Test for example 3.19
// ---------------------

package chap03

import org.specs2.mutable._

object Ex19Spec extends Specification {
  "The filter function" should {
    "return Nil with a trivial true function" in {
      Ex19.filter(Nil: List[Double])(x => true) mustEqual Nil
    }

    "return Nil with a trivial false function" in {
      Ex19.filter(Nil: List[Double])(x => false) mustEqual Nil
    }

    "behave like Scala filter with Nil" in {
      Ex19.filter(Nil: List[Double])(x => true) mustEqual Nil.filter(x => true)
    }

    "behave like Scala filter with single value list" in {
      Ex19.filter(List(7))(_ < 5) mustEqual List(7).filter(_ < 5)
    }

    "behave like Scala filter with a list" in {
      Ex19.filter(List(7,8,9,10))(_ <= 8) mustEqual List(7,8,9,10).filter(_ <= 8)
    }
  }
}
