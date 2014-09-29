/* Copyright (c) 2014 Israel Herraiz <isra@herraiz.org>
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

// --------------------
// Code for example 2.2
// --------------------

package chap2

object Sorted extends App {
  // Check if input is sorted from greater to minor
  // Input args must be integers space separated
  // e.g. runMain chap2.SortedApp 5 6 1 2 4 5 1
  val input = args.map(_.toInt)

  // Use to check order from greater to minor
  val sortFunc = (a: Int, b: Int) => a>=b

  // Use to check order from minor to greater
  // val sortFunc = (a: Int, b: Int) => a<=b

  val output = isSorted(input, sortFunc) match {
    case true =>
      "is sorted from greater to minor"
    case false =>
      "is not sorted from greater to minor"
  }
  
  println("The list %s %s".format(input.mkString(","), output))

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int, s: Boolean): Boolean = {
      if (n >= as.length - 1) s
      else loop(n + 1, s && ordered(as(n), as(n+1)))
    }

    loop(0, true)
  }
}
