package com.tianchi.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tianchi.commonlib.HomeExoprtService;

@Route(path = "/chat/Activity")
public class MainActivity extends AppCompatActivity {
    private TextView tvMsg;
    @Autowired
    public String key3;
    @Autowired(name = "/home/HomeService")
    public HomeExoprtService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ARouter.getInstance().inject(this);
        Toast.makeText(this,key3,Toast.LENGTH_LONG).show();
        tvMsg = findViewById(R.id.text);

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(MainActivity.this,baseService.sayHello("Alan say "),Toast.LENGTH_LONG).show();
            }
        });
    }
}
