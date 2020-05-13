package com.example.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class select_avatar extends AppCompatActivity implements View.OnClickListener {

    ImageView male;
    ImageView female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
        setTitle("Select Avatar");
        male = findViewById(R.id.avatar_male);
        female = findViewById(R.id.avatar_female);

        male.setOnClickListener(this);
        female.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == male) {
            Intent returnData = new Intent();
            returnData.putExtra("gender", "male");

            setResult(RESULT_OK, returnData);
            finish();
        }
        else {
            Intent returnData = new Intent();
            returnData.putExtra("gender", "female");

            setResult(RESULT_OK, returnData);
            finish();
        }
    }
}
