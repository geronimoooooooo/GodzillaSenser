package com.example.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
		
		Intent service1 = new Intent(context, MyAlarmService.class);
		context.startService(service1);
		
	}

	
}
