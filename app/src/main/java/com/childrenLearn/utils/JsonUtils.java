package com.childrenLearn.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtils {

  private static final String TAG = JsonUtils.class.getSimpleName();

  public static boolean isJsonObject(String jsonStr) {
    LogUtil.showELog(TAG, "isJsonObject(String jsonStr) jsonStr = " + jsonStr);
    if (jsonStr == null) {
      return false;
    }
    Object json = null;
    try {
      json = new JSONTokener(jsonStr).nextValue();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    if (json instanceof JSONObject) {
      return true;
    }
    return false;
  }

  public static boolean isJsonArray(String jsonStr) {

    Object json = null;
    try {
      json = new JSONTokener(jsonStr).nextValue();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    if (json instanceof JSONArray) {
      return true;
    }
    return false;
  }

  public static String jsonObjectStringGetValue(JSONObject jo, String key) {
    LogUtil.showELog(
        TAG,
        "jsonObjectStringGetValue(JSONObject jo, String key)"
            + "jo = "
            + jo.toString()
            + "; key = "
            + key);
    if (jo == null || key == null) {
      return "";
    }
    String v = "";
    if (!jo.isNull(key)) {
      try {
        v = jo.getString(key);
      } catch (JSONException e) {
        LogUtil.showELog(TAG, "jsonObjectStringGetValue JSONException e = " + e.toString());
      }
    }
    return v;
  }
}
