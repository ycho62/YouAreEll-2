package youareell;

import controllers.*;
import models.Id;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
//        ServerController serverController = ServerController.shared();
//        serverController.idGet();
//        serverController.messageGet();
        MessageController messageController = MessageController.shared();
//        System.out.println(MessageController.messagesSeen.stream().toList());

        System.out.println(MessageController.shared().getMessages());

//        Id id = (Id) ids.get(0);
//        for (int j = 0; j < messageController.getMessagesForId(id).size(); j++) { // TODO - figure out how to make IDs so we can test
//            System.out.println(messageController.getMessagesForId(id).get(j).getTimestamp());
//        }
        System.out.println(IdController.shared());
        }
//    }
//        YouAreEll urlhandler = new YouAreEll(
//            new TransactionController(
//                new MessageController(), new IdController()
//        ));
//        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
//        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
//    }
//
//    public String get_ids() {
//        return tt.makecall("/ids", "GET", "");
//    }
//
//    public String get_messages() {
//        return MakeURLCall("/messages", "GET", "");
//    }
//

}
