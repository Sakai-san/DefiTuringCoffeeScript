package problems

import lib.Mathematics

object problem15 extends App {

var biggestProdSum = 0
var smallestProdSum = 10000

// only try all permutations and stores the product sum if biggest or smallest then previous vector
List(1, 2, 3, 4, 5, 6, 7, 8, 9 ).permutations.foreach( i=>{ 
												val row1 = i.slice(0, 3)
												val row2 = i.slice(3, 6)
												val row3 = i.slice(6, 9)
												
												val col1 = List( row1(0), row2(0), row3(0) )
												val col2 = List( row1(1), row2(1), row3(1) )
												val col3 = List( row1(2), row2(2), row3(2) )
												
												val rows = List( row1, row2, row3)
												val cols = List( col1, col2, col3)
												
												val productSum = (rows.map( i=> i.product )).sum + (cols.map( i=> i.product )).sum
												biggestProdSum = if( productSum > biggestProdSum) productSum else biggestProdSum
												smallestProdSum = if( productSum < smallestProdSum) productSum else smallestProdSum
												}
											)
											
println( "product smallest * biggest = " + smallestProdSum * biggestProdSum)
// response 412892
}