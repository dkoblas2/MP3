package edu.illinois.cs.cs125.spring2019.mp3.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * big class.
 */
public final class RecognizePhoto {

    /**
     * gets caption.
     * @param json json
     * @return result
     */
    public static java.lang.String getCaption(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        result = result.get("description").getAsJsonObject().get("captions").getAsJsonArray().get(0).getAsJsonObject();
        return result.get("text").getAsString();
    }

    /**
     * gets format.
     * @param json json
     * @return result
     */
    public static java.lang.String getFormat(final java.lang.String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("format").getAsString();
    }

    /**
     * gets height.
     * @param json json
     * @return result
     */
    public static int getHeight(final java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("height").getAsInt();
    }

    /**
     * gets width.
     * @param json json
     * @return result
     */
    public static int getWidth(final java.lang.String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        return result.get("metadata").getAsJsonObject().get("width").getAsInt();
    }

    /**
     * is it a cat.
     * @param json json
     * @param minConfidence double
     * @return truth
     */
    public static boolean isACat(final java.lang.String json, final double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray a = result.get("tags").getAsJsonArray();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getAsJsonObject().get("name").getAsString().equals("cat")
                && a.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                return true;
            }
        }
        return false;
    }

    /**
     * is it a dog.
     * @param json json
     * @param minConfidence double
     * @return truth
     */
    public static boolean isADog(final java.lang.String json, final double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray a = result.get("tags").getAsJsonArray();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getAsJsonObject().get("name").getAsString().equals("dog")
                    && a.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                return true;
            }
        }
        return false;
    }

    /**
     * is it a rick.
     * @param json json
     * @return truth
     */
    public static boolean isRick(final java.lang.String json) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        try {
            result = result.get("categories").getAsJsonObject();
            result = result.get("detail").getAsJsonObject();
            result = result.get("celebrities").getAsJsonObject();
            if (result.get("name").getAsString().equals("Rick Astley")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}
