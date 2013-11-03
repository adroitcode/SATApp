package com.SATApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import org.apache.http.NameValuePair;

import java.util.List;

public class ActivityUtils {

    public static void goToActivity(Context currentActivity,Class<? extends Activity> newClass,List<NameValuePair> extras ) {
        Intent newActivity = new Intent(currentActivity, newClass);

        if(extras != null){
            NameValuePair thisExtra = null;
            for(int x=0;x<extras.size();x++){
                thisExtra = extras.get(x);
                newActivity.putExtra(thisExtra.getName(),thisExtra.getValue());
            }
        }

        currentActivity.startActivity(newActivity);
    }
}