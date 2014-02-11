class Mathematics

  @get_factors = (n) ->
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


  ###
    is_prime  tell if a integer is a prime
    arg n     integer
    return    boolean
  ####
  @is_prime = (n) ->
    factors = @get_factors n
    noDividor = [1,n]
    sameArray = "#{factors}" is "#{noDividor}" 
    # sameArray is true means n is a prime
    return sameArray == true

  ###
    is_palidrome  tell if a number-string is a palindrome
    arg numberString string
    return    boolean
  ####
  @is_palindrome = (numberString) ->
    if numberString.length <= 1
      return true
    else
      if numberString[0] == numberString[numberString.length-1]
        return @is_palindrome( numberString[1..numberString.length-2] )
      else
        return false

module.exports = Mathematics