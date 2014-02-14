Mathematics = require './Mathematics.js'
Utilities   = require './Utilities.js'

sumDigit = (numberString) ->
  if numberString.length == 0
    return 0
  else
    return parseInt(numberString[0])+sumDigit( numberString[1..numberString.length-1] )


power = (base, expo) ->

  if expo < 0 
    throw "Expo must be an integer."

  else if expo == 0
    return 1

  else if expo == 1
    return base

  else if  expo % 2 == 0
    halfExpo = expo / 2
    halfComputation = multiplication(base, halfExpo)
    return  halfComputation * halfComputation 
  else
    halfExpoFloor = expo // 2
    halfComputation = multiplication(base, halfExpoFloor)
    return  halfComputation * halfComputation * base


multiplication = ( number, times ) ->
  if times <= 1
    return number
  else
    t = times-1
    number * multiplication(number, t)

facto = (n) ->
  if n <= 1
    return n
  else
    return n * facto(n - 1)

fa = facto(2013)
facSum = sumDigit( "#{fa}" )
console.log( "factoriel #{fa}" )
console.log( "facSum #{facSum}" )

###
start = Utilities.getCurrentTime()
powe = power( 2, 2222 )
poweSum =  sumDigit( "#{powe}" )
end = Utilities.getCurrentTime()
duration = Utilities.getDuration( start, end )
console.log( "power is #{powe}" )
console.log( "response is #{poweSum}" )
console.log( "script execution time #{duration}" )

console.log( "" )

start = Utilities.getCurrentTime()
powe = Math.pow( 2, 222 )
poweSum =  sumDigit( "#{powe}" )
end = Utilities.getCurrentTime()
duration = Utilities.getDuration( start, end )
console.log( "power is #{powe}" )
console.log( "response is #{poweSum}" )
console.log( "script execution time #{duration}" )
####
# reponse
