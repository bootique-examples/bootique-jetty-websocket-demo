package io.bootique.websoket.demo.generator;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessageUtil {

    public static final String SYMBOL = "symbol";
    public static final String SCHEMA = "schema";
    public static final String MAX_FREQUENCY = "maxFrequency";
    public static final String COMMAND = "command";

    public static final String SUBSCRIBE = "subscribe";
    public static final String UNSUBSCRIBE = "unsubscribe";

    public static Map<String, Object> parseJson(String message) {
       Map<String, Object> result = new Gson().fromJson(message, HashMap.class);
       result.putIfAbsent(MAX_FREQUENCY, Double.MAX_VALUE);
       result.putIfAbsent(SCHEMA, new ArrayList<>());
       return result;
    }

    public static String toJson(Map<String, String> message) {
        Map<String, String> toSend = new HashMap<>();
        // Beautifying JSON
        message.forEach((k, v) -> toSend.put(k.toLowerCase().replace("_", ""), v));

        return new Gson().toJson(toSend);
    }

    public static void toLowerCase(Map<String, String> data) {
        Map<String, String> result = new HashMap<>();
        data.forEach((k, v) -> result.put(k.toLowerCase().replace("_", ""), v));
        data.clear();
        data.putAll(result);
    }
}