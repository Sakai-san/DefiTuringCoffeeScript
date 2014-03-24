package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem1 extends App {
  
  // returns the some of 5 and 7 factors from the start to end range
  def sum5And7(start: Int, end: Int): Int = {
    if (start > end) 0
    else if (start % 5 == 0 || start % 7 == 0) start + sum5And7(start + 1, end)
    else sum5And7(start + 1, end)
  }

  println(sum5And7(0, 2013))

  // better way (inclusion-exclusion principle)
  def sumMultiples(limit: Int, a: Int) = {
    Mathematics.sumToN(Math.floor((limit - 1) / a).toInt) * a
  }

  println(sumMultiples(2013, 5) + sumMultiples(2013, 7) - sumMultiples(2013, 35))

  // response 636456
}