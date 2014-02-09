decomposeFactor = (n) ->

  rootN = Math.floor( Math.sqrt(n))
  factor = []

  for i in [rootN..1]
    if n % i == 0
      quotien =  n / i
      # for avoiding twice same nb (perfect root)
      if quotien != i
        factor.unshift i
        factor.push(quotien)
      else
        factor.unshift i

  return factor


getPrimeFactors = (n) ->
  primesFactor = []

  factors = decomposeFactor( n )
  # remove first and last since of course [1, n]
  factors.shift()
  factors.pop()

  for factor in factors
    noDividor = [1,factor]
    factorDec = decomposeFactor(factor)
    sameArrays = "#{factorDec}" is "#{noDividor}" 
    # means a factor is a prime
    if sameArrays == true
      primesFactor.push factor

  return primesFactor

bigFactor20130101 = getPrimeFactors(20130101).pop()
console.log( bigFactor20130101 )
# response 1059479
