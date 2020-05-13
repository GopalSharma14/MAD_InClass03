package com.example.inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayProfile extends AppCompatActivity {

    TextView dp_name;
    TextView dp_gender;

    ImageView dp_avatar;

    Button edit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        setTitle("Display Profile");

        dp_name = findViewById(R.id.display_name);
        dp_gender = findViewById(R.id.display_gender);

        dp_avatar = findViewById(R.id.dp_avatar);

        edit_button = findViewById(R.id.edit_button);

        User u = (User) getIntent().getExtras().getSerializable("user");

        if (u.gender.equals("male")) {
            dp_avatar.setImageDrawable(getDrawable(R.drawable.male));
        } else {
            dp_avatar.setImageDrawable(getDrawable(R.drawable.female));
        }

        dp_name.setText("Name: " + u.fname + " " + u.lname);
        dp_gender.setText("Gender: " + u.gender);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
