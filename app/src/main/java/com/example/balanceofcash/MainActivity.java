package com.example.balanceofcash;

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

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, AddNewRowDialogFragment.AddNewRowDialogListener {

    Button button;

    LinearLayout layout;

    LayoutInflater inflater;

    TextView textViewBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonAdd);

        layout = findViewById(R.id.scrollLayout);

        textViewBalance = findViewById(R.id.textViewBalance);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();

        DialogFragment newFragment = new AddNewRowDialogFragment();
        newFragment.show(getSupportFragmentManager(), "new");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        EditText editTextTitle = dialog.getDialog().findViewById(R.id.editTitle);
        EditText editTextValue = dialog.getDialog().findViewById(R.id.editValue);
        inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.item, null, false);
        TextView textViewTitle = view.findViewById(R.id.textTitle);
        TextView textViewValue = view.findViewById(R.id.textValue);
        TextView textViewDate = view.findViewById(R.id.textDate);
        textViewTitle.setText(editTextTitle.getText().toString());
        textViewValue.setText(editTextValue.getText().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy ' ' HH:mm:ss");
        textViewDate.setText(simpleDateFormat.format(new Date()));
        textViewBalance.setText("Balance - " + editTextValue.getText().toString());
        layout.addView(view);
    }
}