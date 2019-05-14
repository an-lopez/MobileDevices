package com.escom.materialexample;

import android.os.Bundle;

import com.escom.materialexample.fragments.FriendsFragment;
import com.escom.materialexample.fragments.HomeFragment;
import com.escom.materialexample.fragments.MessagesFragment;
import com.escom.materialexample.utils.INavigationListener;
import com.escom.materialexample.utils.NavDrawerItemAdapter;
import com.escom.materialexample.utils.NavigationDrawerItem;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.util.Log;
import android.view.MenuItem;

import com.escom.materialexample.utils.RecyclerTouchListener;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    @BindView(R.id.rv_nv)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private List<NavigationDrawerItem> items;
    private Fragment fragment = null;
    private String title;
    private NavDrawerItemAdapter navDrawerItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        items = new ArrayList<>();

        navDrawerItemAdapter = new NavDrawerItemAdapter(items);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(navDrawerItemAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener(){
            @Override
            public void onClick(View view, int position) {
                Log.d(TAG, "onClick: "+position);
                switch (position){
                    case 0:
                        fragment = new HomeFragment();
                        title = items.get(position).getTitle();
                        break;
                    case 1:
                        fragment = new FriendsFragment();
                        title = items.get(position).getTitle();
                        break;
                    case 2:
                        fragment = new MessagesFragment();
                        title = items.get(position).getTitle();
                        break;
                }
                displayFragment();
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        populateRV();

        fragment = new HomeFragment();
        displayFragment();
    }

    private void populateRV() {
        items.add(new NavigationDrawerItem(true, "Home"));
        items.add(new NavigationDrawerItem(true, "Friends"));
        items.add(new NavigationDrawerItem(true, "Messages"));
        navDrawerItemAdapter.notifyDataSetChanged();
    }

    private void displayFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container_body, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
