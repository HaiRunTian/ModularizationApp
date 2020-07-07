package com.tianchi.contract;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tianchi.commonlib.HomeExoprtService;

/**
 * @author HaiRun
 * @time 2020-07-07.9:54
 */
@Route(path ="/home/HomeService",name = "测试服务")
public class HomeService implements HomeExoprtService {
    @Override
    public String sayHello(String s) {
        return "HomeService say hello to " + s;
    }

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {

    }
}
