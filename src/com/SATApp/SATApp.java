package com.SATApp;

import android.app.*;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.android.*;
import com.facebook.android.Facebook.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class SATApp extends Activity {

    public final String TAG = "SATApp";
    public static WordList wordListObject;
    private Handler mHandler;

    String xmlFileName = "englishvocab.xml";   //satwords.xml
    // application id from facebook.com/developers


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        // setup the facebook session

        //handleFacebook();
        getXMLData();
        //connect basically
        //new SendData().execute();

    }


    public void showPracticeVocab(View clickedButton) {
        ActivityUtils.goToActivity(this, PracticeVocabActivity.class,null);
    }
    public void showLearnVocab(View clickedButton) {
        ActivityUtils.goToActivity(this, LearnVocabActivity.class,null);
    }
    public WordList getXMLData(){
        try{
            //"file:///android_asset/image.png"
            //URL fileURL = new URL("file:///android_res/xml/satwords.xml");
            //Uri path = Uri.parse("android.resource://com.SATApp/xml/satwords.xml");
            String xmlString = "";
            InputStream inputStream = getAssets().open(xmlFileName);   //change file name here

            StringBuffer strBuffer = new StringBuffer();

            byte[] b = new byte[4096];

            for (int n; (n = inputStream.read(b)) != -1;) {
                strBuffer.append(new String(b, 0, n));
            }
            inputStream.close();
            xmlString = strBuffer.toString();

            //Creating doc for XML parsing
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse(xmlFile);
            Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xmlString.getBytes("utf-8"))));
            doc.getDocumentElement().normalize();
            wordListObject = new WordList(doc);

        }catch(Exception e){
            Log.d(TAG,"ERROR" + e.getMessage());
        }
        return wordListObject;
    }
}
