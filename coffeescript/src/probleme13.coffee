Mathematics = require './Mathematics.js'
Utilities   = require './Utilities.js'

start = Utilities.getCurrentTime()

next = 836 + 1
nextSquarePalidrome = 0
loop
  power = Math.pow(next, 2)
  if  (power+"").length % 2 == 0 and Mathematics.is_palindrome( "#{power}" )
    nextSquarePalidrome = power
    break
  else
    next++

end = Utilities.getCurrentTime()

duration = Utilities.getDuration( start, end )

console.log( "next square palidrome is #{nextSquarePalidrome}" )
console.log( "script execution time #{duration}" )

# response 637832238736