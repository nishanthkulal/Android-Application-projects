package ajiet.cse.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText e1;
    TextToSpeech t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        e1 = findViewById(R.id.textspeech);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    t1.setLanguage(Locale.US);
                }
            }
        });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String toSpeech = e1.getText().toString();
               t1.speak(toSpeech,TextToSpeech.QUEUE_FLUSH,null);
           }
       });
    }
}