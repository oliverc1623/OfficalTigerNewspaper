package com.example.eliaschang8.tabsandnavdrawer.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class UtilsTheme
{
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_DARK = 1;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(AppCompatActivity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        //activity.recreate();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /** Set the theme of the activity, according to the configuration.
    public static void onActivityCreateSetTheme(AppCompatActivity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_DARK:
                activity.setTheme(R.style.AppSecondaryTheme);
                break;
        }
    }**/
}

