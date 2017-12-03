package com.example.eliaschang8.tabsandnavdrawer.Presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eliaschang8.tabsandnavdrawer.Modler.DesActivity;
import com.example.eliaschang8.tabsandnavdrawer.Modler.JSONParser;
import com.example.eliaschang8.tabsandnavdrawer.Modler.PostItem;
import com.example.eliaschang8.tabsandnavdrawer.Modler.SavedJsonParser;
import com.example.eliaschang8.tabsandnavdrawer.R;

import org.json.JSONException;

import java.util.ArrayList;

public class Saved extends Fragment {
    private static final String TAG = "TAG";
    private ArrayList<PostItem> postsArray;
    private ListView list;
    private String ArticleJsonURL;

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        Log.d(TAG, "onCreateView: HHHHHHH " + ArticleJsonURL);
        JSONParser parser = new JSONParser(this, list);
        parser.execute("http://tigernewspaper.com/wordpress/wp-json/wp/v2/posts?_embed");

        //ListView list = (ListView) view.findViewById(R.id.listView_saved_fragment);
        //JSONParser parser = new JSONParser(this, list);
        //parser.execute(ArticleJsonURL);

//        Log.d(TAG, "IN SAVED: WE  aRE OPEN");
//
//        list = (ListView) view.findViewById(R.id.listView_saved);
//        JSONParser parser = new JSONParser(this, list);
//        parser.execute(someVariable);

//        try {
//            //SavedJsonParser savedJsonParser = new SavedJsonParser(this, list);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        if(list != null){
            Log.d("Saved", "Yes");
        }

        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);

//        Log.d(TAG, "IN SAVED: WE  aRE OPEN");
//
//        list = (ListView) view.findViewById(R.id.listView_saved);
//        JSONParser parser = new JSONParser(this, list);
//        parser.execute(someVariable);
//
////        try {
////            //SavedJsonParser savedJsonParser = new SavedJsonParser(this, list);
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
//
//        if(list != null){
//            Log.d("Saved", "Yes");
//        }
    }

}
