package chap2

import org.specs2.mutable._
import chap2.FibonacciApp.fibo

object FibonacciSpec extends Specification {
  "FibonacciApp" should {
    "calculate the nth position of the Fibonacci sequence" in {
      fibo(0) mustEqual 1
      fibo(1) mustEqual 1
      fibo(2) mustEqual 2
      fibo(3) mustEqual 3
      fibo(4) mustEqual 5
      fibo(5) mustEqual 8
    }
  }
}










