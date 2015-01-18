/* Copyright (c) 2105 Israel Herraiz <isra@herraiz.org>
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
// Code for example 3.24
// ---------------------

package chap03

object Ex24 {
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean =
  {

    (sup,sub) match {
      case (_,Nil) => true
      case (Nil, _) => false
      case (suph::supt,subh::subt) =>

	@annotation.tailrec
	def loop(sup1: List[A], sub1: List[A], isSub: Boolean): Boolean = {
	isSub match {
	  case false => false
	  case true => 
	    (sup1, sub1) match {
	      case (_,Nil) => isSub // Exhausted subseq
	      case (Nil, _) => false // Exhausted list
	      case (h1::t1, h2::t2) => 
		loop(t1, t2, (h1 == h2) && isSub)
	    }
	}
      }	  
	val starth :: startt = Ex05.dropWhile(sup, {x:A => x != subh})
	loop(startt, subt, subh == starth)

    }
  }  
}
