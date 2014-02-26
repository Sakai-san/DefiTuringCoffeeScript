package problems
import lib.Mathematics._
import scala.util.control.Breaks

object problem7 extends App {

  var current_term = BigInt(3)
  var current_prime = BigInt(0)
  var rank = 1
  val size = 23456

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      if (rank >= size) Outer.break;
      if (isPrime(current_term)) {
        current_prime = current_term
        rank += 1
      }
      current_term += 2
    }

  }

  println("prime term's rank : " + rank + " prime : " + current_prime)

  // response 267649
}