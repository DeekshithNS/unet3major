import org.arl.fjage.*

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

platform = RealTimePlatform   // use real-time mode

// run the simulation forever
simulate {
  node 'A', location: [ 0.km, 0.km, -15.m], web: 8081, api: 1101, stack: "$home/etc/setup"
  node 'B', location: [ 0.5.km, 0.km, -15.m], web: 8082, api: 1102, stack: {
  	container.add 'Floodmsg' , new Floodmsg()
  }
   node 'C', location: [ 1.km, 0.km, -15.m], web: 8083, api: 1103, stack: "$home/etc/setup"

}
