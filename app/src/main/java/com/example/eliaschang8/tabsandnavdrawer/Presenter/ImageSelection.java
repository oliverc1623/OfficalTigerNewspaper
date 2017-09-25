package com.example.eliaschang8.tabsandnavdrawer.Presenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.eliaschang8.tabsandnavdrawer.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ImageSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_selection);

        CircularImageView icon1 = (CircularImageView) findViewById(R.id.icon1);
        CircularImageView icon2 = (CircularImageView) findViewById(R.id.icon2);
        CircularImageView icon3 = (CircularImageView) findViewById(R.id.icon3);
        CircularImageView icon4 = (CircularImageView) findViewById(R.id.icon4);
        CircularImageView icon5 = (CircularImageView) findViewById(R.id.icon5);


        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfter = new Intent(ImageSelection.this, MainActivity.class);
                Uri retrivedUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/icon_one");
                intentAfter.putExtra("image", retrivedUri.toString());
                setResult(RESULT_OK, intentAfter);
                finish();
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfter = new Intent(ImageSelection.this, MainActivity.class);
                Uri retrivedUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/icon_two");
                intentAfter.putExtra("image", retrivedUri.toString());
                setResult(RESULT_OK, intentAfter);
                finish();
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfter = new Intent(ImageSelection.this, MainActivity.class);
                Uri retrivedUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/icon_three");
                intentAfter.putExtra("image", retrivedUri.toString());
                setResult(RESULT_OK, intentAfter);
                finish();
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfter = new Intent(ImageSelection.this, MainActivity.class);
                Uri retrivedUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/icon_four");
                intentAfter.putExtra("image", retrivedUri.toString());
                setResult(RESULT_OK, intentAfter);
                finish();
            }
        });

        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAfter = new Intent(ImageSelection.this, MainActivity.class);
                Uri retrivedUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/icon_five");
                intentAfter.putExtra("image", retrivedUri.toString());
                setResult(RESULT_OK, intentAfter);
                finish();
            }
        });
    }
}

