import org.arl.fjage.*
import org.arl.unet.*

class FloodmsgA extends UnetAgent {

  @Override
  void setup() {
    // this method is called when the stack is initialized
    // register services and capabilities that you provide here
   subscribeForService(Services.PHYSICAL)
    //subscribe uwlink
    
  }

  @Override
  void startup() {
    // this method is called just after the stack is running
    // look up other agents and services here, as needed
    // subscribe to topics of interest to get notifications
  }

  @Override
  Message processRequest(Message msg) {
    // process requests supported by the agent, and return responses
    // if request is not processed, return null
    printf(msg);
    return null
  }

  @Override
  void processMessage(Message msg) {
    // process other messages, such as notifications here
    // if a message is not interesting, it can be safely just ignored
  }

}