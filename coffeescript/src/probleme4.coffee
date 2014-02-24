Mathematics = require './Mathematics.js'
LinkedList  = require './LinkedList.js'
Utilities   = require './Utilities.js'

linked = new LinkedList()

start = Utilities.getCurrentTime()

for i in [9999..1]
  for j in [999..1]
    product = i * j
    if Mathematics.is_palindrome("#{product}") and not Mathematics.is_prime(product)
      if linked.head.next.value < product 
        linked.orderInsert( product )

end = Utilities.getCurrentTime()

duration = Utilities.getDuration( start, end )

linked.print()
console.log( "biggest value #{linked.head.next.value}" )
console.log( "script execution time #{duration}" )

# reponse 9744479
