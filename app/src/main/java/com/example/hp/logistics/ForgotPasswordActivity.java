package com.example.hp.logistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
     private Button btnchange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        final EditText passwordET=(EditText)  findViewById(R.id.et_password);
        final EditText confirmpasswordET=(EditText)  findViewById(R.id.et_confirmpassword);

        btnchange=(Button)findViewById(R.id.btn_change);
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strpassword=passwordET.getText().toString();
                String strconfirmpassword=confirmpasswordET.getText().toString();

                if(strpassword.isEmpty())
                {
                    Toast.makeText(ForgotPasswordActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                }
                else if(strconfirmpassword.isEmpty())
                {
                    Toast.makeText(ForgotPasswordActivity.this, "please enter confirm password", Toast.LENGTH_SHORT).show();
                }
                else if (!strconfirmpassword.equals(strpassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "password don't match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                    startActivity(intent);

                }

            }
        });


    }
}
