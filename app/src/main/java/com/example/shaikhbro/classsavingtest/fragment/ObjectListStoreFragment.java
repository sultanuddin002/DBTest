package com.example.shaikhbro.classsavingtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shaikhbro.classsavingtest.R;
import com.example.shaikhbro.classsavingtest.pojo.MyPOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectListStoreFragment extends Fragment {

    MyPOJO[] myPOJOs;

    public ObjectListStoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_object_list_store, container, false);

        // hard code value insertion
//        ArrayList<MyPOJO> myPOJOs = new ArrayList<>();
//        myPOJOs.add(new MyPOJO(2,5.5f,"nice"));
//        myPOJOs.add(new MyPOJO(3,6.6f,"oops"));
//        myPOJOs.add(new MyPOJO(4,7.7f,"Well!"));
//
        myPOJOs = new MyPOJO[]{new MyPOJO(2, 5.5f, "nice"), new MyPOJO(3, 6.6f, "oops"), new MyPOJO(4, 7.7f, "Well!")};
        ListView listView = (ListView) view.findViewById(R.id.listview);
        // show only numbers/integers
        List<String> names = new ArrayList<>();
        for (int i = 0; i < myPOJOs.length; i++) {
            names.add(i, myPOJOs[i].getText());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "Its number is = " + myPOJOs[i].getNumber() + " and decimal is = " + myPOJOs[i].getDecimal(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
