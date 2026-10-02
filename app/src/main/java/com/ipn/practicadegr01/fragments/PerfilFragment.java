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

public class PerfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        root.findViewById(R.id.btnCerrarSesion).setOnClickListener(v ->
                Toast.makeText(requireContext(), getString(R.string.cerrar_sesion), Toast.LENGTH_SHORT).show());

        int[] ids = {
                R.id.rowNotifPerfil, R.id.rowProblemasAcceso, R.id.rowProblemasApp,
                R.id.btnAppStore, R.id.btnGooglePlay
        };
        for (int id : ids) {
            root.findViewById(id).setOnClickListener(v ->
                    Toast.makeText(requireContext(), getString(R.string.proximamente), Toast.LENGTH_SHORT).show());
        }

        return root;
    }
}
