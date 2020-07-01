package com.example.saish.helpyou;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    Button dial;
    RatingBar rb5;
    Button s5;
    Button book5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        dial = (Button)findViewById(R.id.b5);
        rb5=(RatingBar)findViewById(R.id.r6);
        rb5.setMax(5);
        s5=(Button)findViewById(R.id.b35);
        book5=(Button)findViewById(R.id.book5);
        rb5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity6.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity6.this,"Stars:" + rb5.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity6.this);
                View mview = getLayoutInflater().inflate(R.layout.layout_dailog5, null);
                final EditText yourname = (EditText) mview.findViewById(R.id.name5);
                final EditText address = (EditText) mview.findViewById(R.id.addr5);
                final EditText pincode = (EditText) mview.findViewById(R.id.pincode5);
                Button bookcnf = (Button) mview.findViewById(R.id.bookcnf5);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity6.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity6.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                mbuilder.setView(mview);
                AlertDialog dialog = mbuilder.create();
                dialog.show();
            }
        });

    }
    public void onDialButton(View v){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:09079757137"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }
}

