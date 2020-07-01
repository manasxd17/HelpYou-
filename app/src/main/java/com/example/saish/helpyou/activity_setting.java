package com.example.saish.helpyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class activity_setting extends AppCompatActivity {


    private Switch sw;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sw = (Switch) findViewById(R.id.sw1);
        OnCheckedChange(sw);
    }

    private boolean OnCheckedChange(Switch sw1) {
        if (sw1.isChecked()) {
            Toast.makeText(getApplicationContext(), "Thank you for liking the app", Toast.LENGTH_LONG).show();
            return  true;
        } else {
            //do something when unchecked
            return false;
        }
    }
}



