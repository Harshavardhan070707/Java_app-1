package com.example.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText taskEditText;
    private Button saveTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskEditText = findViewById(R.id.task_edit_text);
        saveTaskButton = findViewById(R.id.save_task_button);

        saveTaskButton.setOnClickListener(view -> {
            String task = taskEditText.getText().toString();
            if (!task.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("TASK", task);
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); // Close this activity
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
