package com.ipn.practicadegr01.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ipn.practicadegr01.R;

public class AcademicoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_academico, container, false);

        int[] ids = {
                R.id.cardProgreso,
                R.id.cardHistorial, R.id.cardHorarioAcad, R.id.cardCredencialAcad, R.id.cardNotifAcad,
                R.id.calEscolarizada, R.id.calNoEscolarizada
        };
        for (int id : ids) {
            root.findViewById(id).setOnClickListener(v ->
                    Toast.makeText(requireContext(), getString(R.string.proximamente), Toast.LENGTH_SHORT).show());
        }

        return root;
    }
}
