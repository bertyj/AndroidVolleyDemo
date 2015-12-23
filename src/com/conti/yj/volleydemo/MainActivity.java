
package com.conti.yj.volleydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity implements OnClickListener {
    private Button mGetStringRequestButton;
    private Button mPostStringRequestButton;
    private Button mJsonObjectRequestButton;
    public static RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);
        initView();
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }

    }

    private void initView() {
        mGetStringRequestButton = (Button) findViewById(R.id.button_get_string_request);
        mGetStringRequestButton.setOnClickListener(this);
        mPostStringRequestButton = (Button) findViewById(R.id.button_post_string_request);
        mPostStringRequestButton.setOnClickListener(this);
        mJsonObjectRequestButton = (Button) findViewById(R.id.button_json_object_request);
        mJsonObjectRequestButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_get_string_request:
                startActivity(new Intent(this, GetStringRequestActivity.class));
                break;
            case R.id.button_post_string_request:
                startActivity(new Intent(this, PostStringRequestActivity.class));
                break;
            case R.id.button_json_object_request:
                startActivity(new Intent(this, JsonObjectRequestActivity.class));
                break;
        }
    }

}
