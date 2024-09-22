package com.example.taskmanager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MoreOptionsActivity extends AppCompatActivity {

    private TextView tasksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);

        tasksTextView = findViewById(R.id.tasks_text_view);

        ArrayList<String> tasks = getIntent().getStringArrayListExtra("TASKS");

        if (tasks != null && !tasks.isEmpty()) {
            StringBuilder tasksString = new StringBuilder();
            for (int i = 0; i < tasks.size(); i++) {
                tasksString.append(i + 1).append(") ").append(tasks.get(i)).append("\n\n");
            }
            tasksTextView.setText(tasksString.toString().trim());
        } else {
            tasksTextView.setText("No tasks available.");
        }
    }
}
