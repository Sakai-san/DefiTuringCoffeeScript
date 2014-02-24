class Utilities

  @getCurrentTime = () ->
    da = new Date()
    ti = da.getTime()
    return ti

  @getDuration = (start, end) ->
    return end - start

module.exports = Utilities