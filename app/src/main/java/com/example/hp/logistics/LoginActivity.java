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
import com.example.hp.logistics.AsyncTasks.AsyncResponse;
import com.example.hp.logistics.AsyncTasks.WebserviceCall;
//import com.logistics.AsyncTasks.AsyncResponse;
//import com.logistics.AsyncTasks.WebserviceCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



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
        showForgetpwdDialog();

    }
});

        loginbtn =(Button)  findViewById(R.id.btnLogin);
        loginbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = usernameET.getText().toString();
                String passwordStr = passwordET.getText().toString();

                // webservice call for login

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
                   // Toast.makeText(LoginActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                    JSONObject object = new JSONObject();
                    try {
                        object.put("email",emailStr);
                        object.put("password",passwordStr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String jsonRequest = String.valueOf(object);
                    String URL = "http://rapidans.esy.es/project/login.php";
                    new WebserviceCall(LoginActivity.this, URL, jsonRequest, "Loading...", true, new AsyncResponse() {
                        @Override
                        public void onSuccess(final String message, JSONArray jsonData) {
                            Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(String message) {
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }).execute();

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
                        Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                        startActivity(intent);

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
