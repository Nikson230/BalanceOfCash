package com.example.balanceofcash;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import androidx.fragment.app.DialogFragment;

public class AndroidFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setTitle("New");

        builder.setView(inflater.inflate(R.layout.dialog_add, null)).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}

class Fragment extends FragmentActivity {
    public void confirmNew() {
        DialogFragment newFragment = new AndroidFragment();
        newFragment.show(getSupportFragmentManager(), "new");
    }
}