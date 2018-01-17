package com.checktoupdatedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.checktoupdatedemo.utils.CheckUpdateUtil;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 检查更新
     */
    private TextView mCheckUpdateTv;
    private String appVersionDescription = "1.我是功能1 \n 1.我是功能1 \n 2.我是功能2 \n 3.我是功能3 \n 4.我是功能4 \n ";//最新软件版本特征描述

    private String downloadApkUrl = "/SoftwareManagement/Uploads/celllocation_NR-release(1).apk";//服务端apk包的路径
    private CheckUpdateUtil utils;
    public  String serverUrl = "http://zc.xun365.net";//服务端地址
    private String dialogNotice = "";//对话框的提示语，两种，一种是稍后提示，一种是其他自定义词语

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        utils = new CheckUpdateUtil(this,"2.0",serverUrl,downloadApkUrl,appVersionDescription,"稍后提示");
    }

    private void initView() {
        mCheckUpdateTv = (TextView) findViewById(R.id.check_update_tv);
        mCheckUpdateTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_update_tv:
                utils.CheckVersionToWarnUpdate();
                break;
        }
    }


}
