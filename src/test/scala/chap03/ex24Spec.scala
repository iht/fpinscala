/* Copyright (c) 2014 Israel Herraiz <isra@herraiz.org>
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
// Test for example 3.24
// ---------------------

package chap03

import org.specs2.mutable._

object Ex24Spec extends Specification {
  "The hasSubsequence function" should {
    "return true with Nil" in {
      Ex24.hasSubsequence(List(1,2,3), Nil) mustEqual true
    }

    "return true with Nil and Nil" in {
      Ex24.hasSubsequence(Nil, Nil) mustEqual true
    }

    "return true with subsequence" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(2,3,4)) mustEqual true
    }

    "return true with starting subsequence" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(1,2,3)) mustEqual true
    }

    "return true with ending subsequence" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(3,4,5)) mustEqual true
    }
    
    "return false with random list -- starting" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(1,2,4)) mustEqual false
    }

    "return false with random list -- ending" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(3,4,6)) mustEqual false
    }


    "return false with random list" in {
      Ex24.hasSubsequence(List(1,2,3,4,5),List(2,4,3)) mustEqual false
    }
  }
}
