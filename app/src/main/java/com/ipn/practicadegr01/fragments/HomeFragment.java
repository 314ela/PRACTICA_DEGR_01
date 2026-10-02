package com.ipn.practicadegr01.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.ipn.practicadegr01.R;
import com.ipn.practicadegr01.adapters.CarouselAdapter;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        configurarCarrusel(root);

        // El texto y los iconos ya vienen fijos en el XML; aquí solo dejamos
        // los clics para que se sienta interactivo (muestran un Toast).
        root.findViewById(R.id.btnVerBeneficio).setOnClickListener(v -> toast("Aerolínea Mexicana"));
        root.findViewById(R.id.cardCredencial).setOnClickListener(v -> toast("Credencial"));
        root.findViewById(R.id.cardRadio).setOnClickListener(v -> toast("Radio IPN"));
        root.findViewById(R.id.cardHorario).setOnClickListener(v -> toast("Mi Horario"));
        root.findViewById(R.id.cardEmergencias).setOnClickListener(v -> toast("Emergencias"));
        root.findViewById(R.id.rowEventos).setOnClickListener(v -> toast("Eventos"));
        root.findViewById(R.id.rowNoticiasHome).setOnClickListener(v -> toast("Noticias"));
        root.findViewById(R.id.rowGaceta).setOnClickListener(v -> toast("Gaceta"));
        root.findViewById(R.id.rowCartelera).setOnClickListener(v -> toast("Cartelera"));
        root.findViewById(R.id.rowDenuncia).setOnClickListener(v -> toast("Denuncia segura"));

        return root;
    }

    private void configurarCarrusel(View root) {
        ViewPager2 viewPager = root.findViewById(R.id.vpCarousel);
        List<String> captions = Arrays.asList(
                getString(R.string.noticia_1),
                getString(R.string.noticia_2),
                getString(R.string.noticia_3),
                getString(R.string.noticia_4),
                getString(R.string.noticia_5)
        );
        viewPager.setAdapter(new CarouselAdapter(captions));

        // Indicadores (puntos) debajo del carrusel
        ViewGroup dotsContainer = root.findViewById(R.id.dotsContainer);
        View[] dots = new View[captions.size()];
        for (int i = 0; i < captions.size(); i++) {
            View dot = new View(requireContext());
            int size = (int) (8 * getResources().getDisplayMetrics().density);
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(size, size);
            params.setMarginEnd((int) (4 * getResources().getDisplayMetrics().density));
            dot.setLayoutParams(params);
            dot.setBackgroundResource(i == 0 ? R.drawable.bg_dot_active : R.drawable.bg_dot_inactive);
            dotsContainer.addView(dot);
            dots[i] = dot;
        }

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dots.length; i++) {
                    dots[i].setBackgroundResource(i == position
                            ? R.drawable.bg_dot_active
                            : R.drawable.bg_dot_inactive);
                }
            }
        });
    }

    private void toast(String texto) {
        Toast.makeText(requireContext(), texto, Toast.LENGTH_SHORT).show();
    }
}
