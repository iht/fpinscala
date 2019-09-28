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
// Test for example 3.27
// ---------------------

package chap03

import adt._

import org.specs2.mutable._

object Ex27Spec extends Specification {
  "The depth function" should {
    "works with a single leaf tree" in {
      Ex27.depth(Leaf(0)) mustEqual 0
    }

    "gives the right depth for some simple trees" in {
      val tree2 = Branch(Leaf(-1.4),Leaf(-2.5))
      Ex27.depth(tree2) mustEqual 1
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex27.depth(tree3) mustEqual 2

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex27.depth(tree5a) mustEqual 3
      Ex27.depth(tree5b) mustEqual 3

      val tree4 = Branch(tree2, tree2)
      Ex27.depth(tree4) mustEqual 2

      val tree9 = Branch(tree4, tree5b)
      Ex27.depth(tree9) mustEqual 4

      val tree10 = Branch(Leaf(7.12), tree9)
      Ex27.depth(tree10) mustEqual 5

      val tree11 = Branch(Leaf(7.12), Branch(tree9, Leaf(1.23)))
      Ex27.depth(tree11) mustEqual 6

      val tree22 = Branch(tree11, tree5b)
      Ex27.depth(tree22) mustEqual 7

      val tree23 = Branch(tree11, Branch(Leaf(89.9), tree11))
      Ex27.depth(tree23) mustEqual 8
    }
  }
}
