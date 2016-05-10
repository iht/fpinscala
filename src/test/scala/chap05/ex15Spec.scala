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
// Test for example 5.15
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex15Spec extends Specification {
  "The tails function" should {
    "return Empty with Empty" in {
      Ex15.tails(Empty) mustEqual Empty
    }

    "return subseqs" in {
      val x = Stream(1,2,3,4)

      Ex15.tails(x).toList.map(_.toList) mustEqual List(
        List(1,2,3,4),
        List(2,3,4),
        List(3,4),
        List(4))

      val y = Stream(1,2)

      Ex15.tails(y).toList.map(_.toList) mustEqual List(
        List(1,2),
        List(2))

      val z = Stream(1)

      Ex15.tails(z).toList.map(_.toList) mustEqual List(
        List(1))
    }
  }
}
