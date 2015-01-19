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
// Test for example 3.16
// ---------------------

package chap03

import org.specs2.mutable._

object Ex16Spec extends Specification {
  "The addOne function" should {
    "return Nil with Nil int list" in {
      Ex16.addOne(Nil: List[Int]) mustEqual Nil
    }

    "return Nil with Nil Double list" in {
      Ex16.addOne(Nil: List[Double]) mustEqual Nil
    }

    "return a single element list with Int" in {
      Ex16.addOne(List(7)) mustEqual List(8)
    }

    "return a single element list with Double" in {
      Ex16.addOne(List(11.5)) mustEqual List(12.5)
    }

    "return a list of Ints" in {
      Ex16.addOne(List(5,4,16,1,6)) mustEqual List(6,5,17,2,7)
    }
    
    "return a list of Doubles" in {
      Ex16.addOne(List(5.0,4.0,16.0,1.0,6.0)) mustEqual List(6.0,5.0,17.0,2.0,7.0)
    }


  }
}
