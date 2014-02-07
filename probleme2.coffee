generate_fibo = ( list, limit ) ->
  # get the two last element
  previous = list[list.length-2]
  last =list[list.length-1]
  next = previous + last
  
  if next > limit
    return list
  else
    return generate_fibo( list.concat( [next] ), limit )

sum_odd = (lst) ->
  total = 0
  for el in lst
    if el % 2 != 0
      total += el 
  return total

console.log( sum_odd (generate_fibo([1,1], 4000000 ) ) )
# 4613732