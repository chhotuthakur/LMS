package com.nilesh.lms.activity;

import static com.nilesh.lms.R.id.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.nilesh.lms.LoginPageFrgmt;
import com.nilesh.lms.R;
import com.nilesh.lms.RegFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    TextView bsdk;
    BottomNavigationView gandu;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.chome_drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        GraphView graph;
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        gandu = findViewById(R.id.btn_con);


        // Find our drawer view
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.chome_nav_view);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

    }

    private void setupDrawerContent(NavigationView nvDrawer) {
        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.side_account:
                fragmentClass = LoginPageFrgmt.class;
                break;
            case R.id.side_course:
                fragmentClass = RegFragment.class;
                break;
//            case R.id.cust_side_vendors:
//                fragmentClass = VendorFragment.class;
//                break;
//            case R.id.cust_side_profile:
//                fragmentClass = ProfileFragment.class;
//                break;
//            case R.id.cust_side_noti:
//                fragmentClass = NotiFragment.class;
//                break;




            default:
                fragmentClass = LoginPageFrgmt.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.chome_fr_container, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        if (item.getItemId() == R.id.profile){
//            bsdk.setText("home");
//        } else if (item.getItemId() == R.id.cart){
//            bsdk.setText("cart");
//        }else if (item.getItemId() == R.id.setting){
//            bsdk.setText("setting");
//        }
        return false;
    }
}