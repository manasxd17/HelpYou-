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

public class MainActivity5 extends AppCompatActivity {

    Button dial;
    RatingBar rb4;
    Button s4;
    Button book4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        dial = (Button)findViewById(R.id.bk);
        rb4=(RatingBar)findViewById(R.id.r4);
        rb4.setMax(5);
        s4=(Button)findViewById(R.id.b34);
        book4=(Button)findViewById(R.id.book4);
        rb4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity5.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity5.this,"Stars:" + rb4.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity5.this);
                View mview = getLayoutInflater().inflate(R.layout.layout_dailog4, null);
                final EditText yourname = (EditText) mview.findViewById(R.id.name4);
                final EditText address = (EditText) mview.findViewById(R.id.addr4);
                final EditText pincode = (EditText) mview.findViewById(R.id.pincode4);
                Button bookcnf = (Button) mview.findViewById(R.id.bookcnf4);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity5.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity5.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
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
        intent.setData(Uri.parse("tel:09833823609"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }
}
