package edu.illinois.cs.cs125.spring2019.mp3.lib;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jdk.nashorn.internal.parser.JSONParser;

public final class RecognizePhoto {


    public RecognizePhoto () {

    }


    public static java.lang.String getCaption(java.lang.String json) {
        return null;
    }

    public static java.lang.String getFormat(java.lang.String json) {
        return null;
    }

    public static int getHeight(java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("height").getAsInt();
    }

    public static int getWidth(java.lang.String json) {
        return 0;
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