package com.SATApp;

import android.app.Activity;
import android.app.LauncherActivity;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;


public class PracticeVocabActivity extends Activity {
    public List wordList;
    public List practiceList;
    public Word currentWord;
    public int currentIndex;
    Button option1Button;
    Button option2Button;
    Button option3Button;
    Button option4Button;
    TextView wordLabel;
    int score;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainWindow = new LinearLayout(this);
        mainWindow.setOrientation(LinearLayout.VERTICAL);
        setTitle("Sat Practice");
        //Create labels
        wordLabel = new TextView(this);
        //Add word label
        mainWindow.addView(wordLabel);
        //Create buttons
            //Button 1
            option1Button = new ButtonWrap(this);
            option1Button.setOnClickListener(new ButtonListener());
            //Button 2
            option2Button = new ButtonWrap(this);
            option2Button.setOnClickListener(new ButtonListener());
            //Button 3
            option3Button = new ButtonWrap(this);
            option3Button.setOnClickListener(new ButtonListener());
            //Button 4
            option4Button = new ButtonWrap(this);
            option4Button.setOnClickListener(new ButtonListener());
        //Add buttons to view
        mainWindow.addView(option1Button);
        mainWindow.addView(option2Button);
        mainWindow.addView(option3Button);
        mainWindow.addView(option4Button);
        //Set content view
        setContentView(mainWindow);
        wordList = SATApp.wordListObject.wordList;

        start();
    }


    public void start(){
        //Init the practice list for quizzing
        practiceList = new ArrayList<Word>();
        List tempList = wordList;
        Collections.shuffle(tempList);
        ArrayList defs;


        for(int x=0;x<wordList.size();x++){
            Word thisWord = (Word) wordList.get(x);
            defs = new ArrayList<String>();

            defs.add(thisWord.getDef());

            Word tempWord;

            for(int i=0;i<3;i++){
                tempWord = (Word) tempList.get(i);
                if(!tempWord.getDef().equals(thisWord.getDef())){
                    defs.add(tempWord.getDef());
                }
                else{
                    tempWord = (Word) tempList.get(i);
                    defs.add(tempWord.getDef());
                }
            }
            Collections.shuffle(defs);
            thisWord.setDef((String)defs.get(0),1);
            thisWord.setDef((String)defs.get(1),2);
            thisWord.setDef((String) defs.get(2),3);
            thisWord.setDef((String) defs.get(3),4);
            practiceList.add(thisWord);
        }
        Collections.shuffle(practiceList);
        currentIndex = 0;
        setCurrentWord(currentIndex);
    }
    public void setCurrentWord(int index){
        currentWord = (Word) practiceList.get(index);
        wordLabel.setText(currentWord.getWord());
        option1Button.setText(currentWord.getDef(1));
        option2Button.setText(currentWord.getDef(2));
        option3Button.setText(currentWord.getDef(3));
        option4Button.setText(currentWord.getDef(4));

    }
    public void changeWord(){
        currentIndex++;
        setCurrentWord(currentIndex);
    }
    public void checkAnswer(View clickedButton){
        String correctAns = currentWord.getDef();
        String submittedAns = "";
        if(clickedButton.equals(option1Button)){
            submittedAns = currentWord.getDef(1);
        }
        else if(clickedButton.equals(option2Button)){
            submittedAns = currentWord.getDef(2);
        }
        else if(clickedButton.equals(option3Button)){
            submittedAns = currentWord.getDef(3);
        }
        else if(clickedButton.equals(option4Button)){
            submittedAns = currentWord.getDef(4);
        }
        //Show if right or wrong
        if(submittedAns.equals(correctAns)){
            toast("Correct!");
            score++;
        }
        else{
            toast("Wrong! The correct answer is: " + currentWord.getDef());
        }

        if(currentIndex == wordList.size() - 1){
            showFriendListActivity(null);
        }else{
            changeWord();
        }

    }


    public void showFriendListActivity(View clickedButton) {
        //temp method for testing
        //inviteFriends();
        List<NameValuePair> intentExtras = new ArrayList<NameValuePair>();
        intentExtras.add(new BasicNameValuePair("score", score + "/" + wordList.size()));

        ActivityUtils.goToActivity(this, ScoreScreenActivity.class,intentExtras);
    }
    public void toast(String message){
        Toast tempMessage = Toast.makeText(PracticeVocabActivity.this,message,Toast.LENGTH_SHORT);
        tempMessage.show();
    }
    private class ButtonListener implements OnClickListener {
        public void onClick(View clickedButton){
            checkAnswer(clickedButton);
        }
    }
}






