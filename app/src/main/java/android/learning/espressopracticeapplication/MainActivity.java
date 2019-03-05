package android.learning.espressopracticeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greetingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingView = findViewById(R.id.greeting_view);

    }

    protected void setGreetingView() {
        greetingView.setText("Well well well...");
    }

}
