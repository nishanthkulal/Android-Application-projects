package ajiet.cse.counderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart,btnStop;
    int i =0;
    TextView counter;
    Handler customHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.strtbtn);
        btnStop = findViewById(R.id.stopbtn);
        counter = findViewById(R.id.counter);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.postDelayed(updateTimerThread,0);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
            }
        });
    }

    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            counter.setText(""+i);
            customHandler.postDelayed(this,1000);
            i++;
        }
    };
}