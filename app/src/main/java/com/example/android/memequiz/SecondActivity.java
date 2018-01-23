package com.example.android.memequiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

    }

    public void goToMainActivity(View view) {
        EditText editTextName = (EditText) findViewById(R.id.edit_name);
        String message = editTextName.getText().toString();

        boolean isEmpty = isNameFilled(message);

        if (isEmpty) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("com.sandica.name", message);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "You did not type your name!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isNameFilled(String name) {
        char[] charNames = name.toCharArray();
        if (charNames.length > 0) {
            return true;
        }
        return false;
    }
}
