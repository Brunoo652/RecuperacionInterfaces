package com.afundacion.myaplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    //cierre del menú con la pulsación del botón Atrás o back de Android.
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int titleId = getTitle(item);
        showFragment(titleId);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }

    private void showFragment(int titleId) {
        Fragment fragment;


        setTitle(getString(titleId));
        switch (titleId){

            case R.string.menu_inicio:
                fragment = HomeFragment.newInstance(titleId);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, fragment)
                        .commit();
                break;


            case R.string.menu_listado:
                fragment = ListadoVideojuegos.newInstance(titleId);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, fragment)
                        .commit();
                break;


            case R.string.menu_acercade:
                fragment = AcercaDe.newInstance(titleId);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, fragment)
                        .commit();
                break;


        }


    }

    private int getTitle(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.incio:
                return R.string.menu_inicio;
            case R.id.listado:
                return R.string.menu_listado;
            case R.id.acerca_de:
                return R.string.menu_acercade;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }
    }
}
