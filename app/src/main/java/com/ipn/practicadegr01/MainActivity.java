package com.ipn.practicadegr01;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ipn.practicadegr01.fragments.AcademicoFragment;
import com.ipn.practicadegr01.fragments.HomeFragment;
import com.ipn.practicadegr01.fragments.NoticiasFragment;
import com.ipn.practicadegr01.fragments.PerfilFragment;
import com.ipn.practicadegr01.fragments.ServiciosFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        // La pantalla inicial casita
        if (savedInstanceState == null) {
            mostrarFragmento(new HomeFragment());
        }

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                mostrarFragmento(new HomeFragment());
                return true;
            } else if (id == R.id.nav_noticias) {
                mostrarFragmento(new NoticiasFragment());
                return true;
            } else if (id == R.id.nav_servicios) {
                mostrarFragmento(new ServiciosFragment());
                return true;
            } else if (id == R.id.nav_academico) {
                // mostrar el diseño
                mostrarFragmento(new AcademicoFragment());
                return true;
            } else if (id == R.id.nav_perfil) {
                mostrarFragmento(new PerfilFragment());
                return true;
            }
            return false;
        });
    }

    private void mostrarFragmento(@NonNull Fragment fragmento) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragmento);
        ft.commit();
    }
}
