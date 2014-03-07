package problems
import scala.util.control._

object problem31 extends App {

  val a1Min = 0
  val a1Max = 2

  val a2Min = 0
  val a2Max = 5

  val a3Min = 0
  val a3Max = 10

  val a4Min = 0
  val a4Max = 20

  val a5Min = 0
  val a5Max = 50

  val a6Min = 0
  val a6Max = 100

  val a7Min = 0
  val a7Max = 200

  val (coin1, coin2, coin3, coin4, coin5, coin6, coin7) = (5, 2, 1, 0.5, 0.2, 0.1, 0.05)

  val total = 10
  
   val outer = new Breaks;
      val inner = new Breaks;

  var solutionsNb = 0
      
  
  
outer.breakable {
  for( d <- 0 to 10 ){
    println( "d =" + d )
            inner.breakable{for ( e <- 11 to 20 ){
	            println( "e =" + e )
		        if ( e > 14 ) inner.break
		        
		         inner.breakable{for ( f <- 21 to 30 ){
	            	println( "f =" + f )
	            }
	      }
        }
	}
  }
}
    var ( i, j, k, l, m, n, o ) = ( a1Min, a2Min, a3Min, a4Min, a5Min, a6Min, a7Min )
    while( i <= a1Max) {				        
	      while ( j <= a2Max){
	        if (i * coin1 + j * coin2  > total) j=a2Max+1
	        
	        while( k <= a3Max){
	        	if (i * coin1 + j * coin2  + k * coin3  > total) k=a3Max+1
	        	
		        while (l <= a4Max){
		          if (i * coin1 + j * coin2  + k * coin3 + l * coin4  > total) l=a4Max+1
		       
		          while ( m <= a5Max){
		           if (i * coin1 + j * coin2  + k * coin3 + l * coin4 + m * coin5  > total) m=a5Max+1
		           
		           	while ( n <= a6Max){
		           	if (i * coin1 + j * coin2  + k * coin3 + l * coin4 + m * coin5 + n * coin6  > total) n=a6Max+1
		           	 
		           	while  ( o <= a7Max){
		           	  	 if (i * coin1 + j * coin2  + k * coin3 + l * coin4 + m * coin5 + n * coin6 + o * coin7 > total) o=a6Max+1
		           	  	 
		           	  	 else if (i * coin1 + j * coin2 + k * coin3 + l * coin4 + m * coin5 + n * coin6 + o * coin7 == total)
		                    solutionsNb += 1
		              o +=1
		              }
		           	 n +=1
		             }
		            m +=1
		        	}
		           l +=1
		         }
	        	 k +=1
		        }
	         j +=1
	      }
	    i +=1
	}

  println(s"total nb of combinations : $solutionsNb")
  // response wrong 92564
}