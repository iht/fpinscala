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
// Test for example 5.13
// ---------------------

package chap05

import org.specs2.mutable._
import adt._

object Ex13Spec extends Specification {
  "The map function" should {
    "return Empty with Empty stream" in {
      val e: Stream[Int] = Empty
      Ex13.map(e) {x:Int => x*2} mustEqual Empty
    }

    "return a stream of Ints" in {
      Ex13.map(Stream(1,2,3,5)) {x:Int => x*3}.toList mustEqual Stream(3,6,9,15).toList
    }

    "return a stream of Doubles" in {
      Ex13.map(Stream(1.0,2.0,3.0,5.0)) {x: Double => x*4.0}.toList mustEqual Stream(4.0, 8.0, 12.0, 20.0).toList
    }
  }

  "The take function" should {
    "return Nil with Empty stream" in {
      Ex13.take(Empty,1).toList mustEqual Empty.toList
    }

    "return a list of Ints" in {
      Ex13.take(Stream(1,2,3,5),3).toList mustEqual Stream(1,2,3).toList
    }

    "return a list of Double" in {
      Ex13.take(Stream(1.2,2.3,3.5),2).toList mustEqual Stream(1.2,2.3).toList
    }

    "return a list of Options" in {
      Ex13.take(Stream(None,Some(1),None,Some(2),None,Some(3)),0).toList mustEqual Empty.toList
    }
  }

  "The takeWhile function" should {
    "return Nil with Empty stream" in {
      val e: Stream[Int] = Empty
      Ex13.takeWhile(e){ x: Int => x % 2 == 0}.toList mustEqual Empty.toList
    }

    "return a stream of Ints" in {
      Ex13.takeWhile(Stream(1,2,3,5)){ x:Int => x % 2 != 0}.toList mustEqual Stream(1).toList
    }

    "return a stream of Double" in {
      Ex13.takeWhile(Stream(1.2,2.3,5.5,4.7,2.1)){ x:Double => x<4.0}.toList mustEqual Stream(1.2,2.3).toList
    }

    "return a stream of Options" in {
      Ex13.takeWhile(Stream(None,Some(1),None,Some(2),None,Some(3))){ x => x.isEmpty}.toList mustEqual Stream(None).toList
    }

    "return an empty stream" in {
      Ex13.takeWhile(Stream(1,2,3,5)){ x:Int => x % 2 == 0}.toList mustEqual Empty.toList
    }
  }

  "The zipWith function" should {
    "return Empty with Empty streams" in {
      val x: Stream[Int] = Empty
      Ex13.zipWith(x,x)(_+_) mustEqual Empty
    }

    "return the sum of Int" in {
      val x = Stream(1,2,3,4,5,7)
      val y = Stream(2,3,4,6,7,1)
      Ex13.zipWith(x,y)(_+_).toList mustEqual List(3,5,7,10,12,8)
    }
  }

  "The zipAll function" should {
    "return Empty with Empty streams" in {
      Ex13.zipAll(Empty,Empty) mustEqual Empty
    }

    "return None when one stream is exhausted" in {
      val x = Stream(1,2,3)
      val y = Stream(2,3,4,6,7)

      Ex13.zipAll(x,y).toList mustEqual List((Some(1),Some(2)),
        (Some(2),Some(3)),
        (Some(3),Some(4)),
        (None,Some(6)),
        (None,Some(7)))

      Ex13.zipAll(y,x).toList mustEqual List((Some(2),Some(1)),
        (Some(3),Some(2)),
        (Some(4),Some(3)),
        (Some(6),None),
        (Some(7),None))
    }
  }
}
