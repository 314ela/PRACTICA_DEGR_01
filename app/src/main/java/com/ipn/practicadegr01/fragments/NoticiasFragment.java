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

public class NoticiasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_noticias, container, false);

        int[] ids = {
                R.id.news1, R.id.news2, R.id.news3, R.id.news4, R.id.news5,
                R.id.catEventos, R.id.catDeportes, R.id.catPulso, R.id.catAcademia,
                R.id.catCiencia, R.id.catRelaciones,
                R.id.rowGacetaQuincenal, R.id.rowGacetaExtra
        };
        for (int id : ids) {
            root.findViewById(id).setOnClickListener(v ->
                    Toast.makeText(requireContext(), getString(R.string.proximamente), Toast.LENGTH_SHORT).show());
        }

        return root;
    }
}
