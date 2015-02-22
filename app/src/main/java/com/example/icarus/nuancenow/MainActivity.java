package com.example.icarus.nuancenow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;




public class MainActivity extends Activity implements NuanceS2T.IFunctionNuanceS2T {

//    static final byte[] SpeechKitApplicationKey = { (byte)0xda , (byte)0x4d , (byte)0x90 , (byte)0xd1 , (byte)0x8a , (byte)0x06 , (byte)0x20 , (byte)0xc8 , (byte)0x16 , (byte)0xee , (byte)0xb6 , (byte)0xc6 , (byte)0x48 , (byte)0xcb , (byte)0x36 , (byte)0x6c , (byte)0xee , (byte)0x92 , (byte)0x4e , (byte)0x76 , (byte)0x0c , (byte)0x27 , (byte)0xd5 , (byte)0x17 , (byte)0x10 , (byte)0x94 , (byte)0x7b , (byte)0x7d , (byte)0x8b , (byte)0x2a , (byte)0xaa , (byte)0x66 , (byte)0x77 , (byte)0x3b , (byte)0x37 , (byte)0x01 , (byte)0x41 , (byte)0x57 , (byte)0xc9 , (byte)0x57 , (byte)0x45 , (byte)0x7f , (byte)0x1e , (byte)0x8e , (byte)0x4a , (byte)0x54 , (byte)0xfa , (byte)0x39 , (byte)0xe6 , (byte)0x48 , (byte)0xaf , (byte)0xf2 , (byte)0x6f , (byte)0x84 , (byte)0x0a , (byte)0x7f , (byte)0x18 , (byte)0x85 , (byte)0xfd , (byte)0xa4 , (byte)0xaf , (byte)0xa7 , (byte)0x0a , (byte)0x26 };
//    Vocalizer voc;
    Context context;
//    Recognizer reco;

    public void nuanceMe(View v) {
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText("where my swag?!!!");

        NuanceS2T s2t = new NuanceS2T(context);
        s2t.speech2Text();
        //voc.speakString("where my swag bro?", context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.textView);

        t.setText("where my swag");

        context = getApplication().getApplicationContext();

//        String appID  = "NMDPTRIAL_alcoolex20150221163155";
//        String serverHost = "sandbox.nmdp.nuancemobility.net";
//        int serverPort = 443;


//        SpeechKit sk = SpeechKit.initialize(context, appID, serverHost, serverPort, false, SpeechKitApplicationKey );
//        // optional
//        sk.connect();

//        Handler handler = new Handler();
//
//
//        // nuanceResult object gets results and errors; implements an interface
//        NuanceResult nuanceResult = new NuanceResult(context, reco);
//        reco = sk.createRecognizer(Recognizer.RecognizerType.Dictation,
//                Recognizer.EndOfSpeechDetection.Short,
//                "eng-USA", nuanceResult, handler);
//
//
//        Handler handler2 = new Handler();
//
//        NuanceVocalizer nuanceVocalizer = new NuanceVocalizer(context);
//        voc = sk.createVocalizerWithLanguage("en_US", nuanceVocalizer, handler2);
//


    }

    public void onResults(Recognizer recognizer, Recognition results) {
        String topResult;
        if (results.getResultCount() > 0) {
            topResult = results.getResult(0).getText();
            // do something with topResult...
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void handleTextFromSpeech(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
