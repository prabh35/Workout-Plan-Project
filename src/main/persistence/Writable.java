package persistence;

import org.json.JSONObject;

public interface Writable {
    //EFFECTS: runs this JSON object
    JSONObject toJson();
}
