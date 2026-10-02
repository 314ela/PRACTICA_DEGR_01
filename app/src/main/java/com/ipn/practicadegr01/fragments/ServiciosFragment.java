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

public class ServiciosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_servicios, container, false);

        int[] ids = {
                R.id.rowCredencialEscolar, R.id.rowBecas, R.id.rowRegistroExamen, R.id.rowReinscripcion,
                R.id.rowNss, R.id.rowImss, R.id.rowPrevenimss, R.id.rowSegurosVida,
                R.id.rowAerolinea,
                R.id.rowCalendarioEscolar, R.id.rowBeneficios, R.id.rowSendero,
                R.id.rowRadioServ, R.id.rowCanalOnce, R.id.rowGacetaServ, R.id.rowCarteleraServ,
                R.id.rowBotonPanico, R.id.rowNumerosEmergencia, R.id.rowDenunciaServ
        };
        for (int id : ids) {
            root.findViewById(id).setOnClickListener(v ->
                    Toast.makeText(requireContext(), getString(R.string.proximamente), Toast.LENGTH_SHORT).show());
        }

        return root;
    }
}
