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
// Test for example 3.14
// ---------------------

package chap03

import org.specs2.mutable._

object Ex14Spec extends Specification {
  "The appendRight function" should {
    "return Nil if Nil is passed" in {
      Ex14.appendRight(Nil, Nil) mustEqual Nil
    }

    "return the joined lists" in {
      Ex14.appendRight(List("h","i"), List("w","o","r","l","d")) mustEqual List("h","i","w","o","r","l","d")
    }
  }

  "The appendLeft function" should {
    "return Nil if Nil is passed" in {
      Ex14.appendLeft(Nil, Nil) mustEqual Nil
    }

    "return the joined lists" in {
      Ex14.appendLeft(List("h","i"), List("w","o","r","l","d")) mustEqual List("h","i","w","o","r","l","d")
    }
  }

  "The append function" should {
    "return Nil if Nil is passed" in {
      Ex14.append(Nil, Nil) mustEqual Nil
    }

    "return the joined lists" in {
      Ex14.append(List("h","i"), List("w","o","r","l","d")) mustEqual List("h","i","w","o","r","l","d")
    }
  }

}
