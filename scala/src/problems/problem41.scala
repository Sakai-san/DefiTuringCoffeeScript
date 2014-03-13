package problems

import lib.Mathematics

object problem41 extends App {

 
  println(  ( BigInt(999999999) to BigInt(111111111) by -2 ).filter( k=> !k.toString.contains("0") && k.toString.toList.distinct.length == 9 && Mathematics.isPrime(k)  ) )

  // response 
}