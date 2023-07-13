package ajiet.cse.callandsaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button callBtn , saveBtn,clearBtn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callBtn = findViewById(R.id.callbtn);
        saveBtn = findViewById(R.id.savebtn);
        clearBtn = findViewById(R.id.clearbtn);
        editText = findViewById(R.id.phoneNumber);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenum = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phonenum));
                startActivity(intent);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenumber = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,phonenumber);
                startActivity(intent);
            }
        });
    }

    public void inputnumber(View V) {
        Button btn = (Button)V;
        String digit = btn.getText().toString();
        String phoneNumber = editText.getText().toString();
        editText.setText(phoneNumber+digit);

    }
}