package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FirstReceiver receiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = new IntentFilter("com.example.broadcast.FIRST_MESSAGE");

        findViewById(R.id.button).setOnClickListener(v->{
            Intent intent = new Intent("com.example.broadcast.FIRST_MESSAGE");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        receiver = new FirstReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        receiver = null;
    }
}