sum_5_or_7 = (start, end ) ->
  if  start > end then return 0
  else
    if start % 5 == 0 or start % 7 == 0
      return start + sum_5_or_7(start + 1, end)
    else
      return sum_5_or_7( start + 1, end )

console.log( sum_5_or_7(0, 2013) )

# response * 636456