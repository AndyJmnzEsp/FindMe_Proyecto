package com.example.findme.ui.Organizacion;

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

import com.example.findme.databinding.FragmentOrganizacionesBinding;

public class OrganizacionFragment extends Fragment {

    private com.example.findme.ui.Organizacion.OrganizacionViewModel organizacionViewModel;
    private FragmentOrganizacionesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        organizacionViewModel =
                new ViewModelProvider(this).get(com.example.findme.ui.Organizacion.OrganizacionViewModel.class);

        binding = FragmentOrganizacionesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOrganaizacion;
        organizacionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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