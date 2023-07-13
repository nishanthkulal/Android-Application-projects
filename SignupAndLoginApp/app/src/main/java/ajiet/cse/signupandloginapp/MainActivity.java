package ajiet.cse.signupandloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText signupUser,signupPassword;
    Button signupBtn;
    String RegularExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[#%$@])[A-Za-z\\d#%$@]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signupUser = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupBtn = findViewById(R.id.signupbtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = signupUser.getText().toString();
                String password = signupPassword.getText().toString();
                if(validatePassword(password))
                {
                    Bundle bundle=  new Bundle();
                    bundle.putString("usr",Username);
                    bundle.putString("pwd",password);
                    Intent it = new Intent(MainActivity.this, LoginActivity.class);
                    it.putExtra("data",bundle);
                    startActivity(it);

                }else {
                    Toast.makeText(getApplicationContext(),"invalid Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(RegularExpression);
        Matcher matcher = pattern.matcher(password);
        return  matcher.matches();
    }
}