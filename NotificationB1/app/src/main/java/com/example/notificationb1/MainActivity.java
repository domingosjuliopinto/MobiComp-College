package com.example.notificationb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notify = findViewById(R.id.button_notify);

        EditText messageText = findViewById(R.id.edit_text);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("My Notifications", "Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageText.getText().toString();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notifications")
                        .setContentTitle("Message")
                        .setContentText(message)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_active_24);


                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1 ,builder.build());
            }
        });
    }
}