package com.github.lopezantonio.easypav;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rv_practices;

    ExpandableListView expandableListView;
    MenuExpandableListAdapter expandableListAdapter;
    List<com.github.lopezantonio.easypav.Menu> groupList;
    HashMap<com.github.lopezantonio.easypav.Menu, List<com.github.lopezantonio.easypav.Menu>> childList;
    int prevExpandPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prevExpandPosition = -1;

        expandableListView = findViewById(R.id.elv_main);

        rv_practices = findViewById(R.id.rv_practices);

        populateExpandableList();
        populateRecyclerView();
    }

    private void generateListData(){
        groupList = new ArrayList<com.github.lopezantonio.easypav.Menu>();
        childList = new HashMap<>();

        com.github.lopezantonio.easypav.Menu menu = new com.github.lopezantonio.easypav.Menu("RIGIDOS", "", true, true, false);

        List<com.github.lopezantonio.easypav.Menu> childs = new ArrayList<>();
        childs.add(new com.github.lopezantonio.easypav.Menu("Pruebas Preliminares", "", false, false, true));
        childs.add(new com.github.lopezantonio.easypav.Menu("Pruebas en Fresco", "", false, false, false));
        childs.add(new com.github.lopezantonio.easypav.Menu("Pruebas de Resistencia", "", false, false, false));

        groupList.add(menu);
        childList.put(menu, childs);

        menu = new com.github.lopezantonio.easypav.Menu("FLEXBIBLES", "", true, true, false);
        childs.add(new com.github.lopezantonio.easypav.Menu("Pruebas Preliminares", "", false, false, false));
        childs.add(new com.github.lopezantonio.easypav.Menu("Pruebas de Mezclas Asfalticas", "", false, false, false));

        groupList.add(menu);
        childList.put(menu, childs);

    }

    private void populateExpandableList(){
        generateListData();

        expandableListAdapter = new MenuExpandableListAdapter(this, groupList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(prevExpandPosition >= 0 && prevExpandPosition != groupPosition){
                    expandableListView.collapseGroup(prevExpandPosition);
                }
                prevExpandPosition = groupPosition;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(groupList.get(groupPosition).isGroup()){

                }
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if(childList.get(groupList.get(groupPosition)) != null){
                    com.github.lopezantonio.easypav.Menu menu = childList.get(groupList.get(groupPosition)).get(childPosition);
                    Snackbar.make(v, menu.getNombre(), Snackbar.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void populateRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_practices.setLayoutManager(linearLayoutManager);

        PracticeAdapter practiceAdapter = new PracticeAdapter(generateRecyclerViewData());

        rv_practices.setAdapter(practiceAdapter);
    }

    private ArrayList<Practice> generateRecyclerViewData() {

        ArrayList<Practice> practices = new ArrayList<>();

        practices.add(new Practice("Practica 1: Granularidad", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));
        practices.add(new Practice("Practica 2: Peso Volúmetrico", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));
        practices.add(new Practice("Practica 3: Desgaste Los Ángeles", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));
        practices.add(new Practice("Practica 4: Peso espesor o densidad", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));
        practices.add(new Practice("Practica 5: Absorción", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));
        practices.add(new Practice("Practica 6: % de humedad", "https://www.youtube.com/watch?v=3VZcXTOjkuA", R.mipmap.ic_launcher));

        return practices;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
