package com.example.qyoungde.communicationdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBootReceiver extends BroadcastReceiver {
	/**开机广播**/
	static final String BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {
		/**如果为开机广播则开启service**/
		if (intent.getAction().equals(BOOT_COMPLETED)) {
			Intent i = new Intent(context, MyService.class);
			context.startService(i);
		}

	}
}
