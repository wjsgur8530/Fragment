package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class waterTankNum_2 extends Fragment {
    private View view;
    private String result;
    private Button btn_move;
    Integer water_Tank_Num;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2_watertanknum, container, false);

        RadioGroup rdiog_2_water_tank_num = (RadioGroup) view.findViewById(R.id.water_Tank_Num_rdogrp2);

        rdiog_2_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.water_Tank_Num_a2_1) {
                    water_Tank_Num = 1;
                } else if (checkedId == R.id.water_Tank_Num_a2_2) {
                    water_Tank_Num = 2;
                }
            }
        });

        //fragment에서는 findById가 바로 동작하지 않아서 view를 사용해 써야함.
        btn_move = view.findViewById(R.id.btn_move);


        //데이터 받는 곳
//        if(getArguments() != null) { //null
//            result = getArguments().getString("fromFrag1"); //프래그먼트1로부터 setArguments된 데이터를 받아옴.
//            tv_frag1.setText(result);
//        }

        btn_move.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String water_tank_num = Integer.toString(water_Tank_Num);

                Bundle bundle = new Bundle(); // 무언가를 담는 공간
                bundle.putString("submit", water_tank_num); //id, content 마지막 페이지로 데이터 전달
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                waterTankClean_3 watertankclean_3 = new waterTankClean_3();
                watertankclean_3.setArguments(bundle);
                transaction.replace(R.id.framelayout, watertankclean_3); //프레임레이아웃은 가만히 있는 상태에서 프래그먼트만 교체, (frame, 교체될 fragment)
                transaction.commit(); // 저장, 저장하지 않으면 바뀌지 않음.
            }
        });

        return view;
    }
}
