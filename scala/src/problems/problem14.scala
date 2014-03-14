package problems

import lib.Mathematics
import scala.collection.mutable.HashMap

	object problem14 extends App {

  
  // With memoization, hashMap : number => syracuse length
  val memo = HashMap[Int, Int]()
  
  def syracLength(n: Int): Int = {
    def memoSyrac(i: Int): Int =
      memo.getOrElseUpdate(i, syracLength(i))

    if (n  == 1)
      1
    else
      // even 
      if( n % 2 == 0 ) 1 + memoSyrac( n / 2 )
      // odd
      else 1 + memoSyrac( 3* n +1 )
  }
  
println( syracLength(2248958)  )
// response is not 2248958
println( (1498000 to 1499999).map(i => (i,syracLength(i)) ).max )
 // println(memo)
 
}