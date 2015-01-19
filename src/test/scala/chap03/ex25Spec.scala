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
// Test for example 3.25
// ---------------------

package chap03

import adt._

import org.specs2.mutable._

object Ex25Spec extends Specification {
  "The size function" should {
    "works with a single leaf tree" in {
      Ex25.size(Leaf(0)) mustEqual 1
    }

    "gives the right size for some simple trees" in {
      val tree2 = Branch(Leaf(1.4),Leaf(2.5))
      Ex25.size(tree2) mustEqual 2
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex25.size(tree3) mustEqual 3

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex25.size(tree5a) mustEqual 5
      Ex25.size(tree5b) mustEqual 5

      val tree4 = Branch(tree2, tree2)
      Ex25.size(tree4) mustEqual 4

      val tree9 = Branch(tree4, tree5b)
      Ex25.size(tree9) mustEqual 9
    }
  }
}
