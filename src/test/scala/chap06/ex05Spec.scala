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
// Test for example 6.05
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex05Spec extends Specification {
  "The doublewithMap method" should {
    "return always numbers 0<=x<1" in {      

      val r: RNG = SimpleRNG(-123456)

      var r1 = r
      // Create a list of 10000 RNGs
      val ranDoubles = (1 to 10000).map { x =>
        val d = RNG.doubleWithMap(r1)
        val x = d(r1)._1
        r1 = d(r1)._2
        x
      }

      ranDoubles must contain(be_>=(0.0) and be_<(1.0)).forall
    }
  }
}
