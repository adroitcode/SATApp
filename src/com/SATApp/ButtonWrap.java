package com.SATApp;

import android.content.Context;
import android.widget.Button;


public class ButtonWrap extends Button {
    int id;
    String value;
    public ButtonWrap(Context context) {
        super(context);
    }
    public void setValue(String passedValue){
        value = passedValue;
    }
    public void setId(int passedId){
        id =   passedId;
    }
    public String getValue(){
        return value;
    }
    public int getId(){
        return id;
    }
}
