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

// -------------------------------------------
// Random Num. Gen. for exercises in chapter 6
// -------------------------------------------

package rng

trait RNG {
  def nextInt: (Int, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed =  (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt

    (n, nextRNG)
  }
}

object RNG {
  // Exercise 6.1
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n, nextRNG) = rng.nextInt

    val nonNegative = n match {
      case Int.MinValue => Int.MaxValue
      case x if x < 0 => -x
      case x => x
    }

    (nonNegative, nextRNG)
  }

  // Exercise 6.2
  def double(rng: RNG): (Double, RNG) = {
    val (n, nextRNG) = RNG.nonNegativeInt(rng)

    val doubleRan = n.toDouble/(Int.MaxValue.toDouble+1.0)

    (doubleRan, nextRNG)
  }

  // Exercise 6.3
  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (n, rng2) = RNG.nonNegativeInt(rng)
    val (x, _) = RNG.double(rng)

    ((n,x),rng2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val (p,rng2) = RNG.intDouble(rng)
    ((p._2, p._1), rng2)
  }

  def double3(rng: RNG): ((Double,Double,Double),RNG) = {
    val (d1, rng1) = RNG.double(rng)
    val (d2, rng2) = RNG.double(rng1)
    val (d3, rng3) = RNG.double(rng2)

    ((d1,d2,d3),rng3)
  }

  // Exercise 6.4
  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    var r = rng

    val l = (1 to count).map { x => 
      val (n, r2) = r.nextInt
      r = r2
      n
    }.toList

    (l, r)
  }

  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] = {
    rng => (a, rng)
  }

  def map[A,B](s: Rand[A])(f: A => B): Rand[B] = {
    rng => {
      val (a,rng2) = s(rng)
      (f(a), rng2)
    }
  }

  def nonNegativeEven: Rand[Int] = {
    map(nonNegativeInt)(i => i - i % 2)
  }

    // Exercise 6.5
  def doubleWithMap(rng: RNG): Rand[Double] = {
    map(nonNegativeInt)(n => n.toDouble/(Int.MaxValue.toDouble+1.0))
  }
}
