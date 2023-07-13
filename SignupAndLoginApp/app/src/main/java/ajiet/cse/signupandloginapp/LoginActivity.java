package ajiet.cse.signupandloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginBtn;
    EditText loginUser,loginPassword;
    String usr,pwd;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUser = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginBtn = findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(this);
        Bundle bundle =getIntent().getBundleExtra("data");
        usr = bundle.getString("usr");
        pwd = bundle.getString("pwd");

    }

    @Override
    public void onClick(View view) {
        String luser = loginUser.getText().toString();
        String lpassword = loginPassword.getText().toString();
        if(usr.equals(luser)&&pwd.equals(lpassword))
        {
            Toast.makeText(this,"loginsucessfull",Toast.LENGTH_LONG).show();
        }else {
            count++;
            if(count!=3)
            {
                Toast.makeText(this,"login failed",Toast.LENGTH_LONG).show();
            }else {
                loginBtn.setEnabled(false);
                Toast.makeText(this,"login failed"+count,Toast.LENGTH_LONG).show();
            }
        }

    }
}