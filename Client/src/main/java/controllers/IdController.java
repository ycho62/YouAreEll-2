package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import models.Id;

public class IdController {
    private HashMap<String, Id> allIds = new HashMap<>();

    Id myId;

    public ArrayList<Id> getIds() {
        ArrayList<Id> ids = new ArrayList<>();
        ServerController serverController = ServerController.shared();
        ids.addAll(serverController.idGet());
        System.out.println(ids);
        return ids;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}