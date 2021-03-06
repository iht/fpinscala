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
// Code for example 3.25
// ---------------------

package chap03

import adt._

object Ex25 {

  def size[A](t: Tree[A]): Int = {

    // Using a list we flatten the tree, and model a stack-like
    // structure, which makes it possible to write size using
    // tail recursion
    @annotation.tailrec
    def loop(t1: List[Tree[A]], s: Int): Int = {
      t1 match {
	case Nil => s
	case Leaf(_) :: lt => loop(lt, s + 1)
	case Branch(l,r) :: lt => loop(l :: r :: lt, s)
      }
    }

    loop(List(t), 0)
  }

  // The same exercise, solved using a naive approach
  // This solution will cause a stack overflow for very deep trees
  def sizeNaive[A](t: Tree[A]): Int = {
    t match {
      case Leaf(_) => 1
      case Branch(l,r) => Ex25.size(l) + Ex25.size(r)
    }
  }
}
