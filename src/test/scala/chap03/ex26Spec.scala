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
// Test for example 3.26
// ---------------------

package chap03

import adt._

import org.specs2.mutable._

object Ex26Spec extends Specification {
  "The maximum function" should {
    "works with a single leaf tree" in {
      Ex26.maximum(Leaf(0)) mustEqual 0
    }

    "gives the right max for some simple trees" in {
      val tree2 = Branch(Leaf(-1.4),Leaf(-2.5))
      Ex26.maximum(tree2) mustEqual -1.4
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex26.maximum(tree3) mustEqual 7.6

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex26.maximum(tree5a) mustEqual 7.6
      Ex26.maximum(tree5b) mustEqual 7.6

      val tree4 = Branch(tree2, tree2)
      Ex26.maximum(tree4) mustEqual -1.4

      val tree9 = Branch(tree4, tree5b)
      Ex26.maximum(tree9) mustEqual 7.6
    }
  }
}
