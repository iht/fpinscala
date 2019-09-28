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

// --------------------
// Code for example 3.7
// --------------------

package chap03

object Ex07 {

  def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B = {
    as match {
      case Nil => z
      case h::t => f(h, foldRight(t,z)(f))
    }
  }

  def sum2(ns: List[Int]) =
    foldRight(ns,0)(_ + _)

  def product2(ns: List[Double]) =
    foldRight(ns,1.0)(_ * _)

  // foldRight cannot be stopped using f
  // We need to change foldRight itself to stop the recursion
  // That's because the recursion is in one of the arguments
  // to f, that f cannot control
  def productHalt(ns: List[Double]) = {
    foldRight(ns,1.0) {
      (e,p) =>
      println("Prod: %.1f  Elem: %.1f".format(p,e))
      p match {
        case 0.0 => 0.0
        case _ => e*p
      }
    }
  }

}
