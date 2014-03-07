package lib
import BigInt._
object Mathematics {

  
  
    /*
    sqrt 			gives the integer sqrt of number
    arg				number BigInt
    return			BigInt
   */
  
  def sqrt(number: BigInt) = {
    def next(n: BigInt, i: BigInt): BigInt = (n + i / n) >> 1

    val one = BigInt(1)

    var n = one
    var n1 = next(n, number)

    while ((n1 - n).abs > one) {
      n = n1
      n1 = next(n, number)
    }

    while (n1 * n1 > number) {
      n1 -= one
    }

    n1
  }

  
  
  /*
    getFactors 		gives all factors of n
    arg				n BigInt
    return			List[BigInt]
   */
  def getFactors(n: BigInt) = {

    // var rootN = Math.floor( Math.sqrt(n) ).toInt
    var rootN = sqrt(n)

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
    isPrime		tells if n is a prime number
    arg			n BigInt
    return		Boolean
  */
  def isPrime(n: BigInt) = {
    var factors = getFactors(n)
    var noDividor = List(1, n)
    // if lists are same then n is a prime
    factors == noDividor
  }

  
  /*
    factorial gives the factorial number of an integer
    arg			n Integer
    return		Integer
   */
  def factorial(n: BigInt): BigInt = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  
  /*
    tailRecursiveFactorial gives the factorial number of an integer
    arg			n Int
    return		Int
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
    arg			numberString String
    return		Boolean
  */
  def isPalindrome(numberString: String): Boolean = {
    if (numberString.length <= 1) true
    else if (numberString.substring(0, 1) == numberString.takeRight(1))
      isPalindrome(numberString.substring(1, numberString.length - 1))
    else false
  }

  
  /*
	sum gives the sum of integer from 0 to n
	arg			n Int
	return		Int
   */
  def sumToN(n: Int) = n * (n + 1) / 2

  
  /*
	sumDigit gives the sum of digit an integer is composed of
	arg			numberString String
	return		Int
   */
  def sumDigit(numberString: String): Int = {
    if (numberString.length == 0) 0
    else
      numberString.substring(0, 1).toInt + sumDigit(numberString.substring(1, numberString.length))
  }

  def sumDigitConcise(numberString: String) = numberString.map(i => i.toString.toInt).sum
  
  
  
  def sumFactoDigitConcise(numberString: String):BigInt = numberString.map(i => factorial(BigInt( i.toString)) ).sum

   
  
  def allDigitDifferent(numberString: String):Boolean = numberString.distinct.length == 9
  
  
  /*
	powerSumEqualToNumber tell if the sum of the digit to the power p, is equal to the number itself
	arg			n BigInt, p Double
	return		Boolean
   */
  def powerSumEqualToNumber(n: BigInt, p: Double): Boolean = n.toString.map(i => Math.pow(i.toString.toDouble, p).toInt).sum == n

  
  
  def mirror(n: Int) = n.toString.reverse.toInt

  
  
    /*
	isAbundant		tell if n is an abundant number, namely if the sum of its proper factors is bigger that n itself
	arg				n BigInt
	return			Boolean
   */
  def isAbundant(n: BigInt): Boolean = {
    val factors = getFactors(n)
    val realfactors = factors.reverse.tail
    realfactors.sum > n
  }
}