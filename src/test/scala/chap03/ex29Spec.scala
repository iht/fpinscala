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
// Test for example 3.29
// ---------------------

package chap03

import adt._

import org.specs2.mutable._

object Ex29Spec extends Specification {
  "The size function" should {
    "works with a single leaf tree" in {
      Ex29.size(Leaf(0)) mustEqual 1
    }

    "gives the right size for some simple trees" in {
      val tree2 = Branch(Leaf(1.4),Leaf(2.5))
      Ex29.size(tree2) mustEqual 2
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex29.size(tree3) mustEqual 3

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex29.size(tree5a) mustEqual 5
      Ex29.size(tree5b) mustEqual 5

      val tree4 = Branch(tree2, tree2)
      Ex29.size(tree4) mustEqual 4

      val tree9 = Branch(tree4, tree5b)
      Ex29.size(tree9) mustEqual 9
    }
  }

  "The maximum function" should {
    "works with a single leaf tree" in {
      Ex29.maximum(Leaf(0)) mustEqual 0
    }

    "gives the right max for some simple trees" in {
      val tree2 = Branch(Leaf(-1.4),Leaf(-2.5))
      Ex29.maximum(tree2) mustEqual -1.4
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex29.maximum(tree3) mustEqual 7.6

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex29.maximum(tree5a) mustEqual 7.6
      Ex29.maximum(tree5b) mustEqual 7.6

      val tree4 = Branch(tree2, tree2)
      Ex29.maximum(tree4) mustEqual -1.4

      val tree9 = Branch(tree4, tree5b)
      Ex29.maximum(tree9) mustEqual 7.6
    }
  }

  "The depth function" should {
    "works with a single leaf tree" in {
      Ex29.depth(Leaf(0)) mustEqual 0
    }

    "gives the right depth for some simple trees" in {
      val tree2 = Branch(Leaf(-1.4),Leaf(-2.5))
      Ex29.depth(tree2) mustEqual 1
      val tree3 = Branch(tree2, Leaf(7.6))
      Ex29.depth(tree3) mustEqual 2

      val tree5a = Branch(tree2, tree3)
      val tree5b = Branch(tree2, tree3)
      
      Ex29.depth(tree5a) mustEqual 3
      Ex29.depth(tree5b) mustEqual 3

      val tree4 = Branch(tree2, tree2)
      Ex29.depth(tree4) mustEqual 2

      val tree9 = Branch(tree4, tree5b)
      Ex29.depth(tree9) mustEqual 4

      val tree10 = Branch(Leaf(7.12), tree9)
      Ex29.depth(tree10) mustEqual 5

      val tree11 = Branch(Leaf(7.12), Branch(tree9, Leaf(1.23)))
      Ex29.depth(tree11) mustEqual 6

      val tree22 = Branch(tree11, tree5b)
      Ex29.depth(tree22) mustEqual 7

      val tree23 = Branch(tree11, Branch(Leaf(89.9), tree11))
      Ex29.depth(tree23) mustEqual 8
    }
  }

  "The map function" should {
    "works with a single leaf tree" in {
      Ex29.map(Leaf(0))(_+1) mustEqual Leaf(1)
    }

    "creates the right tree for some simple trees" in {
      val tree2a = Branch(Leaf(-1.4),Leaf(-2.5))
      val tree2b= Branch(Leaf(-2.8),Leaf(-5.0))
      Ex29.map(tree2a){_*2} mustEqual tree2b
      val tree3a = Branch(tree2a, Leaf(7.6))
      val tree3b = Branch(tree2b, Leaf(15.2))
      Ex29.map(tree3a){_*2} mustEqual tree3b

      val tree5a = Branch(tree2a, tree3a)
      val tree5b = Branch(tree2b, tree3b)
      
      Ex29.map(tree5a){_*2} mustEqual tree5b

      val tree4a = Branch(tree2a, tree2a)
      val tree4b = Branch(tree2b, tree2b)
      Ex29.map(tree4a){_*2} mustEqual tree4b

      val tree9a = Branch(tree4a, tree5a)
      val tree9b = Branch(tree4b, tree5b)
      Ex29.map(tree9a){_*2} mustEqual tree9b

      val tree10a = Branch(Leaf(7.12), tree9a)
      val tree10b = Branch(Leaf(14.24), tree9b)
      Ex29.map(tree10a){_*2} mustEqual tree10b

      val tree11a = Branch(Leaf(7.12), Branch(tree9a, Leaf(1.23)))
      val tree11b = Branch(Leaf(14.24), Branch(tree9b, Leaf(2.46)))
      Ex29.map(tree11a){_*2} mustEqual tree11b
    }
  }
}
