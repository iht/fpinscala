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
// Code for example 3.11
// ---------------------

package chap03

import scala.math.Numeric

object Ex11 {

  def sum[A: Numeric](l: List[A]): A = {
    val z: A = implicitly[Numeric[A]].zero
    val aSum = implicitly[Numeric[A]].plus _
    Ex10.foldLeft(l,z)(aSum(_,_))
  }

  def product[A: Numeric](l: List[A]): A = {
    val one: A = implicitly[Numeric[A]].one
    val aProduct = implicitly[Numeric[A]].times _
    Ex10.foldLeft(l,one)(aProduct(_,_))
  }
 
  def length[A](l: List[A]): Int = {
    Ex10.foldLeft(l, 0) ((x,y) => x + 1)
  }
}
