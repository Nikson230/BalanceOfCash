package com.example.balanceofcash;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, GetData {

    Button button;

    public String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonAdd);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();

        DialogFragment newFragment = new AddNewRowDialogFragment();
        newFragment.show(getSupportFragmentManager(), "new");
    }

    @Override
    public void get(AddNewRowDialogFragment dialogFragment, int ...id) {
        EditText[] editTexts = new EditText[id.length];
        for(int x : id){
            editTexts[x] = dialogFragment.getDialog().findViewById(x);
            this.data[x] = editTexts[x].getText().toString();
        }
    }
}
