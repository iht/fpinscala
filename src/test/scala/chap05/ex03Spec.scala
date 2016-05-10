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
// Test for example 5.03
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex03Spec extends Specification {
  "The takeWhile function" should {
    "return Nil with Empty stream" in {
      val e: Stream[Int] = Empty
      e.takeWhile(_ % 2 == 0).toList mustEqual Empty.toList
    }

    "return a stream of Ints" in {
      Stream(1,2,3,5).takeWhile(_ % 2 != 0).toList mustEqual Stream(1).toList
    }

    "return a stream of Double" in {
      Stream(1.2,2.3,5.5,4.7,2.1).takeWhile(_<4.0).toList mustEqual Stream(1.2,2.3).toList
    }

    "return a stream of Options" in {
      Stream(None,Some(1),None,Some(2),None,Some(3)).takeWhile(_.isEmpty).toList mustEqual Stream(None).toList
    }

    "return an empty stream" in {
      Stream(1,2,3,5).takeWhile(_ % 2 == 0).toList mustEqual Empty.toList
    }

  }
}
