package com.example.mockfirebasedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDay, editTextHours;
    private Button buttonSend;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference = FirebaseDatabase.getInstance().getReference("Data");

        editTextDay = findViewById(R.id.editTextDay);
        editTextHours = findViewById(R.id.editTextHours);

        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();

            }
        });
    }

    public void addData(){
        String Day = editTextDay.getText().toString();
        String Hours = editTextHours.getText().toString();

        if(!TextUtils.isEmpty(Day) && !TextUtils.isEmpty(Hours)){

            String DataID = databaseReference.push().getKey();

            Data Data = new Data(DataID, Day, Hours);

            databaseReference.child(DataID).setValue(Data);

            editTextDay.setText("");
            editTextHours.setText("");

        }
        else {
            Toast.makeText(MainActivity.this,"Please key in the relevant data",Toast.LENGTH_LONG).show();
        }
    }
}
