package com.maxence.videostart;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import static android.R.attr.start;
import static android.R.attr.x;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyVideoView vv_video;
    private TextView tv_view;
 //   private String VideoUrl="http://minisite.adsame.com/nodie/v2.mp4";
   // private String VideoUrl="http://183.59.160.61:30001/PLTV/88888905/224/3221227505/index.m3u8";
    private String VideoUrl="http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8";

    private Button btn_next;
    private int startTime=10;
    //   private String VideoUrl="http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_video);

        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {

        vv_video.setVideoURI(Uri.parse(VideoUrl));
        vv_video.start();
        tv_view.setText(startTime + "");
            new Thread() {
                @Override
                public void run() {

                    while (startTime>0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        startTime--;
                        mHandler.sendEmptyMessage(0);
                    }
                }
            }.start();
    }

    private void initView() {
        vv_video = (MyVideoView) findViewById(R.id.vv_video);
        tv_view = (TextView) findViewById(R.id.tv_view_time);
        btn_next = (Button) findViewById(R.id.btn_next);

        btn_next.setOnClickListener(this);

    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0:
                    tv_view.setText(startTime+"");
                    if(startTime==0){
                        MainActivity.this.setContentView(R.layout.activity_main);
                    }
                    break;

            }
        }
    };

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_next:
                    setContentView(R.layout.activity_main);
                    break;

            }
    }
}
