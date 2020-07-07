package com.tianchi.modularizationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tianchi.commonlib.HomeExoprtService;
import com.tianchi.contract.HomeService;

public class MainActivity extends AppCompatActivity {

    @Autowired(name = "/home/HomeService")
    public HomeExoprtService baseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }*/
        ARouter.init(getApplication()); // 尽可能早，推荐在Application中初始化
        ARouter.getInstance().inject(this);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转并且携带参数
             /*   ARouter.getInstance().build("/chat/Activity")
                        .withLong("key1",666L)
                        .withString("key3","8888888888888")
                        .navigation();
                finish();*/
                if (baseService != null) {
                    Toast.makeText(MainActivity.this, baseService.sayHello("alan"), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "baseService is null", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
