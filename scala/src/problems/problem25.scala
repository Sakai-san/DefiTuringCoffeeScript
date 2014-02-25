package problems

import scala.util.control.Breaks

object problem25 extends App {

  var ante_term = 1
  var prev_term = 1
  var current_term = 0
  var rank = 3
  val size = 3

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      current_term = ante_term + prev_term
      println("current term is " + current_term)
      ante_term = prev_term
      prev_term = current_term
      if (current_term.toString.length >= size) {
        Outer.break;
      }
      rank = rank + 1
    }
  }

  println( "fibonacci term's rank : " + rank)
  
  // response 
}