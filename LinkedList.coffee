Node  = require('./Node.js');

class LinkedList
  #TO DO enhance the reference to the tail
  constructor: () ->
    @head = new Node( null, null )
    @tail = new Node( null, null )
    @head.next = @tail
    @tail.next = @tail

  insertStart: (value) ->
    newNode = new Node( value, null )
    newNode.next = @head.next
    @head.next = newNode

  _insert: (pointer, value) ->
    newNode = new Node( value, null )
    newNode.next = pointer.next
    pointer.next = newNode

  orderInsert: (value) ->
    currentNode = @head.next
    previousNode = @head
    loop
      # the tail
      if currentNode == @tail
        @_insert(previousNode, value )
        break
      else
        if value > currentNode.value
          @_insert(previousNode, value )
          break
        else
          previousNode = currentNode
          currentNode = currentNode.next

  print: () ->
    currentNode = @head.next
    loop
      if currentNode == @tail
        break
      else
        console.log(currentNode.value)
        currentNode = currentNode.next

module.exports = LinkedList
