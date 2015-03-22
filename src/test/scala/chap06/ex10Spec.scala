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
// Test for example 6.10
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex10Spec extends Specification {

  val rng = SimpleRNG(12345)

  "The State map method" should {
    "apply a function to a Rand of Double as map does" in {
      val d = RNG.doubleWithMap(rng)
      def f = { x: Double => x*x}

      val left = RNG.map(d)(f)(rng)
      val right = State(d).map(f).run(rng)

      left mustEqual right
    }

    "apply a function to a Rand of Int as map does" in {
      val d = RNG.int
      def f = { x: Int => x - 4}

      val left = RNG.map(d)(f)(rng)
      val right = State(d).map(f).run(rng)

      left mustEqual right
    }
  }

  "The State unit method" should {
    "return the same results as RNG unit" in {

      RNG.unit(4)(rng) mustEqual State.unit(4).run(rng)
      RNG.unit(3.14159)(rng) mustEqual State.unit(3.14159).run(rng)
      RNG.unit("Hello world")(rng) mustEqual State.unit("Hello world").run(rng)
    }
  }

  "The State map2 method" should {
    "calculate the sum of two doubles as RNG map2 does" in {
      val d1 = RNG.doubleWithMap(rng)
      val d2 = RNG.doubleWithMap(d1(rng)._2)

      def f = { (a: Double, b: Double) => a + b }

      val sd1 = State(d1)
      val sd2 = State(d2)
      val mp  = sd1.map2(sd2)(f)

      val left = mp.run(rng)
      val right = RNG.map2(d1, d2)(f)(rng)

      left mustEqual right
    }

    "calculate the product of two doubles as RNG map2 does" in {
      val d1 = RNG.doubleWithMap(rng)
      val d2 = RNG.doubleWithMap(d1(rng)._2)

      def f = { (a: Double, b: Double) => a * b }

      val sd1 = State(d1)
      val sd2 = State(d2)
      val mp  = sd1.map2(sd2)(f)

      val left = mp.run(rng)
      val right = RNG.map2(d1,d2)(f)(rng)

      left mustEqual right
    }
  }

  "The State sequence method" should {
    "return the same results as RNG sequence" in {
      // List with 42 rand ints
      val l = List.fill(42)(RNG.int)
      val ls = l.map(State(_))

      val left = RNG.sequence(l)(rng)
      val right = State.sequence(ls).run(rng)

      left mustEqual right
    }
  }
}
