package com.example.hp.logistics;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextView tvsignup;
    private Button loginbtn;
    private TextView tvforgorpassword;
    View dialogView;
    String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvsignup=(TextView)findViewById(R.id.main_tv_signup);
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        final EditText usernameET=(EditText)  findViewById(R.id.username_edittext);
        final EditText passwordET=(EditText)  findViewById(R.id.password_edittext);
        //Button loginbtn;

        tvforgorpassword =(TextView)  findViewById(R.id.main_forgotpassword );

       // signupBtn=(Button)findViewById(R.id.signup_btn_signup);
    tvforgorpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     // Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
       // startActivity(intent);
        showForgetpwdDialog();
    }
});

        loginbtn =(Button)  findViewById(R.id.btnLogin);
        loginbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername=usernameET .getText() .toString() ;
                String strpassword=passwordET .getText() .toString() ;

                if (strusername .isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please enter your email or username", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(strusername )) {
                    Toast.makeText(LoginActivity.this, "enter valid email ", Toast.LENGTH_SHORT).show();
                }
                else if (strpassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });



    }

    private void showForgetpwdDialog() {
        dialogView= LayoutInflater .from(this).inflate(R.layout .dialog_forget_pwd ,null);
        AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("Security Question")
                .setView(dialogView )
                .setPositiveButton("Verify", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handleTextDialog();
                        dialog .dismiss() ;
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog .dismiss();
                    }
                })
                .setCancelable(false)
                .create();
        dialog.show();
    }

    private void handleTextDialog() {
        if(dialogView!=null)
        {
            EditText edittext=(EditText)dialogView.findViewById(R.id.forget_et_q1);
            String str=edittext.getText().toString();
            Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
        }
    }


    public static boolean isValidEmail(CharSequence target)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern =Pattern .compile(EMAIL_PATTERN );
        matcher =pattern .matcher(target ) ;
        return matcher.matches() ;
    }




}
