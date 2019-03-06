package edu.illinois.cs.cs125.spring2019.mp3.lib;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jdk.nashorn.internal.parser.JSONParser;

public final class RecognizePhoto {


    public RecognizePhoto () {

    }


    public static java.lang.String getCaption(java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("description").getAsJsonObject().get("text").getAsString();
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
        return false;
    }

    public static boolean isADog(java.lang.String json, double minConfidence) {
        return false;
    }

    public static boolean isRick(java.lang.String json) {
        return false;
    }


}