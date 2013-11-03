package com.SATApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 12/20/12
 * Time: 10:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoreScreenActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);


        Bundle extras = getIntent().getExtras();
        String score = extras.getString("score");
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(score);
    }





    public void showMainScreen(View clickedButton) {
        ActivityUtils.goToActivity(this, SATApp.class,null);
    }
}
