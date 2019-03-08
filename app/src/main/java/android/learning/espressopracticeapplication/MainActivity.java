package android.learning.espressopracticeapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView greetingView, header;
    private Button greetingBtn;
    private ListView list;

    private final int COUNT = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_title);
        greetingView = findViewById(R.id.greeting_view);
        greetingBtn = findViewById(R.id.greeting_btn);

        header = findViewById(R.id.header);
        header.setBackgroundColor(Color.YELLOW);
        header.setVisibility(View.GONE);

        list = findViewById(R.id.list);
        list.setVisibility(View.GONE);
        final ArrayList<Items> arrayList = new ArrayList<>(COUNT);
        for (int i = 0; i <= COUNT; i++) {
            arrayList.add(i, new Items(i));
        }
        ArrayAdapter<Items> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(listAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == COUNT) {
                    greetingView.setVisibility(View.VISIBLE);
                    greetingBtn.setVisibility(View.VISIBLE);
                    greetingBtn.setEnabled(true);
                    list.setVisibility(View.GONE);
                    header.setText(arrayList.get(i).toString());
                }
                else {
                    header.setText(arrayList.get(i).toString());
                    header.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    //Keep public so that MainActivity Test can access this method
    public void setGreetingView(View view) {
        greetingBtn.setEnabled(false);
        greetingView.setText(R.string.textview_text);
        greetingView.setVisibility(View.GONE);
        greetingBtn.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
    }

    public class Items {
        private int value;

        Items(int x) {value = x;}

        @Override
        public java.lang.String toString() {
            return Integer.toString(value);
        }
    }
}
