package chap2

object FibonacciApp extends App {
  val x = args(0).toInt

  println("The Fibonacci number at %d is %d".format(x, fibo(x)))

  def fibo(n: Int): Int = {

    @annotation.tailrec
    def go(a: Int, b: Int, f: Int): Int = {
      if (f == 0) b
      else if(f == 1) b
      else go(b, a+b, f-1)
    }

    go(0, 1, n+1)
  }
}
