package lib
import BigInt._
object Mathematics {

  def intSqrt(n: BigInt) = {
    def trial(m: BigInt): BigInt = {
      val q = n / m
      if (q >= m)
        m
      else
        trial((m + q) / 2)
    }
    trial(n / 2)
  }

  /*
    getFactors gives all factors of an integer
    arg			n integer
    return		List of factors
   */
  def getFactors(n: BigInt) = {

    //    var rootN = Math.floor( Math.sqrt(n) ).toInt
    var rootN = intSqrt(n)
    var factor = List[BigInt]()

    for (i <- rootN to 1 by -1) {

      if (n % i == 0) {
        var quotien = n / i

        // for avoiding twice same nb (perfect root)
        if (quotien != i) {
          // push at the top
          factor = i :: factor
          // push at the end
          factor = factor ::: List(quotien)
        } // push at the top
        else {
          factor = i :: factor
        }
      }
    }
    factor
  }

  /*
    isPrime  tells if a integer is a prime number
    arg n     integer
    return    boolean
  */
  def isPrime(n: BigInt) = {
    var factors = getFactors(n)
    var noDividor = List(1, n)
    // if lists are same then n is a prime
    factors == noDividor
  }

  /*
    factorial gives the factorial number of an integer
    arg			n integer
    return		integer
   */
  def factorial(n: BigInt): BigInt = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
    tailRecursiveFactorial gives the factorial number of an integer
    arg			n integer
    return		integer
   */
  def tailRecursiveFactorial(n: Int) = {

    def fac(accumulator: Int, currentRank: Int): Int = {
      if (currentRank == n) accumulator
      else
        fac(accumulator * currentRank, currentRank + 1)
    }
    fac(n, 1)
  }

  /*
    isPalidrome tells if a number-string is a palindrome
    arg			numberString string
    return		boolean
  */
  def isPalindrome(numberString: String): Boolean = {
    if (numberString.length <= 1) true
    else if (numberString.substring(0,1) == numberString.takeRight(1)  )
      isPalindrome(numberString.substring(1, numberString.length - 1))
    else false
  }

  /*
	sum gives the sum of integer from 0 to n
	arg			n integer
	return		integer
   */
  def sumToN(n: Int) = n * (n + 1) / 2

  /*
	sumDigit gives the sum of digit an integer is composed of
	arg			numberString string
	return		integer
   */
  def sumDigit(numberString: String): Int = {
    if (numberString.length == 0) 0
    else
      numberString.substring(0,1).toInt + sumDigit(numberString.substring(1, numberString.length))
  }

  
  
    def sumDigitConcise(numberString: String) = numberString.map(_.toString.toInt).sum
  
}