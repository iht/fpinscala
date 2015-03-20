/* Copyright (c) 2015 Israel Herraiz <isra@herraiz.org>
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
// Test for example 6.08
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex08Spec extends Specification {
  val r: RNG = SimpleRNG(-123456)

  "The nonNegativeLessThan method" should {
    "return random ints between 0 and 10" in {

      val n = 10

      val (ran, rng2) = RNG.nonNegativeLessThan(n)(r)

      ran must be_>=(0)
      ran must be_<(n)
    }

    "return random ints between 0 and 23" in {

      val n = 23

      val (ran, rng2) = RNG.nonNegativeLessThan(n)(r)

      ran must be_>=(0)
      ran must be_<(n)
    }

  }
}
