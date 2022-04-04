package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },

*
 */
public class Message implements Comparable {
    @JsonProperty("message")
    private String message = "";
    @JsonProperty("toid")
    private String toId = "";
    @JsonProperty("fromid")
    private String fromId = "";
    @JsonProperty("timestamp")
    private String timestamp = "";
    @JsonProperty("sequence")
    private String seqId = "";

    public Message (String message, String fromId, String toId, String timestamp, String seqId) {
        this.message = message;
        this.fromId = fromId;
        this.toId = toId;
        this.timestamp = timestamp;
        this.seqId= seqId;
    }

    public Message(){} // nullary for object mapper to map on to the above fields. Needs to be blank

    @Override
    public String toString() {
        return "sequence: "+ this.seqId + "\ntimestamp: " + this.timestamp + "to: " + this.toId + "\nfrom: "+ this.fromId + "\n" + this.message + "\n----\n";
    }

    public int compareTo(Object o) {
        return this.seqId.compareTo(((Message) o).getSeqId());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSeqId() {
        return seqId;
    }
}