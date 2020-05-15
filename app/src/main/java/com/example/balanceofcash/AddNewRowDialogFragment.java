package com.example.balanceofcash;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

public class AddNewRowDialogFragment extends DialogFragment {
    public interface AddNewRowDialogListener{
        public void onDialogPositiveClick(DialogFragment dialog);
    }

    AddNewRowDialogListener mListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try {
            mListener = (AddNewRowDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement AddNewRowDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_add, null)).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogPositiveClick(AddNewRowDialogFragment.this);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AddNewRowDialogFragment.this.getDialog().cancel();
            }
        });
        return builder.create();
    }
}
