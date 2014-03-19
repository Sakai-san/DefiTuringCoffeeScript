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
  def isPrime(n: BigInt): Boolean = {
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
    isPandigital	tells if n is a pandigital number, namely all digits different from 1 to n length
    arg				n BigInt
    return			Boolean
  */
  def isPandigital(n :BigInt): Boolean = {
    // generate a 1 to n list and compare it with the sorted n transformed in string
   (1 to n.toString.length).toList.toString.equals( n.toString.toList.sorted.toString)
  } 
  
  
  /*
    seqPalindrome	gets the palindrome seq but only seq whose size <= 51
    arg				Int
    return			List[Int]
  */
  def seqPalindrome(n: BigInt, seq: List[BigInt]): List[BigInt] = {

    if (isPalindrome(n.toString)) seq

//    else if (seq.length >= 51)
	else if (seq.length >= 14)
		seq

    else {
      // process finish
      if (isPalindrome(( BigInt(seq.head.toString.reverse) + seq.head).toString))
        List( BigInt(seq.head.toString.reverse.toInt) ) ::: seq
      // process not yet finish
      else
        seqPalindrome(n, List( BigInt(seq.head.toString.reverse) + seq.head) ::: seq)
    }
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

  def sumFactoDigitConcise(numberString: String): BigInt = numberString.map(i => factorial(BigInt(i.toString))).sum

  def allDigitDifferent(numberString: String): Boolean = numberString.distinct.length == 9

  /*
	powerSumEqualToNumber tell if the sum of the digit to the power p, is equal to the number itself
	arg			n BigInt, p Double
	return		Boolean
   */
  def powerSumEqualToNumber(n: BigInt, p: Double): Boolean = n.toString.map(i => Math.pow(i.toString.toDouble, p).toInt).sum == n

  /*
	powerSum			Compute the SUM(x^n) from n=1 to n
	arg					BigInt
	return				BigInt
   */

  def powerSum(x: BigInt, n: BigInt): BigInt = {
    (1 - x.pow((n + 1).toInt)) / (1 - x) - 1
  }

  /*
	powerSumAll			Compute the SUM(x^x) from x=1 to n
	arg					BigInt
	return				BigInt
   */

  def powerSumAll(n: BigInt): BigInt = {
    if (n == 0) 0
    else
      n.pow(n.toInt) + powerSumAll(n - 1)
  }

  def mirror(n: Int) = n.toString.reverse.toInt

  /*
	circlePermutations		gives all permutations of a number
	arg						n BigInt
	return					List[BigInt]
   */
  def circlePermutations(n: BigInt): List[BigInt] = {
    val nbPerm = n.toString.length - 1
    def perm(lst: List[BigInt], nPerm: Int): List[BigInt] = {
      if (nPerm == 0)
        lst
      else
        perm(List(BigInt((lst.head.toString.toList.tail ::: List(lst.head.toString.toList.head)).mkString(""))) ::: lst, nPerm - 1)
    }
    perm(List(n), nbPerm)
  }

  /*
	syracuse		gets the syracuse sequence of n
	arg				n BigInt
	return			List[BigInt]
   */
  def syracuse(n: BigInt): List[BigInt] = {

    def auxSyrac(seq: List[BigInt]): List[BigInt] = {
      if (seq.head == 1) seq
      else {
        if (seq.head % 2 == 0) auxSyrac(List(seq.head / 2) ::: seq)
        else auxSyrac(List(3 * seq.head + 1) ::: seq)
      }
    }
    auxSyrac(List(n))
  }

  /*
	syracuseLength	gets the length of the syracuse sequence of n	
	arg				n BigInt
	return			Int
   */
  def syracuseLength(n: BigInt): Int = syracuse(n).length

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

  /*
	isChunkDividable		test if all left substring of n are dividable according to its related size (eg. 321, 321 % 3 == 0 && 32 % 2 == 0 && 3 % 1 == 0 returns true)  
	arg						n BigInt
	return					Boolean
   */
  def isChunkDividable(n: BigInt): Boolean = {

    def recCheck(offset: Int): Boolean = {
      if (offset == 1) true
      else {
        BigInt(n.toString.substring(0, offset)) % offset == 0 && recCheck(offset - 1)
      }
    }

    recCheck(n.toString.length)
  }

  /*
	isPrimeTruncLeft		
	arg						n BigInt
	return					Boolean
   */
  def isPrimeTruncLeft(n: BigInt): Boolean = {
    if (n.toString.length == 1)
      isPrime(n)
    else if (!isPrime(n)) false
    else true && isPrimeTruncLeft(BigInt(n.toString.tail))
  }

  /*
	isPrimeTruncRight		
	arg						n BigInt
	return					Boolean
   */
  def isPrimeTruncRight(n: BigInt): Boolean = {
    if (n.toString.length == 1)
      isPrime(n)
    else if (!isPrime(n)) false
    else true && isPrimeTruncRight(BigInt(n.toString.substring(0, n.toString.length - 1)))
  }

  def isPrimeTrunc(n: BigInt): Boolean = {
    isPrimeTruncLeft(n) && isPrimeTruncRight(n)
  }

}