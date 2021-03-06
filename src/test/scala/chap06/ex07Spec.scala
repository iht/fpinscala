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
// Test for example 6.07
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex07Spec extends Specification {
  val r: RNG = SimpleRNG(-123456)

  "The intsWithSeq method" should {
    "return a list of random integers" in {
      RNG.intsWithSeq(0)(r)._1 must have size(0)
      RNG.intsWithSeq(1)(r)._1 must have size(1)
      RNG.intsWithSeq(10)(r)._1 must have size(10)
      RNG.intsWithSeq(23)(r)._1 must have size(23)
      RNG.intsWithSeq(100)(r)._1 must have size(100)
      RNG.intsWithSeq(123)(r)._1 must have size(123)
    }
  }
}
