package com.example.eliaschang8.tabsandnavdrawer.Presenter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.eliaschang8.tabsandnavdrawer.Modler.SavedActivity;
import com.example.eliaschang8.tabsandnavdrawer.Modler.TestScreen;
import com.example.eliaschang8.tabsandnavdrawer.Modler.ViewPagerAdapter;
import com.example.eliaschang8.tabsandnavdrawer.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private String[] pageTitle = {"Most Recent", "News", "Sports", "Feature", "Opinion"};

    public static String returnValue;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // do nothing, just override
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(("pref_dark_theme"), false)) {
        setTheme(R.style.AppTheme);
        }**/
        //UtilsTheme.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        CircularImageView profilePic = (CircularImageView) findViewById(R.id.circleprofile);

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        returnValue = sharedPref.getString("image", "android.resource://" + getApplicationContext().getPackageName() + "/drawable/default_profile_image");

        profilePic.setImageURI(Uri.parse(returnValue));

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageSelection.class);
                startActivityForResult(intent, 2);
            }
        });

        System.out.print("");

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);

        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //setting Tab layout (number of Tabs = number of ViewPager pages)
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 5; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //handling navigation view item event
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        //set viewpager adapter
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //change Tab selection when swipe ViewPager
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_forum) {
           Intent i = new Intent(this, ForumActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_saved_articles) {
            Intent i = new Intent(this, SavedActivity.class);
            startActivity(i);
        } //else if (id == R.id.nav_notifications) {
            viewPager.setCurrentItem(2);
            //UtilsTheme.changeToTheme(this, UtilsTheme.THEME_DARK);
        //} else if (id == R.id.nav_settings){
        //    Intent intent = new Intent(this, TestScreen.class);
        //    intent.putExtra("string", "Go to other Activity by NavigationView item cliked!");
        //    startActivity(intent);
       ///}

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        CircularImageView profilePic = (CircularImageView) findViewById(R.id.circleprofile);

        try {
            returnValue = data.getStringExtra("image");
        } catch (NullPointerException e ) {
            returnValue = returnValue;
        }

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putString("image", returnValue);
        editor.commit();

        profilePic.setImageURI(Uri.parse(returnValue));

    }
}
