package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import models.Id;
import models.Message;
import org.junit.Assert;

import java.util.ArrayList;

public class MessageControllerTest extends TestCase {
    MessageController messageController = new MessageController();
    ObjectMapper objectMapper = new ObjectMapper();

    public MessageControllerTest() throws JsonProcessingException {
    }

    public void testGetMessages() {
        ArrayList<Message> actual = messageController.getMessages();
        Assert.assertTrue(actual.size() !=0);
    }

    public void testGetMessagesForId() {
        Id id = new Id("Yun", "");
        ArrayList<Message> actual = messageController.getMessagesForId(id);
        Assert.assertTrue(actual.size() == 0);
    }

    public void testGetMessageForSequence() {
    }

    public void testGetMessagesFromFriend() {
    }

    public void testPostMessage() {
    }
}