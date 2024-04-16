package com.softulp.tp4.ui.llamar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.tp4.databinding.FragmentHomeBinding;

public class LlamarFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LlamarViewModel llamarViewModel =
                new ViewModelProvider(this).get(LlamarViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        llamarViewModel.getMsjError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String msjError) {
                binding.tvMsjError.setText(msjError);
            }
        });
        binding.btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = binding.etNumero.getText().toString();


                llamarViewModel.llamar(num);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}