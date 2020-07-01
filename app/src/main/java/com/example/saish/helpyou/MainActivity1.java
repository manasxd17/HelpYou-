package com.example.saish.helpyou;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.zip.Inflater;

public class MainActivity1 extends AppCompatActivity {
    private ImageButton ib1, ib2, ib3, ib4, ib5, ib6;
    private NavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ib1 = (ImageButton) findViewById(R.id.ib1);
        ib2 = (ImageButton) findViewById(R.id.ib2);
        ib3 = (ImageButton) findViewById(R.id.ib3);
        ib4 = (ImageButton) findViewById(R.id.ib4);
        ib5 = (ImageButton) findViewById(R.id.ib5);
        ib6 = (ImageButton) findViewById(R.id.ib6);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();

            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity4();
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();

            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();

            }
        });
        nav=(NavigationView)findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_acc:
                        Intent intent = new Intent(getApplicationContext(),activity_account.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_about:
                        Intent intent1 = new Intent(getApplicationContext(),activity_about.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_settings:
                        Intent intent2 = new Intent(getApplicationContext(),activity_setting.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });

    }

    public void openActivity1() {
        Intent intent1 = new Intent(this, MainActivity2.class);
        startActivity(intent1);
    }

    public void openActivity2() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

    public void openActivity3() {
        Intent intent3 = new Intent(this, MainActivity4.class);
        startActivity(intent3);
    }

    public void openActivity4() {
        Intent intent4 = new Intent(this, MainActivity5.class);
        startActivity(intent4);
    }

    public void openActivity5() {
        Intent intent5 = new Intent(this, MainActivity6.class);
        startActivity(intent5);
    }

    public void openActivity6() {
        Intent intent6 = new Intent(this, MainActivity7.class);
        startActivity(intent6);
    }


}
