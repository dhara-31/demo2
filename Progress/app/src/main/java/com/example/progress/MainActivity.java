package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    int progress = 0;
    ProgressBar progressBar;
    Button status;
    ToggleButton t1;
    ToggleButton t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button startButton = (Button) findViewById(R.id.button);
        t1=(ToggleButton) findViewById(R.id.toggle);
        t2=(ToggleButton) findViewById(R.id.toggle2);
        status=(Button) findViewById(R.id.checkstatus);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("You have clicked first ON Button-:) ").append(t1.getText());
                result.append("You have clicked Second ON Button -:) ").append(t2.getText());
                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_SHORT).show();

            }
        }

            );


                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(t1.isChecked())
                        {
                            Toast.makeText(getApplicationContext(),"is onn",Toast.LENGTH_LONG).show();
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(),"is off",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                );

        // perform click event on button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call a function
                setProgressValue(progress);

            }
        });
    }

    private void setProgressValue(final int progress) {


        progressBar.setProgress(progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }
}