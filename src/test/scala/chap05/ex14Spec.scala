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
// Test for example 5.14
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex14Spec extends Specification {
  "The startsWith function" should {
    "return true" in {
      val x = Stream(1,2,3,4,5,6)
      val y1 = Stream(1,2,3)
      val y2 = Stream(1,2)
      val y3 = Stream(1)

      Ex14.startsWith(x, y1) mustEqual true
      Ex14.startsWith(x, y2) mustEqual true
      Ex14.startsWith(x, y3) mustEqual true
    }

    "return false" in {
      val x = Stream(2,3,4,5,6)
      val y1 = Stream(1,2,3)
      val y2 = Stream(1,2)
      val y3 = Stream(1)

      Ex14.startsWith(x, y1) mustEqual false
      Ex14.startsWith(x, y2) mustEqual false      
      Ex14.startsWith(x, y3) mustEqual false
    }

  }
}
