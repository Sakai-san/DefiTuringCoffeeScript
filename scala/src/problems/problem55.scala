package problems

import lib.Mathematics

object problem55 extends App {

//val palProcess =( BigInt(84) to BigInt(100) ).foreach( i=> { println( Mathematics.seqPalindrome( i, List(i) ) )  } )  

val palProcess =( BigInt(1) to BigInt(9999) ).filter( i=> Mathematics.seqPalindrome( i, List(i) ).length >= 14 )
println( palProcess.length )

// response
}