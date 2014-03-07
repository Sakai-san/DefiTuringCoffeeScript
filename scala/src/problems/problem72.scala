package problems

import lib.Mathematics

object problem72 extends App {

  val up = Mathematics.sqrt( 1000000000 )
  val low = BigInt( 0 )

 val same3LastDigits = ( low to up ).filter( i => (i*i).toString.length >=3 && (i*i).toString.substring( (i*i).toString.length-3, (i*i).toString.length).distinct.length == 3 )
 
 // has to remove all the 13499999 since more than 3 identical

 println( same3LastDigits )
 val size = same3LastDigits.length
 
  println(s"how many such numbers  : $size")
  // response 854
  
  val k = 984751243
  println( "last three car " + k.toString.substring( k.toString.length-3,k.toString.length))
  
}