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
// Code for example 3.22
// ---------------------

package chap03

import scala.math.Numeric

object Ex22 {
  
  def addTwoLists[A: Numeric](l1: List[A], l2: List[A]): List[A] = {
    assert(l1.length == l2.length)

    val add = implicitly[Numeric[A]].plus _

    @annotation.tailrec
    def loop(l1: List[A], l2: List[A], s: List[A]): List[A] = {

      (l1, l2) match {
	case (Nil, _) => s
	case (_, Nil) => s
	case (h1::t1, h2::t2) => loop(t1,t2,s :+ add(h1,h2))
      }
    }    

    loop(l1,l2,Nil)
  }
}
