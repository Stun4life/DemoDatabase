package sg.edu.rp.c346.id19021138.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();

            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating DBHelper object, passing in the activity context
                DBHelper db = new DBHelper(MainActivity.this);

                //Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int a = 0; a < data.size(); a++) {
                    Log.d("Database Content", a + ". " + data.get(a));
                    txt += a + ". " + data.get(a) + "\n";
                }
                tvResults.setText(txt);
            }
        });
    }
}