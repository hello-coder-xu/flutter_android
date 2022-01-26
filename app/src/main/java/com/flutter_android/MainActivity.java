package com.flutter_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.flutter_android_aar.R;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
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
        toHome = findViewById(R.id.to_home);
        toGoodsList = findViewById(R.id.to_goods_list);
        toGoodsDetail = findViewById(R.id.to_goods_detail);
        toHome.setOnClickListener(this);
        toGoodsList.setOnClickListener(this);
        toGoodsDetail.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String initRoute = "/";
        switch (view.getId()) {
            case R.id.to_home:
                initRoute = "/";
                break;
            case R.id.to_goods_list:
                initRoute = "/goods_list";
                break;
            case R.id.to_goods_detail:
                initRoute = "/goods_detail";
                break;
            default:
                return;
        }
        startActivity(FlutterActivity
                .withNewEngine()
                .initialRoute(initRoute)
                .build(context));
    }
}