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

// ---------------------
// Test for example 5.04
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex04Spec extends Specification {
  "The forAll function" should {
    "return true with Empty stream" in {
      val e: Stream[Int] = Empty
      e.forAll(_ % 2 == 0) mustEqual true
    }

    "return false with a stream of Ints" in {
      Stream(1,2,3,5).forAll(_ % 2 != 0) mustEqual false
    }

    "return true with a stream of even Ints" in {
      Stream(2,2,32,512).forAll(_ % 2 == 0) mustEqual true
    }

    "return false with a stream of Doubles" in {
      Stream(1.0,2.0,3.0,5.0).forAll(_ % 2.0 != 0) mustEqual false
    }

    "return true with a stream of even Ints" in {
      Stream(2.0,2.0,32.0,512.0,88.0).forAll(_ % 2.0 == 0) mustEqual true
    }

  }
}