class OperationList

  ###
    sort      call the insert method on element recursively
    arg l     an unsorted list
    return    the sorted list
  ####
  @sort = (l) ->
    if l.length <= 0
      return []
    else
      return @insert( l[0],  @sort( l[1..l.length-1]  ) )   


  ###
    insert    insert a number in a already sorted list
    arg n l   number and a sorted list
    return    the new sorted list
  ####

  @insert = (n, l) ->
    if l.length <= 0
      l.push(n)
      return l
    else
      if n <= l[0]
        l.unshift( n )
        return l
      else
        return l[0..0].concat @insert( n, l[1..l.length-1] )


module.exports = OperationList