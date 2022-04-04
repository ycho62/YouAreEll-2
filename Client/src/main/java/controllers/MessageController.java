package controllers;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;

public class MessageController {

    public static HashSet<Message> messagesSeen = new HashSet<>();
    private final ServerController serverController = ServerController.shared();
    // why a HashSet??

    public MessageController() throws JsonProcessingException {
        String messages = String.valueOf(serverController.messageGet());
        ObjectMapper objectMapper = new ObjectMapper();
        messagesSeen = objectMapper.readValue(messages, new TypeReference<>() {
        });
    }

//        ServerController serverController = ServerController.shared();
//        JSONArray messages = serverController.messageGet();
//        for(int i =0; i < messages.size(); i++) {
//            Object object = messages.get(i);
//            String string = object.toString();
//            String[] messageList = string.split(",");
//            String toID = messageList[0].substring(8);
//            String sequence = messageList[1].substring(11);
//            String message = messageList[2].substring(10);
//            String fromID = messageList[3].substring(9);
//            String timestamp = messageList[4].substring(12);
//            Message messageobject = new Message(message, fromID, toID, timestamp, sequence);
//            messagesSeen.add(messageobject);
//
//
//    private static MessageController msc = new MessageController();
//    public static MessageController shared() {return msc;}

    public ArrayList<Message> getMessages() {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message m : messagesSeen) {
            messages.add(m);
        }
        ArrayList<Message> copy = (ArrayList<Message>) messages.stream().sorted(Comparator.comparing
                (Message::getTimestamp)).collect(Collectors.toList());
        ArrayList<Message> mostRecent = new ArrayList<>();

        for(int i= copy.size()-1; i > copy.size()-21; i--){
            mostRecent.add(copy.get(i));
        }
        mostRecent .forEach(System.out::println);
        return mostRecent;

    }

//        Message[] array = messagesSeen.toArray(new Message[0]);
//        ArrayList<Message> messages = new ArrayList<>();
//        for (int i=0; i < array.length; i++) {
//            messages.add(array[i]);
//        }
//        ArrayList<Message> copy = (ArrayList<Message>) messages.stream().sorted(Comparator.comparing(Message::getTimestamp)).collect(Collectors.toList());
//        ArrayList<Message> mostRecent = new ArrayList<>();
//
//        for(int i= copy.size()-1; i > copy.size()-21; i--){
//            mostRecent.add(copy.get(i));
//        }
//        mostRecent .forEach(System.out::println);
//        return mostRecent;
//    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message m : messagesSeen) {
            if (m.getFromId().equals(Id.getGithub())) {
                messages.add(m);
            }
        }
            ArrayList<Message> copy = (ArrayList<Message>) messages.stream().sorted
                    (Comparator.comparing(Message::getTimestamp)).collect(Collectors.toList());
            ArrayList<Message> mostRecent = new ArrayList<>();

            if (copy.size() >= 20) {
                for (int i = copy.size() - 1; i > copy.size() - 21; i--) {
                    mostRecent.add(copy.get(i));
                }
            } else {
                mostRecent.addAll(copy);
            }

        return mostRecent;
    }
//        Message[] array = messagesSeen.toArray(new Message[0]);
//        ArrayList<Message> messages = new ArrayList<>();
//        for (int i=0; i < array.length; i++) {
//            if(array[i].getToId().equals(Id))
//            messages.add(array[i]);
//        }
//        ArrayList<Message> copy = (ArrayList<Message>) messages.stream().sorted(Comparator.comparing(Message::getTimestamp)).collect(Collectors.toList());
//        ArrayList<Message> mostRecent = new ArrayList<>();
//
//        for(int i= copy.size()-1; i > copy.size()-21; i--){
//            mostRecent.add(copy.get(i));
//        }
//        mostRecent .forEach(System.out::println);
//        return mostRecent;
//    }
    public Message getMessageForSequence(String seq) {
        for (Message m : messagesSeen) {
            if(m.getSeqId().equals(seq)) {
                return m;
            }
        }
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        ArrayList<Message> msgFromFriend = new ArrayList<>();
        for (Message m : messagesSeen) {
            if(m.getFromId().equals(friendId.getGithub()) && m.getToId().equals(myId.getGithub())) { // github = messages
                msgFromFriend.add(m);
            }
        }
        return msgFromFriend;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}