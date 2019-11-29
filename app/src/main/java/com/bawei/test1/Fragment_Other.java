package com.bawei.test1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Other extends Fragment {

    private Button bt_git;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_other,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt_git = getActivity().findViewById(R.id.bt_git);
        final RadioGroup ra = getActivity().findViewById(R.id.ra);
        bt_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ra.check(ra.getChildAt(2).getId());
                System.out.println("这是子分支");

            }
        });
    }
}
