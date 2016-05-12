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

// ------------------------------
// Test for examples of chapter 7
// ------------------------------

package chap07

import org.specs2.mutable._

class ParSpec extends Specification {

  "Par unit returns a Par for different data types" in {

    val a = Par.unit(2)
    val b = Par.unit("hi")
    val c = Par.unit(2.0)
    val d = Par.unit(a)

    a mustEqual Par(2)
    b mustEqual Par("hi")
    c mustEqual Par(2.0)
    d mustEqual Par(a)

    done
  }

  "Par get returns the right value" in {
    val a = Par.unit(2)
    val b = Par.unit("hi")
    val c = Par.unit(2.0)
    val d = Par.unit(a)

    Par.get(a) mustEqual 2
    Par.get(b) mustEqual "hi"
    Par.get(c) mustEqual 2.0
    Par.get(d) mustEqual a
    Par.get(Par.get(d)) mustEqual Par.get(a)

    done
  }

  "Par sums returns the sum of Integers" in {
    val x = IndexedSeq(1,-2,3,4,-5,6,1,1)
    val ps: Par[Int] = Par.sums(x)
    Par.get(ps) mustEqual x.sum

    done
  }

  "Par sums of empty Seq returns 0" in {
    val x: IndexedSeq[Int] = IndexedSeq()
    val ps: Par[Int] = Par.sums(x)
    Par.get(ps) mustEqual 0

    done
  }
}

class Ex01Spec extends Specification {
  "map2 returns a Par combining two different Pars" in {
    // Same type
    val l1: Par[Int] = Par.unit(3)
    val r1: Par[Int] = Par.unit(5)

    val m1: Par[Int] = Par.map2(l1,r1)(_*_)
    val m2: Par[Int] = Par.map2(r1,l1)(_+_)

    Par.get(m1) mustEqual 3*5
    Par.get(m2) mustEqual 3+5

    // Different types
    val r2: Par[Double] = Par.unit(4.5)

    val m3: Par[Double] = Par.map2(r2,l1)(_*_)
    val m4: Par[Double] = Par.map2(l1,r2)(_+_)

    Par.get(m3) mustEqual 4.5*3
    Par.get(m4) mustEqual 4.5+3

    // With lists
    val l3: Par[List[Int]] = Par.unit(List(2,3))
    val r3: Par[List[Int]] = Par.unit(List(4))

    val m5: Par[List[Int]] = Par.map2(l3,r3)(_++_)
    val m6: Par[List[Int]] = Par.map2(r3,l3)(_++_)

    Par.get(m5) mustEqual List(2,3,4)
    Par.get(m6) mustEqual List(4,2,3)

    // With three different types
    val l4: Par[Int] = Par(4)
    val r4: Par[Double] = Par(5.5)

    val m7: Par[String] = Par.map2(l4,r4)((x,y) => (x*y).toString)

    Par.get(m7) mustEqual (4*5.5).toString

    done
  }
}
