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
// Test for example 3.28
// ---------------------

package chap03

import adt._

import org.specs2.mutable._

object Ex28Spec extends Specification {
  "The map function" should {
    "works with a single leaf tree" in {
      Ex28.map(Leaf(0))(_+1) mustEqual Leaf(1)
    }

    "creates the right tree for some simple trees" in {
      val tree2a = Branch(Leaf(-1.4),Leaf(-2.5))
      val tree2b= Branch(Leaf(-2.8),Leaf(-5.0))
      Ex28.map(tree2a){_*2} mustEqual tree2b
      val tree3a = Branch(tree2a, Leaf(7.6))
      val tree3b = Branch(tree2b, Leaf(15.2))
      Ex28.map(tree3a){_*2} mustEqual tree3b

      val tree5a = Branch(tree2a, tree3a)
      val tree5b = Branch(tree2b, tree3b)
      
      Ex28.map(tree5a){_*2} mustEqual tree5b

      val tree4a = Branch(tree2a, tree2a)
      val tree4b = Branch(tree2b, tree2b)
      Ex28.map(tree4a){_*2} mustEqual tree4b

      val tree9a = Branch(tree4a, tree5a)
      val tree9b = Branch(tree4b, tree5b)
      Ex28.map(tree9a){_*2} mustEqual tree9b

      val tree10a = Branch(Leaf(7.12), tree9a)
      val tree10b = Branch(Leaf(14.24), tree9b)
      Ex28.map(tree10a){_*2} mustEqual tree10b

      val tree11a = Branch(Leaf(7.12), Branch(tree9a, Leaf(1.23)))
      val tree11b = Branch(Leaf(14.24), Branch(tree9b, Leaf(2.46)))
      Ex28.map(tree11a){_*2} mustEqual tree11b
    }
  }
}
