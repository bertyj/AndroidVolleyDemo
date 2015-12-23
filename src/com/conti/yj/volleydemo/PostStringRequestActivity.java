
package com.conti.yj.volleydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PostStringRequestActivity extends Activity {
    private TextView mLabelTextview, mResponseContentTextview;
    private StringRequest mPostStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_response);
        initView();
        sendPostStringRequest(MainActivity.mRequestQueue);
    }

    private void sendPostStringRequest(RequestQueue requestQueue) {
        Listener<String> listener = new Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(PostStringRequestActivity.this, "Post String Request Success", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(response);
            }
        };

        ErrorListener errorListener = new ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PostStringRequestActivity.this, "Post String Request Fail", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(error.toString());
            }
        };

        mPostStringRequest = new StringRequest(Method.POST,
                "http://www.baidu.com", listener, errorListener) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("wd", "google");
                return map;
            }

        };

        requestQueue.add(mPostStringRequest);
    }

    private void initView() {
        mLabelTextview = (TextView) findViewById(R.id.textview_label);
        mLabelTextview.setText("Test Post String Request");
        mResponseContentTextview = (TextView) findViewById(R.id.textview_response_content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
