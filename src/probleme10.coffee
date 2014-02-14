Mathematics = require './Mathematics.js'
Utilities   = require './Utilities.js'

start = Utilities.getCurrentTime()
# first prime number is 2
sum = 2
for i in [3...10000000] by 2
  if Mathematics.is_prime( i )
    sum += i
end = Utilities.getCurrentTime()

duration = Utilities.getDuration( start, end )

console.log( "sum is equal to #{sum}" )
console.log( "script execution time #{duration}" )

# response 3203324994356