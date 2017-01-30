package com.baudiabatash.exceltest.Volley;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sohel on 7/20/2016.
 */
public class MyGetVolley {

    private VolleyGetListener volleyGetListener;

    private Context context;
    private String url;
    private String progressDialogMessage;

    public MyGetVolley(Context context, String url, String progressDialogMessage) {
        this.context = context;
        this.url = url;
        this.progressDialogMessage = progressDialogMessage;
    }

    public void setupVolleyGetListener(VolleyGetListener volleyGetListener){
        this.volleyGetListener = volleyGetListener;
    }

    public void applyGetVolley(){

        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(progressDialogMessage);
        dialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.hide();

                        if(volleyGetListener!=null){
                            volleyGetListener.volleyGetResponse(response);
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        Volley.newRequestQueue(context).add(stringRequest);

    }

    public interface VolleyGetListener{
        public void volleyGetResponse(String response);
    }
}
