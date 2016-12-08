package com.example.aleksander.nazdrowie;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentSasza fragmentSasza;
    FragmentAdrian fragmentAdrian;
    FragmentJacek fragmentJacek;
    FragmentKamil fragmentKamil;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            fragmentSasza = new FragmentSasza();
            manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.frgmCont,
                    fragmentSasza,
                    fragmentSasza.getTag()
            ).commit();

        } else if (id == R.id.nav_gallery) {
            fragmentAdrian = new FragmentAdrian();
            manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.frgmCont,
                    fragmentAdrian,
                    fragmentAdrian.getTag()
            ).commit();
        } else if (id == R.id.nav_slideshow) {
            fragmentKamil = new FragmentKamil();
            manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.frgmCont,
                    fragmentKamil,
                    fragmentKamil.getTag()
            ).commit();
        } else if (id == R.id.nav_manage) {
            fragmentJacek = new FragmentJacek();
            manager = getSupportFragmentManager();
            manager.beginTransaction().replace(
                    R.id.frgmCont,
                    fragmentJacek,
                    fragmentJacek.getTag()
            ).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
