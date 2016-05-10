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
// Test for example 3.15
// ---------------------

package chap03

import org.specs2.mutable._

object Ex15Spec extends Specification {
  "The concatenate function" should {
    "return Nil if Nil is passed" in {
      Ex15.concatenate(Nil) mustEqual Nil
    }

    "return Nil if List of Nil is passed" in {
      Ex15.concatenate(List(Nil,Nil,Nil)) mustEqual Nil
    }


    "return a list for a list of lists" in {
      Ex15.concatenate(List(List(1,2),List(3,4))) mustEqual List(1,2,3,4)
    }

    "return a list for a list of lists" in {
      Ex15.concatenate(List(List(1,2),List(3,4),Nil)) mustEqual List(1,2,3,4)
    }

    "return a list for a list of lists" in {
      Ex15.concatenate(List(Nil,List(1,2),List(3,4))) mustEqual List(1,2,3,4)
    }

    "return a list for a list of lists" in {
      Ex15.concatenate(List(List(1,2),Nil,List(3,4))) mustEqual List(1,2,3,4)
    }

    "return a list for a list of lists" in {
      Ex15.concatenate(List(List(1,2),List(3,4),List(5,6,7))) mustEqual List(1,2,3,4,5,6,7)
    }
  }
}
