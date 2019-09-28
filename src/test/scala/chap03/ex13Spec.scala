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
// Test for example 3.13
// ---------------------

package chap03

import org.specs2.mutable._

object Ex13Spec extends Specification {
  "The foldRight function" should {
    "behave like foldLeft with empty lists" in {
      Ex13.foldRight(Nil: List[Int], 0)(_+_) mustEqual Ex10.foldLeft(Nil: List[Int],0)(_+_)
    }

    "behave like List's foldRight with empty lists" in {
      Ex13.foldRight(Nil: List[Int], 0)(_+_) mustEqual (Nil: List[Int]).foldRight(0)(_+_)
    }

    "behave like foldLeft reversedly with non-empty lists" in {
      Ex13.foldRight(List(1,3,5,4),Nil: List[Int]) {
        (x,y) => x :: y
      } mustEqual Ex10.foldLeft(List(4,5,3,1),Nil: List[Int]) {
        (x,y) => y :: x
      }
    }

    "behave like List's foldRight with non-empty lists" in {
      Ex13.foldRight(List(1,2),List(3,4)) {
        (x,y) => x :: y
      } mustEqual (List(1,2)).foldRight(List(3,4)) {
        (x,y) => x :: y
      }
    }

  }

  "The foldLeft function" should {
    "behave like foldLeft (ex. 10) with empty lists" in {
      Ex13.foldLeft(Nil: List[Int], 0)(_+_) mustEqual Ex10.foldLeft(Nil: List[Int],0)(_+_)
    }

    "behave like foldLeft (ex. 10) with non-empty lists" in {
      Ex13.foldLeft(List(1,3,5,4),Nil: List[Int]) {
        (x,y) => y :: x
      } mustEqual Ex10.foldLeft(List(1,3,5,4),Nil: List[Int]) {
        (x,y) => y :: x
      }
    }

    "behave like List's foldLeft with empty lists" in {
      Ex13.foldLeft(Nil: List[Int], 0)(_+_) mustEqual (Nil: List[Int]).foldLeft(0)(_+_)
    }
    
    "behave like List's foldLeft with non-empty lists" in {
      Ex13.foldLeft(List(1,2),List(3,4)) {
        (x,y) => y :: x
      } mustEqual (List(1,2)).foldLeft(List(3,4)) {
        (x,y) => y :: x
      }
    }
  }
}
