package com.example.eliaschang8.tabsandnavdrawer.Modler;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.ListView;

import com.example.eliaschang8.tabsandnavdrawer.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SavedActivity extends AppCompatActivity {

    private static final String TAG = "ON SAVED OPENED";
    private ArrayList<PostItem> postsArray;
    private ListView list;
    private String someVariable;
    private ViewPager viewPager;
    public static String ArticleJsonURL;
    private ArrayList<String> links = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArticleJsonURL = extras.getString("URLjson");
            links.add(ArticleJsonURL);

            if (savedInstanceState == null) {
                ExampleFragment fragment = new ExampleFragment();
                fragmentTransaction.add(R.id.fragment_activity_saved, fragment);
                fragmentTransaction.commit();
            }
        }

        SharedPreferences mPrefs = getSharedPreferences("label", 0);
        String mString = mPrefs.getString("tag", String.valueOf(links));

        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putString("tag", String.valueOf(links)).commit();

    }

    public static class ExampleFragment extends Fragment {
        String url;
        ArrayList links;

        public ExampleFragment() {
            this.url = url;
            this.links = links;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            ListView list = new ListView(getActivity());
            Log.d(TAG, "WREEEE: " + url);

            JSONParser parser = new JSONParser(this, list);
            parser.execute(ArticleJsonURL);


            return list;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("MyString", ArticleJsonURL);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.;
        String myString = savedInstanceState.getString("MyString");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArticleJsonURL = extras.getString("URLjson");
            links.add(ArticleJsonURL);

            if (savedInstanceState == null) {
                ExampleFragment fragment = new ExampleFragment();
                fragmentTransaction.add(R.id.fragment_activity_saved, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}
