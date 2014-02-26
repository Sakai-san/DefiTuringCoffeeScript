package problems

import lib.Mathematics._

object problem6 extends App {

  val fa2013 = factorial(2013)
  val fac2013Sum = sumDigitConcise( fa2013.toString )
  println( fa2013)
  println ( "fac2013Sum :" +  fac2013Sum )
  // response 24021
}
