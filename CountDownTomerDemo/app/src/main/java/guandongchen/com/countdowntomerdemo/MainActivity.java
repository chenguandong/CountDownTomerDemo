package guandongchen.com.countdowntomerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer(10);
            }
        });
    }

    private  void startTimer(int time) {

        timer = new CountDownTimer(time*1000,1000){

            @Override
            public void onTick(long l) {
                button.setEnabled(false);
                button.setText((int)l/1000+"");
            }

            @Override
            public void onFinish() {
                button.setEnabled(true);
                button.setText("发送验证码");
            }
        };
        timer.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer!=null){

            timer.cancel();
        }
    }
}
