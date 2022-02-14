package com.flutter_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class OtherActivity extends Activity implements View.OnClickListener {
    Context context = this;

    ImageView title_bar_back;
    TextView title_bar_title;
    AppCompatButton toNativeOther;
    AppCompatButton toHome;
    AppCompatButton toGoodsList;
    AppCompatButton toGoodsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        title_bar_back = findViewById(R.id.title_bar_back);
        title_bar_back.setOnClickListener(this);
        title_bar_title = findViewById(R.id.title_bar_title);
        title_bar_title.setText("原生Other");

        toNativeOther = findViewById(R.id.to_native_other);
        toHome = findViewById(R.id.to_home);
        toGoodsList = findViewById(R.id.to_goods_list);
        toGoodsDetail = findViewById(R.id.to_goods_detail);
        toNativeOther.setOnClickListener(this);
        toHome.setOnClickListener(this);
        toGoodsList.setOnClickListener(this);
        toGoodsDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        int viewId = view.getId();
        if (viewId == R.id.title_bar_back) {
            finish();
            return;
        } else if (viewId == R.id.to_native_other) {
            intent.setClassName(context, "com.flutter_android.OtherActivity");
        } else if (viewId == R.id.to_home) {
            intent.setClassName(context, "com.flutter_android.FlutterGroupActivity");
            intent.putExtra("initRoute", "/home");
        } else if (viewId == R.id.to_goods_list) {
            intent.setClassName(context, "com.flutter_android.FlutterGroupActivity");
            intent.putExtra("initRoute", "/goodsList");
        } else if (viewId == R.id.to_goods_detail) {
            intent.setClassName(context, "com.flutter_android.FlutterGroupActivity");
            intent.putExtra("initRoute", "/goodsDetail");
        }
        startActivity(intent);
    }
}
