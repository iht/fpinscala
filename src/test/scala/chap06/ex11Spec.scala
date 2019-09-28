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
// Test for example 6.11
// ---------------------

package chap06

import org.specs2.mutable._
import rng._

object Ex11Spec extends Specification {

  val co = Coin
  val tu = Turn

  "Machine ignore all inputs if no candy" in {
    val nocandy_locked   = Machine(true,0,3)
    val nocandy_unlocked = Machine(false,0,7)
  
    nocandy_locked.update(co) mustEqual nocandy_locked
    nocandy_unlocked.update(co) mustEqual nocandy_unlocked

    nocandy_locked.update(tu) mustEqual nocandy_locked
    nocandy_unlocked.update(tu) mustEqual nocandy_unlocked
  }

  "Machine delivers candy and locks if unlocked" in {
    val m = Machine(false,7,0)
    m.update(tu) mustEqual Machine(true,6,0)
  }

  "Machine does not deliver candy if locked" in {
    val m = Machine(true,7,4)

    m.update(tu) mustEqual m
  }

  "Machine unlocks if coin is introduced" in {
    val m = Machine(true,7,4)

    m.update(co) mustEqual Machine(false,7,5)
  }

  "Machine ignores coin if unlocked" in {
    val m = Machine(false,7,2)

    m.update(co) mustEqual m
  }

  "Simulate machine does nothing with empty input" in {
    val is: List[Input] = Nil
    val m = Machine(true,4,5)

    val r = m.simulateMachine(is)

    r.run(m) mustEqual ((m.candies,m.coins),m)
  }

  "Simulate machine with no candies" in {
    val is = List(co,tu,co,tu,co,co,tu,tu,co)
    val m = Machine(true,0,7)

    val r = m.simulateMachine(is)

    r.run(m)._1 mustEqual (0,7)

    done
  }

  "Simulate machine keeps the right track of events" in {
    val is = List(co,tu,co,tu,co)
    val m = Machine(true,4,5)

    val r = m.simulateMachine(is)

    r.run(m)._1 mustEqual (2,8)

    done
  }
}
