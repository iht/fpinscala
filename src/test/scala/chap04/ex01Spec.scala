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
// Test for example 4.01
// ---------------------

package chap04

// For this exercise, the implementation of all the functions can be
// found in src/main/scala/errorhandling/Option.scala


import org.specs2.mutable._
import errorhandling._

object Ex01Spec extends Specification {
  "The map function" should {
    "return None with any None" in {
      val x: Option[Double] = None
      x.map(_*2) mustEqual None
    }

    "work with Some" in {
      Some(6).map(_.toDouble) mustEqual Some(6.0)
    }    
  }

  "The getOrElse function" should {
    "return a default val with None" in {
      val x: Option[Int] = None
      None.getOrElse(-5) mustEqual -5
    }

    "work with Some" in {
      Some(8).getOrElse(14) mustEqual 8
    }
  }

  "The flatMap function" should {
    "return None with None" in {
      val x: Option[Double] = None
      x.flatMap(x => Some(x*9)) mustEqual None      
    }

    "return the content with Some" in {
      Some(7).flatMap(x => Some(x*2)) mustEqual Some(14)
    }
  }


  "The orElse function" should {
    "work with None" in {
      val x: Option[Double] = None
      x.orElse(Some(7.56)) mustEqual Some(7.56)
    }

    "return the same Some with Some" in {
      Some(7).orElse(Some(12)) mustEqual Some(7)
    }
  }

  "The filter function" should {
    "return None with None" in {
      val x: Option[Double] = None
      x.filter(_ == 14) mustEqual None
    }

    "return None if filter does not match" in {
      Some(9.8).filter(_ == 10.0) mustEqual None
    }

    "return Some when filter matches" in {
      Some(9).filter(_%3 == 0) mustEqual Some(9)
    }
  }    
}










