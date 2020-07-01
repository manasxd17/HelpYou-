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

public class MainActivity extends AppCompatActivity {
    Button dial;
    RatingBar rb2;
    Button s2;
    Button book2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dial = (Button)findViewById(R.id.bp);
        rb2=(RatingBar)findViewById(R.id.r2);
        rb2.setMax(5);
        s2=(Button)findViewById(R.id.b32);
        book2=(Button)findViewById(R.id.book2);
        rb2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Stars:" + rb2.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(MainActivity.this);
                View mview=getLayoutInflater().inflate(R.layout.layout_dialog2,null);
                final EditText yourname=(EditText)mview.findViewById(R.id.name2);
                final EditText address=(EditText)mview.findViewById(R.id.addr2);
                final EditText pincode=(EditText)mview.findViewById(R.id.pincode2);
                Button bookcnf = (Button)mview.findViewById(R.id.bookcnf2);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                mbuilder.setView(mview);
                AlertDialog dialog=mbuilder.create();
                dialog.show();

            }
        });
    }
    public void onDialButton(View v){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:07060168502"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);
    }
}
