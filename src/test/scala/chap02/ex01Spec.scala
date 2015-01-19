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

// --------------------
// Test for example 2.1
// --------------------

package chap02

import org.specs2.mutable._
import chap02.Ex01.fibo

object Ex01Spec extends Specification {
  "Fibonacci" should {
    "calculate the 0th position of the Fibonacci sequence" in {
      fibo(0) mustEqual 1
    }

    "calculate the 1st position of the Fibonacci sequence" in {
      fibo(1) mustEqual 1
    }

    "calculate the 2nd position of the Fibonacci sequence" in {
      fibo(2) mustEqual 2
    }

    "calculate the 3rd position of the Fibonacci sequence" in {
      fibo(3) mustEqual 3
    }

    "calculate the 4th position of the Fibonacci sequence" in {
      fibo(4) mustEqual 5
    }

    "calculate the 5th position of the Fibonacci sequence" in {
      fibo(5) mustEqual 8
    }
  }
}
