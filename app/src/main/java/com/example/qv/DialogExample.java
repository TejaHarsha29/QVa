package com.example.qv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogExample extends AppCompatDialogFragment {

    private EditText etName;
    private EditText etDes;
    private EditText etRating;

    private ExampleDialogListener listener;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view).setTitle("Add Movie").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString();
                String des = etDes.getText().toString();
                String rating = etRating.getText().toString();
                listener.applyText(name,des,rating);
            }
        });

        etName = view.findViewById(R.id.naam);
        etDes = view.findViewById(R.id.des);
        etRating =view.findViewById(R.id.rating);




        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener)context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ExampleDialogListener{
        void applyText(String name,String des,String rating);
    }
}
