package com.flutter_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static Context context = null;

    ImageView title_bar_back;
    TextView title_bar_title;
    AppCompatButton toNativeOther;
    AppCompatButton toHome;
    AppCompatButton toGoodsList;
    AppCompatButton toGoodsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        title_bar_back = findViewById(R.id.title_bar_back);
        title_bar_back.setVisibility(View.GONE);
        title_bar_title = findViewById(R.id.title_bar_title);
        title_bar_title.setText("原生首页");

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
        if (viewId == R.id.to_native_other) {
//            intent.setClassName(context, "com.flutter_android.OtherActivity");

            System.out.println("是否有 " + hasPackage("com.addcn.tw591market"));
            System.out.println("是否有 " + hasPackage("com.addcn.android.house591"));
            return;
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

    //通过包名找应用
    private boolean hasPackage(String pkgName) {
        if (null == pkgName) {
            return false;
        }
        boolean bHas = true;
        try {
            getApplicationContext().getPackageManager().getPackageInfo(pkgName, PackageManager.GET_GIDS);
        } catch (PackageManager.NameNotFoundException e) {
            // 抛出找不到的异常，说明该程序已经被卸载
            bHas = false;
        }
        return bHas;
    }
}