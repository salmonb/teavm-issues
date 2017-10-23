package teavmissue;

import teavmissue.json.spi.Json;
import teavmissue.json.spi.WritableJsonObject;

/**
 * @author Bruno Salmon
 */
public class Application {

    public static void main(String[] args) {
        WritableJsonObject json = Json.createObject();
        json.set("message", "Hello :-)");
        System.out.println(json.toJsonString());
    }


}
