package problems

import lib.Mathematics

object problem48 extends App {

  val to		= 2013

  val sumpower = Mathematics.powerSum( to )
  println( Mathematics.powerSum( to ) )

  println( sumpower.toString.substring(0, 10) )
  // response 443839
}

