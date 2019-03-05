package android.learning.espressopracticeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greetingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingView = findViewById(R.id.greeting_view);
        Button greetingBtn = findViewById(R.id.greeting_btn);

    }

    //Keep public so that MainActivity Test can access this method
    public void setGreetingView(View view) {
        greetingView.setText("Well well well...");
    }
}
