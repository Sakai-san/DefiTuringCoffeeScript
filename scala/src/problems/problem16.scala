package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem16 extends App {
  
 var combination1 = List[(Int, Int, Int)]()
 
 ( 99999 to 11111 by -9).foreach( 
				i => { ( 9999 to 1111 by -9 ).foreach(
								j =>{
								  val iString = i.toString
								  val jString = j.toString
								  val iList = iString.toList.distinct
								  val jList = jString.toList.distinct
								    if(
								     iList.length == 4 // a does have 4 different char
								     && jList.length == 3 // a does have 3 different char
								     && iString.charAt(3).equals( iString.charAt(4) ) // a(3) == a(4)
								     && iString.charAt(3).equals( jString.charAt(3) ) // a(3) == b(3)
								     && jString.charAt(0).equals( jString.charAt(2) ) // b(0) == b(2)
								     
								     && ! jList.contains( iString.charAt(0) ) // b does not contains "t"
								     && ! jList.contains( iString.charAt(1) ) // b does not contains "h"
								     && ! jList.contains( iString.charAt(2) ) // b does not contains "r"
								     && ! iList.contains( jString.charAt(0) ) // a does not contains "n"
								     && ! iList.contains( jString.charAt(1) ) // a does not contains "i"
								    )
								    combination1 =  combination1 ::: List( ( i*j, i, j ) ) 
								})
						}
				)
// println(combination1.toList)
//List((324162000,78300_4140), (188096904,37188_5058), (177274575,28755_6165), (348378651,86211_4041), (91222119,19233_4743)

def feasibleTuple( a :Int, b :Int, abProduct :Int, factorsList :List[BigInt] ) :List[BigInt] = {
	val c  = factorsList.head
	val d = factorsList.last
	val ( aString, bString, cString, dString ) = (a.toString, b.toString, c.toString, d.toString)
	val cList = cString.toList.distinct
	val dList = dString.toList.distinct
    
    if ( factorsList.isEmpty ) Nil;

    else if ( 
		 abProduct == c * d // product should be of course the same
		 && cList.length == 5 // all digit differents
	     && dList.length == 4 // all digit differents
	     && aString.charAt(0).equals( cString.charAt(0) ) // a(0) == c(0)
	     && aString.charAt(2).equals( cString.charAt(1) ) // a(2) == c(1)
	     && aString.charAt(3).equals( dString.charAt(1) ) // a(3) == d(1)
	     && bString.charAt(1).equals( cString.charAt(2) ) // b(1) == c(3)
	     && ! cList.contains( dString.charAt(0) ) // c does not contains "n"
	     && ! cList.contains( dString.charAt(1) ) // c does not contains "e"
	     && ! cList.contains( dString.charAt(2) ) // c does not contains "u"
	     && ! cList.contains( dString.charAt(3) ) // c does not contains "f"
	     && ! dList.contains( cString.charAt(0) ) // d does not contains "t"
	     && ! dList.contains( cString.charAt(1) ) // d does not contains "r"
	     && ! dList.contains( cString.charAt(2) ) // d does not contains "o"
	     && ! dList.contains( cString.charAt(2) ) // d does not contains "i"
	     && ! dList.contains( cString.charAt(3) ) // d does not contains "s"    
    	)
    	List( factorsList.head, factorsList.last )
    else
      feasibleTuple(   a, b, abProduct, factorsList.tail ::: factorsList.reverse.tail.reverse) 
  }
 
 
var fesableTuples = combination1.foreach ( triple => {

					feasibleTuple( triple._2, triple._3, triple._1, Mathematics.getFactors( triple._1 ))
  
})
println(fesableTuples )

 /*
( 99999 to 11111 by -3).foreach( 
				i => { ( 9999 to 1111 by -3 ).foreach(
								j =>{
								 val product = i *j
								 val iString = i.toString
								 val jString = j.toString
								 val iList = iString.toList.distinct
								 val jList = jString.toList.distinct
								     // c all differents && d all different

								 	if( iList.length == 5
								     && jList.length == 4

								     && ! iList.contains( j.toString.charAt(0) ) // c does not contains "n"
								     && ! iList.contains( j.toString.charAt(1) ) // c does not contains "e"
								     && ! iList.contains( j.toString.charAt(2) ) // c does not contains "u"
								     && ! iList.contains( j.toString.charAt(3) ) // c does not contains "f"
								     && ! jList.contains( i.toString.charAt(0) ) // d does not contains "t"
								     && ! jList.contains( i.toString.charAt(1) ) // d does not contains "r"
								     && ! jList.contains( i.toString.charAt(2) ) // d does not contains "o"
								     && ! jList.contains( i.toString.charAt(2) ) // d does not contains "i"
								     && ! jList.contains( i.toString.charAt(3) ) // d does not contains "s"
								     )
								    combination2.update( i*j, i + "_" + j )
								})
						}
				)
				
				
println( combination2.toList.length )
*/
  
  /*
  ( BigInt(a.toString() ) to BigInt(1) by -1 ).foreach{
	  i => println( i )
  } */
  
  
  
  /*
  val up = Mathematics.sqrt(99999)
  val low = Mathematics.sqrt(10000)

  val uniqueLeft = (low to up).filter(i => {
    val pow = i.pow(2)
    // S == S && I == I && TRO unique && X !belongs to TRO && left all diff && right all diff
    i.toString.substring(0, 1).equals(pow.toString.substring(pow.toString.length - 1, pow.toString.length)) &&
      i.toString.substring(1, 2).equals(pow.toString.substring(pow.toString.length - 2, pow.toString.length - 1)) &&
      !pow.toString.toList.distinct.contains(i.toString.substring(i.toString.length - 1, i.toString.length)) &&
      i.toString.toList.distinct.length == 3 &&
      pow.toString.toList.distinct.length == 5
  })

  println(uniqueLeft.head.pow(2))

  println(s"right equation  : $uniqueLeft")
  */
  // response 28561
}