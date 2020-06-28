package com.projects.simplecrudapps.network;

import android.content.Context;
import android.os.Build;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static final int TIMEOUT = 10000;

    private static VolleySingleton ourInstance = new VolleySingleton();
    private RequestQueue requestQueue;

    public static VolleySingleton getInstance() {
        return ourInstance;
    }

    private VolleySingleton() {
    }

    public RequestQueue getRequestQueue(final Context context) {
        if(requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            this.requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public RequestQueue getLegacyRequestQueue(final Context context) {
        HurlStack hurlStack = new HurlStack(null, new SSLSocketFactoryCompat());

        return Volley.newRequestQueue(context, hurlStack);
    }


    public <T> void addToRequestQueue(Request<T> req, Context context) {
        addToRequestQueueCustomTimeout(req, context, TIMEOUT);
    }


    public <T> void addToRequestQueueCustomTimeout(Request<T> req, Context context, int customTimeout) {

        DefaultRetryPolicy currentPolicy = (DefaultRetryPolicy)req.getRetryPolicy();
        DefaultRetryPolicy policy = new DefaultRetryPolicy(customTimeout,
                currentPolicy.getCurrentRetryCount(),
                currentPolicy.getBackoffMultiplier());
        req.setRetryPolicy(policy);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getRequestQueue(context).add(req);
        }
        else {
            getLegacyRequestQueue(context).add(req);
        }
    }
}
