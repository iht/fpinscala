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
// Code for example 3.26
// ---------------------

package chap03

import adt._

object Ex26 {

  // Naive version
  // Causes stack overflow with very deep trees
  def maximumNaive[A: Numeric](t: Tree[A]): A = {
    val maxOp: (A, A) => A = implicitly[Numeric[A]].max _
    t match {
      case Leaf(x) => x
      case Branch(l, r) => maxOp(maximum(l), maximum(r))
    }
  }

  // Tail recursive version
  def maximum[A: Numeric](t: Tree[A]): A = {
    val maxOp: (A, A) => A = implicitly[Numeric[A]].max _

    // This should be the smallest possible value for
    // Numeric type A
    // However, Numeric.MinValue is not defined in Scala,
    // so we are using Int.MinValue
    // (it will fail for values lower that Int.MinValue, e.g.
    // with Doubles smaller than Int.MinValue)
    val zero = implicitly[Numeric[A]].fromInt(Int.MinValue)

    @annotation.tailrec
    def loop(t1: List[Tree[A]], m: A): A = {
      t1 match {
        case Nil => m
        case Leaf(x) :: lt => loop(lt, maxOp(m, x))
        case Branch(l, r) :: lt => loop(l :: r :: lt, m)
      }
    }

    loop(List(t), zero)
  }
}
