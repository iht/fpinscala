/* Copyright (c) 2105 Israel Herraiz <isra@herraiz.org>
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
// Test for example 5.06
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex06Spec extends Specification {
  "The headOption function" should {
    "return None with Empty stream" in {
      val e: Stream[Int] = Empty
      e.headOption mustEqual None

      Stream().headOption mustEqual None
    }

    "return Some(1) with a stream of Ints" in {
      Stream(1,2,3,5).headOption mustEqual Some(1)
    }

    "return Some(1.0) with a stream of Doubles" in {
      Stream(1.0,2.0,3.0,5.0).headOption mustEqual Some(1.0)
    }

    "return Some with a single element Stream" in {
      Stream(List(1,2,3)).headOption mustEqual Some(List(1,2,3))
      Stream(1).headOption mustEqual Some(1)
    }
  }
}
