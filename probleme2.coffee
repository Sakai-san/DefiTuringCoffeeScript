###generate_fibo = ( list, limit ) ->
  # get the two last element
  previous = list[list.length-2]
  last = list[list.length-1]
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

console.log( sum_odd (generate_fibo([1,1], 4000000 ) ) )###

# 4613732

#better way to do this

sum_odd_fibonacci = (limit) ->
  ante_term = 1
  prev_term = 1
  current_term = 0
  sum_odd = 0

  loop
    current_term = ante_term + prev_term
    console.log("current term is ", current_term )
    ante_term = prev_term
    prev_term = current_term
    next_term = ante_term + prev_term
    break if next_term > limit
    sum_odd += current_term if current_term % 2 == 1

  # do not forget the two firsts initial terms. 
  sum_odd + 1 + 1

console.log( sum_odd_fibonacci(4000000) )