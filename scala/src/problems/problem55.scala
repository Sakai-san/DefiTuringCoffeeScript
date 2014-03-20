package problems

import lib.Mathematics

object problem55 extends App {

//val palProcess =( BigInt(84) to BigInt(100) ).foreach( i=> { println( Mathematics.seqPalindrome( i, List(i) ) )  } )  

val palProcess =( BigInt(1) to BigInt(10000) ).filter( i=> Mathematics.isLynchrel(i) )
println( palProcess.length )

println( palProcess )
println( Mathematics.seqPalindrome( List(20) ))
// response 249 BUT big issue I DO NOT get this result
}