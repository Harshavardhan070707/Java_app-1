package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DeleteTaskActivity extends AppCompatActivity {

    private ListView tasksListView;
    private ArrayList<String> tasks;
    private ArrayList<String> displayTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_task);

        tasksListView = findViewById(R.id.tasks_list_view);

        // Get tasks from intent
        tasks = getIntent().getStringArrayListExtra("TASKS");
        displayTasks = new ArrayList<>();

        // Format tasks for display
        for (int i = 0; i < tasks.size(); i++) {
            displayTasks.add((i + 1) + ") " + tasks.get(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, displayTasks);
        tasksListView.setAdapter(adapter);

        tasksListView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            String taskToDelete = tasks.get(position);
            tasks.remove(position); // Remove the selected task
            Toast.makeText(this, "Deleted: " + taskToDelete, Toast.LENGTH_SHORT).show();
            finishWithResult();
        });
    }

    private void finishWithResult() {
        Intent resultIntent = new Intent();
        resultIntent.putStringArrayListExtra("UPDATED_TASKS", tasks);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
