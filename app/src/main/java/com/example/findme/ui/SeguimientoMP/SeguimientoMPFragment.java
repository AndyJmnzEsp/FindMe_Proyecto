package com.example.findme.ui.SeguimientoMP;

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

import com.example.findme.databinding.FragmentSeguimientompBinding;
import com.example.findme.ui.Buzon.BuzonViewModel;

public class SeguimientoMPFragment extends Fragment {

    private SeguimientoMPViewModel seguimientoMPViewModel;
    private FragmentSeguimientompBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seguimientoMPViewModel =
                new ViewModelProvider(this).get(SeguimientoMPViewModel.class);

        binding = FragmentSeguimientompBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSeguimientomp;
        seguimientoMPViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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
