package com.SATApp;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 8/22/12
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordList {

    public final String TAG = "SATApp";
    public Document doc;
    public List wordList = new ArrayList();

    public WordList(Document pDoc){
        this.doc = pDoc;
        parseXMLDoc();
    }
    public void parseXMLDoc(){
        wordList = new ArrayList<Word>();
        NodeList satWordTagList = doc.getElementsByTagName("SATWord");
        Word newWord;
        String word = "";
        String def = "";
        String pron = "";
        for(int x=0;x<satWordTagList.getLength();x++){
            word = satWordTagList.item(x).getChildNodes().item(1).getTextContent();   //"1" word node
            def = satWordTagList.item(x).getChildNodes().item(3).getTextContent();    //"3" def node
            pron = satWordTagList.item(x).getChildNodes().item(5).getTextContent();    //"5" Im guessing its 5 from previous examples
            newWord = new Word(word,def,pron);
            wordList.add(newWord);
        }
    }
    public void printList(List list){
        for(int x=0;x<list.size();x++){
            Word thisWord = (Word) list.get(x);
            Log.d(TAG,thisWord.getWord() + ": " + thisWord.getDef());
        }
    }
}
