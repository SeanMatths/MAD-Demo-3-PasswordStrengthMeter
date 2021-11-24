package com.example.passwordstengthmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nu.aaro.gustav.passwordstrengthmeter.PasswordStrengthCalculator;
import nu.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter;

public class MainActivity extends AppCompatActivity {
    private PasswordStrengthMeter _passwordStrengthMeter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurePasswordMeter();
        configureCustomizationButton();
    }

    private void configurePasswordMeter() {
        // Grabbing Views
        EditText etPassword = findViewById(R.id.etVisiblePassword);
        _passwordStrengthMeter = findViewById(R.id.passwordStrengthMeter);

        // Setting the password strength meters to be bound to the EditText Views
        _passwordStrengthMeter.setEditText(etPassword);
    }

    private void configureCustomizationButton() {
        Button btnCustomize = findViewById(R.id.btnCustomize);

        btnCustomize.setOnClickListener(view -> {
            customizeMeter();
        });
    }

    private void customizeMeter() {
        _passwordStrengthMeter.setAnimationDuration(8000);
        _passwordStrengthMeter.setShowStrengthIndicator(true);
        _passwordStrengthMeter.setShowStrengthLabel(false);

        _passwordStrengthMeter.setPasswordStrengthCalculator(new PasswordStrengthCalculator() {
            @Override
            public int calculatePasswordSecurityLevel(String password) {

                int strengthTotal = 0;

                if(password.length() >= getMinimumLength()){
                    strengthTotal += 1;
                    // Contains the word "hi"
                    strengthTotal += password.contains("hi") ? 1 : 0;

                    // Contains the word "class"
                    strengthTotal += password.contains("class") ? 1 : 0;

                    // Contains a smiley face :)
                    strengthTotal += password.contains(":)") ? 1 : 0;

                    // Is at least 8 characters long
                    strengthTotal += password.length() > 7 ? 1 : 0;
                }
                return strengthTotal;
            }

            @Override
            public int getMinimumLength() {
                return 3;
            }

            @Override
            public boolean passwordAccepted(int level) {
                return level > 3;
            }

            @Override
            public void onPasswordAccepted(String password) {
                Toast.makeText(MainActivity.this, "Password is strong 💪", Toast.LENGTH_SHORT).show();
                enableSignupButton();
            }
        });

        Toast.makeText(this, "Customizations On", Toast.LENGTH_SHORT).show();
    }

    private void enableSignupButton() {

    }
}