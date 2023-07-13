package ajiet.cse.wallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button wallBtn;
    boolean running;
    int[] ia= new int[] {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wallBtn = findViewById(R.id.btnWall);
        wallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running)
                {
                    new Timer().schedule(new MyTimer(),0,3000);
                    running= true;
                }
            }
        });
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random= new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}