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
// Test for example 5.07
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex07Spec extends Specification {
  "The map function" should {
    "return Empty with Empty stream" in {
      val e: Stream[Int] = Empty
      e.map(_*2) mustEqual Empty
    }

    "return a stream of Ints" in {
      Stream(1,2,3,5).map(_*3).toList mustEqual Stream(3,6,9,15).toList
    }

    "return a stream of Doubles" in {
      Stream(1.0,2.0,3.0,5.0).map(_*4.0).toList mustEqual Stream(4.0, 8.0, 12.0, 20.0).toList
    }
  }

  "The filter function" should {
    "return Empty with Empty stream" in {
      val e: Stream[Int] = Empty
      e.filter(_%2 == 0) mustEqual Empty
    }

    "return a stream of Ints" in {
      Stream(1,2,3,5).filter(_%2 != 0).toList mustEqual Stream(1,3,5).toList
    }

    "return a stream of Doubles" in {
      Stream(1.0,2.0,3.0,5.0).filter(_>2.1).toList mustEqual Stream(3.0,5.0).toList
    }

    "return Empty if no element matches" in {
      Stream(1.0,2.0,3.0,5.0).filter(_>21.1).toList mustEqual Empty.toList
    }  
  }

  "The append function" should {
    "return Empty with two Empty" in {
      Empty.append(Empty) mustEqual Empty
    }

    "return the same stream appending Empty" in {
      Stream(1,2,3).append(Empty).toList mustEqual Stream(1,2,3).toList
      Empty.append(Stream(1,2,3)).toList mustEqual Stream(1,2,3).toList
    }

    "return a new stream" in {
      Stream(1,2,3).append(Stream(4,5)).toList mustEqual Stream(1,2,3,4,5).toList
    }
  }

  "The flatMap function" should {
    "return Empty with Empty" in {
      Empty.flatMap(x => Stream(x,x)) mustEqual Empty
    }

    "return the Empty with a function returning Empty" in {
      Stream(1,2,3).flatMap(x => Empty) mustEqual Empty
    }

    "return a concatenated stream" in {
      Stream(1,2,3,5).flatMap(x => Stream(x,x*2)).toList mustEqual Stream(1,2,2,4,3,6,5,10).toList      
    }
  }

}
