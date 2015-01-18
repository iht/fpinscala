/* Copyright (c) 2105 Israel Herraiz <isra@herraiz.org>
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
// Test for example 2.2
// --------------------

package chap02

import org.specs2.mutable._
import chap02.Ex02.isSorted

object Ex02Spec extends Specification {
  "isSorted" should {
    "check a sorted list" in {
      isSorted(Array(1,2,3,4,5,6), (a: Int, b: Int) => a<=b) mustEqual true
    }

    "check a sorted list in the wrong order" in {
      isSorted(Array(1,2,3,4,5,6), (a: Int, b: Int) => a>=b) mustEqual false
    }

    "check a reversed list" in {
      isSorted((Array(1,2,3,4,5,6)).reverse, (a: Int, b: Int) => a>=b) mustEqual true
    }

    "check a reversed list in the wrong order" in {
      isSorted((Array(1,2,3,4,5,6)).reverse, (a: Int, b: Int) => a<=b) mustEqual false
    }
    
    "check a reversed unsorted list" in {
      isSorted((Array(1,2,3,40,5,6)).reverse, (a: Int, b: Int) => a>=b) mustEqual false
    }

    "check an unsorted list" in {
      isSorted(Array(1,2,3,40,5,6), (a: Int, b: Int) => a<=b) mustEqual false
    }

    "check an unsorted list starting with large number" in {
      isSorted(Array(100,2,3,4,5,6), (a: Int, b: Int) => a<=b) mustEqual false
    }
    "check an unsorted list ending in zero" in {
      isSorted(Array(1,2,3,4,5,0), (a: Int, b: Int) => a<=b) mustEqual false
    }
    "check an unsorted list starting with large number (reversed)" in {
      isSorted((Array(100,2,3,4,5,6)).reverse, (a: Int, b: Int) => a>=b) mustEqual false
    }
    "check an unsorted list ending in zero (reversed)" in {
      isSorted((Array(1,2,3,4,5,0)).reverse, (a: Int, b: Int) => a>=b) mustEqual false
    }
  }
}
