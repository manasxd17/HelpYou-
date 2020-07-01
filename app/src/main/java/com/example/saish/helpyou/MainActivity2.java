package com.example.saish.helpyou;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Rating;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button dial;
    RatingBar rb;
    Button s1;
    Button book1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dial = (Button)findViewById(R.id.bm);
        rb=(RatingBar)findViewById(R.id.r1);
        rb.setMax(5);
        s1=(Button)findViewById(R.id.b31);
        book1=(Button)findViewById(R.id.book1);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v2, boolean fromUser) {
                Toast.makeText(MainActivity2.this,"Stars: " + v2,Toast.LENGTH_SHORT).show();
            }


        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this,"Stars:" + rb.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(MainActivity2.this);
                View mview=getLayoutInflater().inflate(R.layout.layout_dialog1,null);
                final EditText yourname=(EditText)mview.findViewById(R.id.name1);
                final EditText address=(EditText)mview.findViewById(R.id.addr1);
                final EditText pincode=(EditText)mview.findViewById(R.id.pincode1);
                Button bookcnf = (Button)mview.findViewById(R.id.bookcnf1);
                bookcnf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!yourname.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !pincode.getText().toString().isEmpty()) {

                            Toast.makeText(MainActivity2.this, "Booking Confirmed", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity2.this, "Please fill any empty field", Toast.LENGTH_LONG).show();
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
        intent.setData(Uri.parse("tel:09350066753"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            return;
        startActivity(intent);


    }

}
