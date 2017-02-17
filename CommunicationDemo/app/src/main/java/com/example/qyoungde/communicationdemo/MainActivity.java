package com.example.qyoungde.communicationdemo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Context mContext = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        /**ʹ��Handler������Ϣ**/
        Button botton0 = (Button)findViewById(R.id.button0);
        botton0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext,HandlerActivity.class);
                startActivity(intent);
            }
        });
        /**Notification**/
        Button botton1 = (Button)findViewById(R.id.button1);
        botton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext,NotificationActivity.class);
                startActivity(intent);
            }
        });
        /**�㲥�Ľ���**/
        Button botton2 = (Button)findViewById(R.id.button2);
        botton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext,BroadcastActivity.class);
                startActivity(intent);
            }
        });



        /**Activity之间传递值**/
        Button botton3 = (Button)findViewById(R.id.button3);
        botton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext,ShowActivity.class);
                //使用intent.putExtra()直接传递
                intent.putExtra("name", "雨松MOMO");
                intent.putExtra("age", 25);
                intent.putExtra("boy", true);

                //把数值放进bundle 然后在把整个bundle通过intent.putExtra()传递
                Bundle bundle = new Bundle();
                bundle.putString("b_name", "小可爱");
                bundle.putInt("b_age", 23);
                bundle.putBoolean("b_boy", false);
                //在这里把整个bundle 放进intent中
                intent.putExtras(bundle);
                //开启一个新的 activity 将intent传递过去
                startActivity(intent);
            }
        });
    }
}