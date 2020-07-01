package com.example.saish.helpyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_account extends AppCompatActivity {

    private Button bb1;
    private EditText tt1,tt2;
    private  String st1,st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);



            bb1=(Button)findViewById(R.id.bb1);
            tt1=(EditText)findViewById(R.id.tt1);
            tt2=(EditText)findViewById(R.id.tt2);
            bb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a=new Intent(activity_account.this,MainActivity1.class);
                    st1=tt1.getText().toString();
                    st2=tt2.getText().toString();
                    if(st1.equals("admin")&&st2.equals("root"))
                        Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFUL!!!",Toast.LENGTH_LONG).show();
                    else

                    a.putExtra("", st1);
                    a.putExtra("", st2);
                    startActivity(a);
                }
            });


        }
    }

