package youareell;

import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.*;
import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;

import java.util.List;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public YouAreEll(MessageController messageController, IdController idController) {
        this.tt = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) throws JsonProcessingException {
        // hmm: is this Dependency Injection?


        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));
        System.out.println(urlhandler.MakeURLCall("/ids"));//, "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages"));//, "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/post"));
    }

    public String MakeURLCall(String info) throws JsonProcessingException {
        if(info.equals("/ids")){
            return get_ids();
        }else if (info.equals("/messages")){
            return get_messages();
        }else{
            return post_Ids();
        }
    }

    public String get_ids() throws JsonProcessingException {
        List<Id> ids = tt.getIds();
        String show = "";
        for (Id i : ids){
            IdTextView view = new IdTextView(i);
            show += view + "\n";
        }
        return show;
//        return tt.makecall("/ids", "GET", "");
    }

    public String get_messages() {
        List<Message> message = tt.getMessages();
        String show = "";
        for (Message i : message) {
            MessageTextView view = new MessageTextView();
            show += view.toString(i) + "\n";
        }
        return "New Id Created";
//        return MakeURLCall("/messages", "GET", "");
    }

    public String post_Ids() {
        IdController idController = new IdController();
        idController.postId(new Id());
        return "New Id Created";
        //        return MakeURLCall("/messages", "GET", "");
    }


}
