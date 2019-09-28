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
// Test for example 5.08
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex08Spec extends Specification {
  "The constant function" should {
    "return a stream of Ints" in {
      Stream.constant(1).take(3).toList mustEqual List(1,1,1)
      Stream.constant(1).take(100).toList must have size(100)
    }

    "return a stream of Doubles" in {
      Stream.constant(1.0).take(4).toList mustEqual List(1.0,1.0,1.0,1.0)
      Stream.constant(78.0).take(100).toList must have size(100)
    }

    "return a stream of Lists" in {
      Stream.constant(List(1,2)).take(5).toList mustEqual List(List(1,2),List(1,2),List(1,2),List(1,2),List(1,2))
      Stream.constant(List(4,5,6)).take(100).toList must have size(100)

    }
  }
}
