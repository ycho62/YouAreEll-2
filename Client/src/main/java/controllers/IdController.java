package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import org.json.simple.JSONArray;

public class IdController {
    private HashMap<String, Id> allIds = new HashMap<>();

    Id myId;

    public IdController(){}

    public ArrayList<Id> getIds()  throws JsonProcessingException {
       ServerController serverController = ServerController.shared();
        String ids = String.valueOf(serverController.idGet());
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Id> listIds = objectMapper.readValue(ids, new TypeReference<ArrayList<Id>>() {
        });
        for (Id i: listIds) {
            allIds.put(i.getGithub(), i);
        }
        return listIds;
    }
//        for (int i = 0; i < ids.size(); i++){
//            Object object = ids.get(i);
//            String string = object.toString();
//            String[] idList =  string.split(",");
//            String uid = idList[0].substring(10);
//            String name = idList[1].substring(8);
//            String github = idList[2].substring(10);
//            Id idObject = new Id(uid, name);
//            allIds.put(uid,idObject);
//        }

//    public
//        ArrayList<Id> ids = new ArrayList<>();
//        ServerController serverController = ServerController.shared();
//        ids.addAll(serverController.idGet());
//        System.out.println(ids);
//        return ids;
//    }

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