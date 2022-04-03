package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import models.Id;
import org.json.simple.JSONArray;

public class IdController {
    private HashMap<String, Id> allIds = new HashMap<>();

    Id myId;
    private static IdController idc = new IdController();
    public static IdController shared(){return idc;}
    public IdController() {
       ServerController serverController = ServerController.shared();
        JSONArray ids = serverController.idGet();
        for (int i = 0; i < ids.size(); i++){
            Object object = ids.get(i);
            String string = object.toString();
            String[] idList =  string.split(",");
            String uid = idList[0].substring(10);
            String name = idList[1].substring(8);
            String github = idList[2].substring(10);
            Id idObject = new Id(uid, name);
            allIds.put(uid,idObject);
        }
    }


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