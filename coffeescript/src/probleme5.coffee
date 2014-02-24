Mathematics = require './Mathematics.js'
Utilities   = require './Utilities.js'


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



# Javascript not powerful enough ...

start = Utilities.getCurrentTime()
powe = "773838557787812127092191329117736395767580535204436915072674675545116664333902256211182137926950211751902449516673226756472839779783938771158021368882276356848070794209358070102043443325352136545050000110534739684220468927252571854522863758511196723438562910609190153214669067072101789621542172105425151134765107554703780036162346002513302884046411618787327146549168697301079918047772519772786759323456323386160178483395107203321577048282851869205647641463310698242417312882919566526471326406798360010017941481024087519190750874466247021692054677462758217679031488509940948129354330970633083278012074165038033940046145844629478331113175706858291419937603163400966242304"
poweSum =  sumDigit( powe )
end = Utilities.getCurrentTime()
duration = Utilities.getDuration( start, end )
console.log( "power is #{powe}" )
console.log( "response is #{poweSum}" )
console.log( "script execution time #{duration}" )

###
start = Utilities.getCurrentTime()
powe = Math.pow( 2, 222 )
poweSum =  sumDigit( "#{powe}" )
end = Utilities.getCurrentTime()
duration = Utilities.getDuration( start, end )
console.log( "power is #{powe}" )
console.log( "response is #{poweSum}" )
console.log( "script execution time #{duration}" )
####
# response 2830
