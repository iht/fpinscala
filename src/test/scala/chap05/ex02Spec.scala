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
// Test for example 5.02
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex02Spec extends Specification {
  "The take function" should {
    "return Nil with Empty stream" in {
      Empty.take(1).toList mustEqual Empty.toList
    }

    "return a list of Ints" in {
      Stream(1,2,3,5).take(3).toList mustEqual Stream(1,2,3).toList
    }

    "return a list of Double" in {
      Stream(1.2,2.3,3.5).take(2).toList mustEqual Stream(1.2,2.3).toList
    }

    "return a list of Options" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).take(0).toList mustEqual Empty.toList
    }
  }

  "The drop function" should {
    "return Nil with Empty stream" in {
      Empty.drop(0).toList mustEqual Empty.toList
    }

    "return a list of Ints" in {
      Stream(1,2,3,5).drop(2).toList mustEqual Stream(3,5).toList
    }

    "return a list of Double" in {
      Stream(1.2,2.3,3.5).drop(1).toList mustEqual Stream(2.3,3.5).toList
    }

    "return a list of Options" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).drop(3).toList mustEqual Stream(Some(2),None,Some(3)).toList
    }

    "return empty" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).drop(6).toList mustEqual Empty.toList
    }

    "return empty if n > size of stream" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).drop(8).toList mustEqual Empty.toList
    }

  }
}
