import org.arl.fjage.*
import org.arl.unet.sim.channels.*
///////////////////////////////////////////////////////////////////////////////
// display documentation

println '''
2-node network
--------------

Node A: tcp://localhost:1101, http://localhost:8081/
Node B: tcp://localhost:1102, http://localhost:8082/
Node C: tcp://localhost:1103, http://localhost:8083/
'''

///////////////////////////////////////////////////////////////////////////////
// simulator configuration

channel.model = BasicAcousticChannel

modem.dataRate = [2400, 2400].bps
modem.frameLength = [2400/8, 2400/8].bytes
modem.headerLength = 0
modem.preambleDuration = 0
modem.txDelay = 0


platform = RealTimePlatform   // use real-time mode

// run the simulation forever
simulate {
  node 'A',address:1, location: [ 0.km, 0.km, -15.m], web: 8081, api: 1101, stack: "$home/etc/setup"
  node 'B', address :2,location: [ 2.km, 0.km, -15.m], web: 8082, api: 1102, stack: {
  	container.add 'Floodmsg' , new Floodmsg()
  }
   node 'C', address:3,location: [ 4.km, 0.km, -15.m], web: 8083, api: 1103, stack: {
  	container.add 'Floodmsga' , new Floodmsga()
  }

}
