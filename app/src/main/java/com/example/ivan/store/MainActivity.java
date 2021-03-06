package com.example.ivan.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            setTitle("Главная");
            FragmentHome fh = new FragmentHome();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fh).commit();
        } else if (id == R.id.nav_account) {
            setTitle("Мой профиль");
            FragmentAccount fa = new FragmentAccount();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fa).commit();
        } else if (id == R.id.nav_products) {
            setTitle("Каталог товаров");
            FragmentProducts fp = new FragmentProducts();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fp).commit();

        } else if (id == R.id.nav_basket) {
            setTitle("Корзина");
            FragmentBasket fb = new FragmentBasket();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fb).commit();
        } else if (id == R.id.nav_history) {
            setTitle("Мои заказы");
            FragmentHistory fhis = new FragmentHistory();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fhis).commit();
        } else if (id == R.id.nav_messages) {
            setTitle("Мои сообщения");
            FragmentMessages fmes = new FragmentMessages();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fmes).commit();
        } else if (id == R.id.nav_settings) {
            setTitle("Настройки");
            FragmentSettings fs = new FragmentSettings();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fs).commit();
        } else if (id == R.id.nav_reviews) {
            setTitle("Мои отзывы");
            FragmentReviews fr = new FragmentReviews();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, fr).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
