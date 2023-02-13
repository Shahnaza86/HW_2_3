package com.example.hw_2_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private TextView text;
    private Button plus;
    private Button minus;
    private Button next;
     private int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();



    }

    private void initListener() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                text.setText(Integer.toString(i));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                text.setText(Integer.toString(i));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("KEY",text.getText().toString());
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment)
                        .addToBackStack(null).commit();

            }
        });

    }

    private void initView() {
        text = requireActivity().findViewById(R.id.text);
        plus = requireActivity().findViewById(R.id.plus);
        minus = requireActivity().findViewById(R.id.minus);
        next = requireActivity().findViewById(R.id.next);

    }

}