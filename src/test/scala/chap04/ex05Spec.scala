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
// Test for example 4.05
// ---------------------

package chap04

import org.specs2.mutable._
import errorhandling._

object Ex05Spec extends Specification {

  "The traverse function" should {
    "return None with an empty List" in {
      Ex05.traverse(Nil)(x => Some(x.toString)) mustEqual None
    }

    "return None with a list starting by None" in {
      val l = List(None,Some(1),Some(2),Some(3))
      Ex05.traverse(l)(identity) mustEqual None
    }

    "return None with a list ending in None" in {
      val l = List(Some(1),Some(2),Some(3),None)
      Ex05.traverse(l)(identity) mustEqual None
    }

    "return None with a list containing None" in {
      val l = List(Some(1),Some(2),None,Some(3),Some(4))
      Ex05.traverse(l)(identity) mustEqual None
    }

    "return a list of Ints given a list of Options" in {
      val l = List(Some(1),Some(2),Some(3),Some(4))
      Ex05.traverse(l)(identity) mustEqual Some(List(1,2,3,4))
    }

    "return an option of a list of Strings (Ints)" in {
      val l = List(1,2,3,4)
      Ex05.traverse(l)(x => Some(x.toString)) mustEqual Some(List("1","2","3","4"))
    }

    "return an option of a list of Strings (Doubles)" in {
      val l = List(1.,2.,3.,4.)
      Ex05.traverse(l)(x => Some(x.toString)) mustEqual Some(List("1.0","2.0","3.0","4.0"))
    }


  }

  "The sequence function" should {
    "return None with an empty List" in {
      Ex05.sequence(Nil) mustEqual None
    }

    "return None with a list starting by None" in {
      val l = List(None,Some(1),Some(2),Some(3))
      Ex05.sequence(l) mustEqual None
    }

    "return None with a list ending in None" in {
      val l = List(Some(1),Some(2),Some(3),None)
      Ex05.sequence(l) mustEqual None
    }

    "return None with a list containing None" in {
      val l = List(Some(1),Some(2),None,Some(3),Some(4))
      Ex05.sequence(l) mustEqual None
    }

    "return an option of a list of Ints" in {
      val l = List(Some(1),Some(2),Some(3),Some(4))
      Ex05.sequence(l) mustEqual Some(List(1,2,3,4))
    }

    "return an option of a list of Doubles" in {
      val l = List(Some(1.0),Some(2.0),Some(3.0),Some(4.0))
      Ex05.sequence(l) mustEqual Some(List(1.0,2.0,3.0,4.0))
    }

  }  
}
