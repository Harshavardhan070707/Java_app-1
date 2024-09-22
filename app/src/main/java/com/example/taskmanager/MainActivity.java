package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addTaskButton;
    private Button deleteTaskButton;
    private Button moreOptionsButton;
    private ArrayList<String> tasks = new ArrayList<>();

    private final int ADD_TASK_REQUEST = 1;
    private final int DELETE_TASK_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskButton = findViewById(R.id.add_task_button);
        deleteTaskButton = findViewById(R.id.delete_task_button);
        moreOptionsButton = findViewById(R.id.more_options_button);

        addTaskButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivityForResult(intent, ADD_TASK_REQUEST);
        });

        deleteTaskButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DeleteTaskActivity.class);
            intent.putStringArrayListExtra("TASKS", tasks);
            startActivityForResult(intent, DELETE_TASK_REQUEST);
        });

        moreOptionsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MoreOptionsActivity.class);
            intent.putStringArrayListExtra("TASKS", tasks);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TASK_REQUEST && resultCode == RESULT_OK) {
            String task = data.getStringExtra("TASK");
            if (task != null) {
                tasks.add(task);
                Toast.makeText(this, "Task Added: " + task, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == DELETE_TASK_REQUEST && resultCode == RESULT_OK) {
            tasks = data.getStringArrayListExtra("UPDATED_TASKS");
        }
    }
}
