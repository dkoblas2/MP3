package edu.illinois.cs.cs125.spring2019.mp3.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import jdk.nashorn.internal.parser.JSONParser;

public final class RecognizePhoto {


    public RecognizePhoto() {

    }


    public static java.lang.String getCaption(java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("description").getAsJsonObject().get("captions").getAsJsonArray().get(0).getAsJsonObject().get("text").getAsString();
    }

    public static java.lang.String getFormat(java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("format").getAsString();
    }

    public static int getHeight(java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("height").getAsInt();
    }

    public static int getWidth(java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("width").getAsInt();
    }

    public static boolean isACat(java.lang.String json, double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray a = result.get("tags").getAsJsonArray();
        for (int i = 0; i < result.get("description").getAsJsonObject().get("tags").getAsJsonArray().size(); i++) {
            if (a.get(i).getAsJsonObject().get("name").getAsString().equals("cat")
                && a.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                return true;
            }
        }
    }

    public static boolean isADog(java.lang.String json, double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray a = result.get("tags").getAsJsonArray();
        for (int i = 0; i < result.get("description").getAsJsonObject().get("tags").getAsJsonArray().size(); i++) {
            if (a.get(i).getAsJsonObject().get("name").getAsString().equals("dog")
                    && a.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                return true;
            }
        }

        return false;
    }

    public static boolean isRick(java.lang.String json) {
        return false;
    }


}