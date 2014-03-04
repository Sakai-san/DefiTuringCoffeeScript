package problems

import lib.Mathematics

object problem17 extends App {

val low = BigInt(1)
  val up = BigInt(100000)
  
 var dfactors = List[List[BigInt]]()
 ( low  to up  ).foreach( i =>
 									{
   										val factors = Mathematics.getFactors(i)
   										if ( factors.length > 2 ){
   										  // remove the last one
   											var d = factors.reverse.tail
   											dfactors = dfactors ::: List( List[BigInt]( i, d.sum) )
   										}
 								}
		 				)


var friends = List[BigInt]()
dfactors.foreach(  i => {
							dfactors.foreach( 
											j => {
												if( i.head != j.head && i.head == j.tail.head && i.tail.head == j.head  )
													friends =  i.head :: friends
												}
											)
									}
							)

println(friends.sum ) 
// response 852810

}