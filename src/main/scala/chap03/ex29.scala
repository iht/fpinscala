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
// Code for example 3.29
// ---------------------

package chap03

import adt._

object Ex29 {

  // Fold can be implemented with ac being of type B,
  // or with ac being A => B
  // In this second case, fold cannot be tail recursive
  def fold[A,B](t: Tree[A], ac: B)(f: (B,A) => B): B = {

    @annotation.tailrec
    def loop(l: List[Tree[A]], z: B): B = {
      l match {
	case Nil => z
	case Leaf(x) :: t => loop(t, f(z, x))
	case Branch(l,r) :: t => loop(l :: r :: t, z)
      }
    }

    loop(List(t), ac)
  }

  // Needed to implement map and depth
  // Impossible (?) to make tail recursive
  def foldNonTailRec[A,B](t: Tree[A])(ac: A => B)(f: (B,B) => B): B = {
    t match {
      case Leaf(x) => ac(x)
      case Branch(l,r) => f(foldNonTailRec(l)(ac)(f), foldNonTailRec(r)( ac)(f))
    }
  }

  def size[A](t: Tree[A]): Int = {
    fold(t, 0)((x,y) => x + 1)
  }

  def maximum[A: Numeric](t: Tree[A]): A = {
    val max = implicitly[Numeric[A]].max _
    val minVal = implicitly[Numeric[A]].fromInt(Int.MinValue)

    fold(t, minVal)((m,y) => max(m,y))            
  }

  // depth and map cannot be implemented with the tail rec fold

  def depth[A](t: Tree[A]): Int = {    
    foldNonTailRec(t)(a => 0)((x,y) => (1+x) max (1+y))
  }

  def map[A,B](t: Tree[A])(f: A => B): Tree[B] = {
    foldNonTailRec(t)(a => Leaf(f(a)): Tree[B])((l,r) => Branch(l,r))
  }

  
}
