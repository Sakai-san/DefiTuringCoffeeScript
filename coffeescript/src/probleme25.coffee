Mathematics = require './Mathematics.js'
Utilities   = require './Utilities.js'

start = Utilities.getCurrentTime()

ante_term = 1
prev_term = 1
current_term = 0
rank = 3
size = 2013

loop
  current_term = ante_term + prev_term
  console.log("current term is ", current_term )
  ante_term = prev_term
  prev_term = current_term
  break if (current_term+"").length >= size
  rank++

end = Utilities.getCurrentTime()

duration = Utilities.getDuration( start, end )

console.log( "fibonacci term's rank #{rank}" )
console.log( "script execution time #{duration}" )

# response