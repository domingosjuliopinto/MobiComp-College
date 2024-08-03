package com.example.basicprimitivesb1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img=findViewById(R.id.image_view);
        Bitmap bitmp = Bitmap.createBitmap(1250,2000,Bitmap.Config.RGB_565);
        img.setImageBitmap(bitmp);

        Canvas canvas = new Canvas(bitmp);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50);

        canvas.drawText("Rectangle",150,140,paint);
        canvas.drawRect(100,450,450,250,paint);

        canvas.drawText("Circle",950,140,paint);
        canvas.drawCircle(1000,400,200,paint);

        canvas.drawText("Square",150,640,paint);
        canvas.drawRect(100,1000,400,700,paint);

        canvas.drawText("Line",950,740,paint);
        canvas.drawLine(1000,800,1000,1150,paint);
    }
}