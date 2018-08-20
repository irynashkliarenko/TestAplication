package com.example.testapplication.testapplication;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final EditText emailInput = findViewById(R.id.email);
        final EditText passwordInput = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isValidEmail(emailInput.getText().toString()) || !isValidPassword(passwordInput.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Invalid credentials",
                            Toast.LENGTH_LONG).show();
                }else{
                    if (isItAdmin(emailInput.getText().toString(), passwordInput.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Hello admin",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Hello user",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+!<>=])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(final String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isItAdmin (final String email, final String password) {
        return email.equals("admin@admin.com") && password.equals("Test1234!");
    }
}
