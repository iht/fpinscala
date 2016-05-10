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
// Test for example 5.11
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex11Spec extends Specification {
  "The unfold function" should {
    "return a constant stream" in {
      val s = Stream.unfold(1) {n: Int => Some((1,1))}
      s.take(3).toList mustEqual List(1,1,1)
      s.take(5).toList mustEqual List(1,1,1,1,1)
    }

    "return an empty stream" in {
      val s = Stream.unfold(1){x => None}
      s mustEqual Empty
    }

    "return a monotonic increasing stream" in {
      val s = Stream.unfold(4) {n:Int => Some((n,n+1))}
      s.take(3).toList mustEqual List(4,5,6)
      s.take(5).toList mustEqual List(4,5,6,7,8)
    }

    "return the Fibonacci sequence" in {
      val s = Stream.unfold((1,1)) {
        case (n1, n2) =>
          Some(((n1,n2),(n1+n2,n1+n2+n2)))
        }
      s.take(3).toList mustEqual List((1,1),(2,3),(5,8))
      s.take(5).toList mustEqual List((1,1),(2,3),(5,8),(13,21),(34,55))
    }
  }
}
