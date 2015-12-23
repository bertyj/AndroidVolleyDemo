
package com.conti.yj.volleydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class GetStringRequestActivity extends Activity {
    private TextView mLabelTextview, mResponseContentTextview;
    private StringRequest mGetStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_response);
        initView();
        sendGetStringRequest(MainActivity.mRequestQueue);
    }

    private void sendGetStringRequest(RequestQueue requestQueue) {
        Listener<String> listener = new Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(GetStringRequestActivity.this, "Get String Request Success", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(response);
            }
        };
        ErrorListener errorListener = new ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GetStringRequestActivity.this, "Get String Request Fail", Toast.LENGTH_SHORT).show();
                mResponseContentTextview.setText(error.toString());
            }
        };

        mGetStringRequest = new StringRequest("http://www.baidu.com", listener, errorListener);
        requestQueue.add(mGetStringRequest);
    }

    private void initView() {
        mLabelTextview = (TextView) findViewById(R.id.textview_label);
        mLabelTextview.setText("Test Get String Request");
        mResponseContentTextview = (TextView) findViewById(R.id.textview_response_content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
