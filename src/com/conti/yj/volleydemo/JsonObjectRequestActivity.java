
package com.conti.yj.volleydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class JsonObjectRequestActivity extends Activity {

    private TextView mLabelTextview;
    private TextView mResponseContentTextview;
    private JsonObjectRequest mJsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_response);
        initView();
        sendJsonObjectRequest(MainActivity.mRequestQueue);
    }

    private void sendJsonObjectRequest(RequestQueue requestQueue) {
        Listener<JSONObject> listener = new Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(JsonObjectRequestActivity.this, "Json Object Request Success", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(response.toString());
            }
        };

        ErrorListener errorListener = new ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonObjectRequestActivity.this, "Json Object Request Fail", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(error.toString());
            }
        };

        mJsonObjectRequest = new JsonObjectRequest(
                "http://www.weather.com.cn/adat/sk/101280101.html", null, listener,
                errorListener);
        requestQueue.add(mJsonObjectRequest);

    }

    private void initView() {
        mLabelTextview = (TextView) findViewById(R.id.textview_label);
        mLabelTextview.setText("Test Json Object Request");
        mResponseContentTextview = (TextView) findViewById(R.id.textview_response_content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
