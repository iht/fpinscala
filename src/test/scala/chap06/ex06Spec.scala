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
// Test for example 6.06
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex06Spec extends Specification {

  val rng = SimpleRNG(12345)

  "The map2 method" should {
    "calculate the sum of two doubles" in {
      val d1 = RNG.doubleWithMap(rng)
      val d2 = RNG.doubleWithMap(d1(rng)._2)
      
      val left = RNG.map2(d1, d2)(_+_)(rng)
      val right = (d1(rng)._1+d2(d1(rng)._2)._1,d2(d1(rng)._2)._2)

      left mustEqual right
    }

    "calculate the product of two doubles" in {
      val d1 = RNG.doubleWithMap(rng)
      val d2 = RNG.doubleWithMap(d1(rng)._2)
      
      val left = RNG.map2(d1, d2)(_*_)(rng)
      val right = (d1(rng)._1*d2(d1(rng)._2)._1,d2(d1(rng)._2)._2)

      left mustEqual right
    }
  }
}
