sum_5_or_7 = (start, end )->
  if  start > end then return 0
  else
    if start % 5 == 0 or start % 7 == 0
      return start + sum_5_or_7(start + 1, end)
    else
      return sum_5_or_7( start + 1, end )

console.log( sum_5_or_7(0, 2013) )

# better way (inclusion-exclusion principle)
sum_to_n = (n) ->
	n * (n+1) /2

sumMultiples = (limit, a) ->
  sum_to_n( (limit-1) // a ) *a 

console.log( sumMultiples(2013, 5) + sumMultiples(2013, 7) - sumMultiples(2013, 35) )

# response 636456