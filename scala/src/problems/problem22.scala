package problems

import lib.Mathematics

object problem22 extends App {

  

(BigInt(111111) to BigInt(125000-1)).foreach(
		  				i => {
		  				  (BigInt(111111) to BigInt(125000-1)).foreach(
		  					j => {
		  					 if(
		  					i != j
		  					&& Mathematics.hashOfNumber(i) == Mathematics.hashOfNumber(i * 8)
		  					&& Mathematics.hashOfNumber(j) == Mathematics.hashOfNumber(j * 8)
		  					&& Mathematics.hashOfNumber(i) == Mathematics.hashOfNumber(j) )
		  					   println( "i = " +i +",j = " + j +", sum = " + (i+j))
		  				})
		  		} )
  
// response both number = i = 113967,j = 116397, sum = 230364
// can be optimized going out to the loop when found
}