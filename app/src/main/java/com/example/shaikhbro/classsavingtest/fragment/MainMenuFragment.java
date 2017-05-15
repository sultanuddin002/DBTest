package com.example.shaikhbro.classsavingtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shaikhbro.classsavingtest.MainActivity;
import com.example.shaikhbro.classsavingtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    Button preminaryStoreBtn, classElementStoreBtn, listStorageTestBtn;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        preminaryStoreBtn = (Button) view.findViewById(R.id.preliminary_btn);
        classElementStoreBtn = (Button) view.findViewById(R.id.class_element_btn);
        listStorageTestBtn = (Button) view.findViewById(R.id.list_storage_test);
        preminaryStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PriminaryStoreFragment());
            }
        });
        classElementStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new ObjectStoreFragment());
            }
        });
        listStorageTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new ObjectListStoreFragment());
            }
        });

        return view;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder_frame, fragment);
        fragmentTransaction.commit();
    }
}
