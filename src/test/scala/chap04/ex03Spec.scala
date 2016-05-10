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
// Test for example 4.03
// ---------------------

package chap04

import org.specs2.mutable._
import errorhandling._

object Ex03Spec extends Specification {
  "The map2 function" should {
    "return None if any of the arguments is None" in {
      val a: Option[Int] = None
      Ex03.map2(a,Some(3))(_+_) mustEqual None
      Ex03.map2(Some(9),a)(_+_) mustEqual None
    }

    "apply the function with two Ints" in {
      Ex03.map2(Some(8), Some(9))(_*_) mustEqual Some(72)
    }

    "apply the function with two Doubles" in {
      Ex03.map2(Some(3.5),Some(4.5))(_+_) mustEqual Some(8.0)
    }

  }  
}
