package com.SATApp;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 9/5/12
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Toast {
    public Toast(){

    }

    public static void toast(Context currentActivity,String message){
        android.widget.Toast tempMessage = android.widget.Toast.makeText(currentActivity, message, android.widget.Toast.LENGTH_LONG);
        tempMessage.show();
    }
}
