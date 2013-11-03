package com.SATApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class LearnVocabActivity extends Activity {
    public final int practiceLength = 20;
    public List wordList;
    public List practiceList;
    public Word currentWord;
    public int currentIndex;
    Button backButton;
    Button nextButton;
    TextView wordLabel;
    TextView pronLabel;
    TextView defLabel;
    TextView indexLabel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);
        wordLabel = (TextView) findViewById(R.id.word_view);
        pronLabel = (TextView)findViewById(R.id.pron_view);
        defLabel = (TextView) findViewById(R.id.def_view);
        indexLabel = (TextView) findViewById(R.id.index_view);
        backButton = (Button) findViewById(R.id.backButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        wordList = SATApp.wordListObject.wordList;
        start();
    }
    public void start(){
        Collections.shuffle(wordList);
        currentIndex = 0;
        setCurrentWord(currentIndex);
    }
    public void setCurrentWord(int index){
        currentWord = (Word) wordList.get(index);
        wordLabel.setText(currentWord.getWord());
        pronLabel.setText(currentWord.getPron());
        defLabel.setText(currentWord.getDef());
        indexLabel.setText((currentIndex + 1) + "/" + wordList.size());
    }
    public void changeWord(View clickedButton){
        if(clickedButton.equals(nextButton)){
            moveIndex(1);
        }
        else if(clickedButton.equals(backButton)){
            moveIndex(-1);
        }
        setCurrentWord(currentIndex);
    }
    public void moveIndex(int amt){
        int limit = wordList.size() - 1;
        int testMove = currentIndex + amt;
        if(testMove == -1){
            currentIndex = limit;
        }
        else if(testMove == limit){
            currentIndex = 0;
        }
        else{
            currentIndex += amt;
        }
    }
}
