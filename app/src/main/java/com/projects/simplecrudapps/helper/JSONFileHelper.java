package com.projects.simplecrudapps.helper;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JSONFileHelper {

    private static final JSONFileHelper ourInstance = new JSONFileHelper();

    public static JSONFileHelper getInstance() {
        return ourInstance;
    }

    private static final int BUFFER_SIZE = 1024 * 4;

    private JSONFileHelper() {
    }

    public String readString(JSONObject jsonObject, String attributeName) {
        try {
            String attribute = jsonObject.getString(attributeName);
            return attribute;
        } catch (JSONException e) {
            Log.i(getClass().getCanonicalName(), e.getLocalizedMessage());
            return null;
        }
    }

    public JSONObject readJsonFromResource(Context context, int resId) throws IOException, JSONException {
        InputStream is = context.getResources().openRawResource(resId);
        String content = IOtoString(is);
        return new JSONObject(content);
    }

    private String IOtoString(InputStream is) throws IOException {
        return new String(toByteArray(is), "UTF-8");
    }

    private byte[] toByteArray(InputStream is) throws IOException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            final byte[] b = new byte[BUFFER_SIZE];
            int n = 0;
            while ((n = is.read(b)) != -1) {
                output.write(b, 0, n);
            }
            return output.toByteArray();
        } finally {
            output.close();
        }
    }
}
