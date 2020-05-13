package com.example.inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// a. Assignment 03
// b. File Name: MainActivity.java
// c. Group Name: Group 27

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 0x001;
    public static String GENDER = null;

    private TextView ip_lname;
    private TextView ip_fname;
    private ImageView iv_avatar;
    private Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Profile");

        ip_fname = findViewById(R.id.ip_fname);
        ip_lname = findViewById(R.id.ip_lname);

        iv_avatar = findViewById(R.id.iv_avatar);

        save_button = findViewById(R.id.save_button);

        iv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSelectAvatar = new Intent(MainActivity.this, select_avatar.class);

                startActivityForResult(toSelectAvatar, REQ_CODE);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = ip_fname.getText().toString();
                String lname = ip_lname.getText().toString();
                String gender = GENDER;

                if (fname.equals("")) {
                    ip_fname.setError("Cannot be Empty");
                }
                if (!fname.matches("^[a-zA-Z]+$")) {
                    ip_fname.setError("Must be alphabetical");
                }
                if (lname.equals("")) {
                    ip_lname.setError("Cannot be Empty");
                }
                if (!lname.matches("^[a-zA-Z]+$")) {
                    ip_lname.setError("Must be alphabetical");
                }
                if (gender == null) {
                    Toast.makeText(MainActivity.this, "Please choose a gender", Toast.LENGTH_SHORT).show();
                }

                if (fname != "" && lname != "" && gender != null && fname.matches("^[a-zA-Z]+$") && lname.matches("^[a-zA-Z]+$")){
                    User u = new User(gender, fname, lname);
                    Log.d("demo", u.fname + " " + u.lname + " " + u.gender);
                    Intent sendData = new Intent(MainActivity.this, DisplayProfile.class);
                    sendData.putExtra("user", u);
                    startActivity(sendData);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK && data != null) {
            String gender = data.getExtras().getString("gender");

            if (gender.equals("male")) {
                GENDER = "male";
                iv_avatar.setImageDrawable(getDrawable(R.drawable.male));
            } else {
                GENDER = "female";
                iv_avatar.setImageDrawable(getDrawable(R.drawable.female));
            }

        }
    }
}
