package com.example.shaikhbro.classsavingtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaikhbro.classsavingtest.R;
import com.example.shaikhbro.classsavingtest.Utils.DBHelper;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A simple {@link Fragment} subclass.
 */
public class PriminaryStoreFragment extends Fragment {

    // views reference for integer
    EditText integerInput;
    Button integerSaveBtn;
    TextView integerResult;

    // views reference for float
    EditText floatInput;
    Button floatSaveBtn;
    TextView floatResult;

    // views referemce for String
    EditText stringInput;
    Button stringSaveBtn;
    TextView stringResult;


    // DB create
    DBHelper dbHelper;

    public PriminaryStoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_priminary_store, container, false);

        // point object reference to views for integer
        integerInput = (EditText) view.findViewById(R.id.interger_value);
        integerSaveBtn = (Button) view.findViewById(R.id.integer_save_btn);
        integerResult = (TextView) view.findViewById(R.id.integer_value_result);

        // point object reference to views for float
        floatInput = (EditText) view.findViewById(R.id.float_value);
        floatSaveBtn = (Button) view.findViewById(R.id.float_save_btn);
        floatResult = (TextView) view.findViewById(R.id.float_value_result);

        // point object reference to views for String
        stringInput = (EditText) view.findViewById(R.id.string_value);
        stringSaveBtn = (Button) view.findViewById(R.id.string_save_btn);
        stringResult = (TextView) view.findViewById(R.id.string_value_result);

        // logic when integer save button is pressed
        integerSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the input is not empty
                String inputValue = integerInput.getText().toString();
                if (!inputValue.equals("")) {
                    if (new BigInteger(inputValue).intValue() > 100000) {
                        Toast.makeText(getContext(), "Integer value cant exceed 100000", Toast.LENGTH_SHORT).show();

                    } else {
                        // save the value inside new DB
                        dbHelper = new DBHelper();

                        // create db for the first time
                        dbHelper.createDB(getContext());

                        // save integer inside DB with unique key
                        dbHelper.saveInt(getContext(), Integer.valueOf(inputValue));

                        // subsequently, show int in the result by getting integer from DB
                        integerResult.setText(Integer.toString(dbHelper.getInt(getContext())));
                    }
                }
                if (inputValue.equals("")) {
                    Toast.makeText(getContext(), "Integer input can't be empty", Toast.LENGTH_SHORT).show();

                }
            }
        });


        // logic when float save button is pressed
        floatSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the input is not empty
                String floatValue = floatInput.getText().toString();

                if (!floatValue.equals("")) {
                    if (new BigDecimal(floatValue).floatValue() > 100000f) {
                        Toast.makeText(getContext(), "Float value cant exceed 100000", Toast.LENGTH_SHORT).show();

                    } else {
                        // save the value inside new DB
                        dbHelper = new DBHelper();

                        // create db for the first time
                        dbHelper.createDB(getContext());

                        // save float inside DB with unique key
                        dbHelper.saveFloat(getContext(), Float.valueOf(floatValue));

                        // subsequently, show float in the result by getting float from DB
                        floatResult.setText(Float.toString(dbHelper.getFloat(getContext())));
                    }
                }
                if (floatValue.equals("")) {
                    Toast.makeText(getContext(), "Float input can't be empty", Toast.LENGTH_SHORT).show();

                }
            }
        });


        // logic when String save button is pressed
        stringSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the input is not empty
                if (stringInput.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "String input can't be empty", Toast.LENGTH_SHORT).show();
                } else {
                    // save the value inside new DB
                    dbHelper = new DBHelper();

                    // create db for the first time
                    dbHelper.createDB(getContext());

                    // save String inside DB with unique key
                    dbHelper.saveString(getContext(), stringInput.getText().toString());

                    // subsequently, show String in the result by getting String from DB
                    stringResult.setText(dbHelper.getString(getContext()));
                }
            }
        });
        return view;
    }

}
