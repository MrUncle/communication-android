package com.example.qyoungde.communicationdemo;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {
	NotificationManager mManager = null;
	NotificationCompat.Builder builder = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_notification);

		//获取PendingIntent
		Intent intent = new Intent(this, MyShowActivity.class);
		//通过bundle可以带一些数据过去 这里将字符串传递了过去
		Bundle bundle = new Bundle();
		bundle.putString("name", "从Notification转跳过来的");
		intent.putExtras(bundle);
		PendingIntent mainPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


		//获取NotificationManager实例
		mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		//实例化NotificationCompat.Builde并设置相关属性
		builder = new NotificationCompat.Builder(this)
				//设置小图标
				.setSmallIcon(R.drawable.jay)
				//设置通知标题
				.setContentTitle("最简单的Notification")
				//设置通知内容
				.setContentText("只有小图标、标题、内容")
				//点击通知后自动清除
				.setAutoCancel(true)
				.setContentIntent(mainPendingIntent);
		//设置通知时间，默认为系统发出通知的时间，通常不用设置
		//.setWhen(System.currentTimeMillis());


		Button button0 = (Button)findViewById(R.id.button0);
		button0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				//通过builder.build()方法生成Notification对象,并发送通知,id=1
				mManager.notify(1, builder.build());
			}
		});

		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//关闭这个Notification通知
				mManager.cancelAll();
			}
		});

		super.onCreate(savedInstanceState);
	}

}