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

public class MainActivity4 extends AppCompatActivity {
    Button dial;
    RatingBar rb3;
    Button s3;
    Button book3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        dial = (Button)findViewById(R.id.bf);
        rb3=(RatingBar)findViewById(R.id.r3);
        rb3.setMax(5);
        s3=(Button)findViewById(R.id.b33);
        book3=(Button)findViewById(R.id.book3);
        rb3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity4.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this,"Stars:" + rb3.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity4.this);
                View mview = getLayoutInflater().inflate(R.layout.layout_dailog3, null);
                final EditText yourname = (EditText) mview.findViewById(R.id.name3);
                final EditText address = (EditText) mview.findViewById(R.id.addr3);
                final EditText pincode = (EditText) mview.findViewById(R.id.pincode3);
                Button bookcnf = (Button) mview.findViewById(R.id.bookcnf3);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity4.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity4.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                mbuilder.setView(mview);
                AlertDialog dialog = mbuilder.create();
                dialog.show();
            }
            });


        }

    public void onDialButton(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:07081620075"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);

    }
    }