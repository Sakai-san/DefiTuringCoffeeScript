Mathematics = require('./Mathematics.js');
Node  = require('./Node.js');
LinkedList  = require('./LinkedList.js');

linked = new LinkedList();

for i in [9999..1]
  for j in [999..1]
    product = i * j
    if Mathematics.is_palindrome("#{product}") and not Mathematics.is_prime(product)
      linked.orderInsert(product)

console.log( linked.head.next.value );

# reponse 9744479
