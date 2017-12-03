package com.example.eliaschang8.tabsandnavdrawer.Modler;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by kmyohan0 on 11/17/2017.
 */

public class SavedJsonParser extends AsyncTask<String, Void, String> {

    private static final String TAG = "TAG";
    private ArrayList<String> imageUrlList = new ArrayList<>();

    String postJSON = "";

    String title, date, author, content, featured, link;

    private ArrayList<PostItem>postsArray;
    Fragment fragmentActivity;
    ListView list;

    public SavedJsonParser(Fragment fragmentActivity, ListView list) throws JSONException {
        this.fragmentActivity = fragmentActivity;
        this.list = list;
        loadJSONFromAsset();
            readJson();
    }

    private void readJson() throws JSONException {
        JSONObject jsonObject = new JSONObject(postJSON);
        title = jsonObject.getString(title);
        date = jsonObject.getString(date);
        author = jsonObject.getString(author);
        content = jsonObject.getString(content);
        featured = jsonObject.getString(link);
    }

    public void loadJSONFromAsset() {
        String json = null;
        try {

            FileInputStream fis = new FileInputStream(new File("assets/savedArticle.json"));


            int size = fis.available();

            byte[] buffer = new byte[size];

            fis.read(buffer);

            fis.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            }
        postJSON = json;
    }

    public void fillList(){
        PostAdapter adapter = new PostAdapter(fragmentActivity.getActivity(), postsArray);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(fragmentActivity.getActivity(), "" + postsArray.get(position).getContent(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(fragmentActivity.getActivity(), ArticlePage.class);
                Bundle bundle = new Bundle();
                bundle.putString("TITLE", title);
                bundle.putString("DATE", date);
                bundle.putString("AUTHOR", author);
                bundle.putString("CONTENT", content);
                bundle.putString("FEATURED",featured);
                bundle.putString("LINK", link);
                intent.putExtras(bundle);

                fragmentActivity.startActivity(intent);
            }
        });
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}




