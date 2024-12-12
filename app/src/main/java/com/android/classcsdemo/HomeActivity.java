package com.android.classcsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author song
 * desc:左右分类
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_one).setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, MainActivity.class)));
        findViewById(R.id.btn_two).setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, MainActivity2.class)));
    }
}