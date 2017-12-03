package com.example.eliaschang8.tabsandnavdrawer.Modler;

import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by kmyohan0 on 11/17/2017.
 */

public class SaveToJson {

    String postJson;

    String title, date, author, content, featured, link;

    public SaveToJson (String postJson, String title, String date, String author, String content, String featured, String link) {
        this.postJson = postJson;
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
        this.featured = featured;
        this.link = link;
    }

    public boolean saveToJson() throws JSONException {
        //set jsonObject.
        JSONObject jsonObject = new JSONObject(postJson);
        //save article information to the savedArticle.json file from assets/
        jsonObject.put("title", title);
        jsonObject.put("date", date);
        jsonObject.put("author", author);
        jsonObject.put("content", content);
        jsonObject.put("featured", featured);
        jsonObject.put("link", link);

        return true;
    }
}
