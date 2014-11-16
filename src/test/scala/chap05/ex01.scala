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
// Test for example 5.01
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex01Spec extends Specification {
  "The toList function" should {
    "return Nil with Empty stream" in {
      Empty.toList mustEqual Nil
    }

    "return a list of Ints" in {
      Stream(1,2,3,5).toList mustEqual List(1,2,3,5)
    }

    "return a list of Double" in {
      Stream(1.2,2.3,3.5).toList mustEqual List(1.2,2.3,3.5)
    }

    "return a list of Options" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).toList mustEqual List(None,Some(1),None,Some(2),None,Some(3))
    }
  }
}
