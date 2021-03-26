package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//ctrl+O oncreateview
public class Fragment2 extends Fragment {

    private View view;
    private TextView tv_frag2;
    private Button btn_move;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2, container, false);

        //fragment에서는 findById가 바로 동작하지 않아서 view를 사용해 써야함.
        tv_frag2 = view.findViewById(R.id.tv_frag2);
        btn_move = view.findViewById(R.id.btn_move);


        //데이터 받는 곳
        if(getArguments() != null) { //null
            result = getArguments().getString("submit"); //프래그먼트1로부터 setArguments된 데이터를 받아옴.
            tv_frag2.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 무언가를 담는 공간
                bundle.putString("fromFrag2", "프래그먼트2"); //id, content
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.framelayout, fragment1); //프레임레이아웃은 가만히 있는 상태에서 프래그먼트만 교체, (frame, 교체될 fragment)
                transaction.commit(); // 저장, 저장하지 않으면 바뀌지 않음.
            }
        });

        return view;
    }
}
