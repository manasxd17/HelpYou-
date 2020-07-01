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

public class MainActivity7 extends AppCompatActivity {

    Button dial;
    RatingBar rb6;
    Button s6;
    Button book6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        dial = (Button)findViewById(R.id.b11);
        rb6=(RatingBar)findViewById(R.id.r7);
        rb6.setMax(5);
        s6=(Button)findViewById(R.id.b37);
        book6=(Button)findViewById(R.id.book6);
        rb6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity7.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity7.this,"Stars:" + rb6.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity7.this);
                View mview = getLayoutInflater().inflate(R.layout.layout_dailog6, null);
                final EditText yourname = (EditText) mview.findViewById(R.id.name6);
                final EditText address = (EditText) mview.findViewById(R.id.addr6);
                final EditText pincode = (EditText) mview.findViewById(R.id.pincode6);
                Button bookcnf = (Button) mview.findViewById(R.id.bookcnf6);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity7.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity7.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
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
        intent.setData(Uri.parse("tel:07688838644"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }
}
