package com.example.findme.ui.Buzon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.findme.ui.Buzon.BuzonViewModel;
import com.example.findme.databinding.FragmentBuzonBinding;

public class BuzonFragment extends Fragment {

    private BuzonViewModel buzonViewModel;
    private FragmentBuzonBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buzonViewModel =
                new ViewModelProvider(this).get(BuzonViewModel.class);

        binding = FragmentBuzonBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textBuzon;
        buzonViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}