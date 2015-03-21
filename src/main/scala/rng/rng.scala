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

  // Exercise 6.6
  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A,B) => C): Rand[C] = {
    rng => {
      val (a, rng1) = ra(rng)
      val (b, rng2) = rb(rng1)

      (f(a,b), rng2)
    }
  }

  // Exercise 6.7
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
    rng => {

      @annotation.tailrec
      def loop(tail: List[Rand[A]], build: (List[A], RNG)): (List[A], RNG) = {
        tail match {
          case Nil => build
          case h :: t =>
            val (l, rng2) = build
            val (a, rng3) = h(rng)
            loop(t, (l :+ a, rng3))
        }
      }

      loop(fs, (Nil: List[A], rng))
    }
  }

  def intsWithSeq(count: Int): Rand[List[Int]] = {
    val l = List.fill(count)(int)
    sequence(l)
  }

  // Exercise 6.8
  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, rng2) = f(rng)
      val (b, rng3) = g(a)(rng2)
      (b, rng3)
    }
  }

  def nonNegativeLessThan(n: Int): Rand[Int] = {
    flatMap(nonNegativeInt) {
      a =>
      val mod = a % n
      if (a + (n-1) - mod >= 0)
        unit(mod)
      else
        nonNegativeLessThan(mod)
    }
  }

  // Exercise 6.9
  def mapWithFM[A,B](s: Rand[A])(f: A => B): Rand[B] = {
    flatMap(s)(x => { rng => (f(x), rng) })
  }

  def map2WithFM[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A,B) => C): Rand[C] = {
    val rab = { rng: RNG =>
      val (a,rng1) = ra(rng)
      val (b,rng2) = rb(rng1)

      ((a,b),rng2)
    }

    flatMap(rab) {
      case (a,b) =>
        { rng3 => (f(a,b), rng3)}
    }
  }
}

// Exercise 6.10
case class State[S,+A](run: S => (A,S))

object State {

  def map[S,A,B](a: S => (A,S))(f: A => B): S => (B,S) = {
    { s =>
      val (va,s1) = a(s)
      (f(va), s1)
    }
  }

  def unit[S,A](a: A): S => (A,S) = {
    { s => (a,s) }
  }

  def flatMap[S,A,B](f: S => (A,S))(g: A => S => (B,S)): S => (B,S) = {
    s => {
      val (a, s2) = f(s)
      val (b, s3) = g(a)(s2)
      (b, s3)
    }
  }

  def map2[S,A,B,C](a: S => (A,S), b: S => (B,S))(f: (A,B) => C): S => (C,S) = {
    val sab = { s: S =>
      val (va,s1) = a(s)
      val (vb,s2) = b(s1)

      ((va,vb),s2)
    }

    flatMap(sab) {
      case (a,b) =>
        { s3 => (f(a,b), s3)}
    }
  }

  def sequence[S,A](fs: List[S => (A,S)]): S => (List[A],S) = {
    s => {

      @annotation.tailrec
      def loop(tail: List[S => (A,S)], build: (List[A], S)): (List[A], S) = {
        tail match {
          case Nil => build
          case h :: t =>
            val (l, s2) = build
            val (a, s3) = h(s)
            loop(t, (l :+ a, s3))
        }
      }

      loop(fs, (Nil: List[A], s))
    }
  }
}
