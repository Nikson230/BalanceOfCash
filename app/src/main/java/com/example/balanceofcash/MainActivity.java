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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button button;

    static String[] data;

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

    public void get(AddNewRowDialogFragment dialogFragment, String[] data, int... id) {
        EditText[] editTexts = new EditText[id.length];
        data = new String[2];
        for (int x : id) {
            editTexts[x] = dialogFragment.getDialog().findViewById(x);
            data[x] = editTexts[x].getText().toString();
        }
        LinearLayout linearLayout = findViewById(R.id.scrollLayout);

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item, linearLayout, false);
        TextView textViewTitle = view.findViewById(R.id.textTitle);
        textViewTitle.setText(data[0]);
        TextView textViewValue = view.findViewById(R.id.textValue);
        textViewValue.setText(data[1]);
        TextView textViewDate = view.findViewById(R.id.textDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy ' ' HH:mm:ss ");
        textViewDate.setText(simpleDateFormat.format(new Date()));
        linearLayout.addView(view);
    }
}