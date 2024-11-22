package com.example.registration;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private EditText email;
    private EditText password_1;
    private EditText password_2;
    private String msg = "";
    private boolean isErr = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.msg);
        email = findViewById(R.id.email);
        password_1 = findViewById(R.id.password_1);
        password_2 = findViewById(R.id.password_2);
        button = findViewById(R.id.button);


        button.setOnClickListener(v -> {
            msg = "";
            isErr = false;
            fieldRequired("Email",email.getText().toString().trim());
            if(!isErr) {isEmail("Email",email.getText().toString().trim());}
            fieldRequired("Haslo",password_1.getText().toString().trim());
            fieldRequired("Potw. hasla",password_2.getText().toString().trim());
            if(!isErr) {isPassword(password_1.getText().toString().trim(),password_2.getText().toString().trim());}
            if(isErr){
                textView.setText(msg);
            }else{
                textView.setText("Witaj "+email.getText().toString().trim());
            }
        });
    }
    public void fieldRequired(String fieldName, String fieldVal){
        if(fieldVal.isEmpty()){
            isErr = true;
            msg+="Pole "+fieldName+" jest wymagane!\n";
        }
    }
    public void isEmail(String fieldName, String fieldVal){
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(fieldVal).matches()){
            isErr = true;
            msg+="Niepoprawny adres "+fieldName+"\n";
        }
    }
    public void isPassword(String pass_1, String pass_2){
            if (!pass_1.equals(pass_2)) {
                isErr = true;
                msg += "Hasła nie są zgodne!\n";
            }
        }
}