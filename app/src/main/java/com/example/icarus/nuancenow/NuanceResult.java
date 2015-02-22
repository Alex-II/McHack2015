package com.example.icarus.nuancenow;

import android.content.Context;
import android.widget.Toast;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechError;

/**
 * Created by Alex on 21/02/2015.
 */
public class NuanceResult implements Recognizer.Listener {

    static public String result;
    Context context;
    Recognizer reco;
    NuanceS2T.IFunctionNuanceS2T callbackFunction;

    public NuanceResult(Context context_arg, Recognizer reco_arg) { // IFunctionNuanceS2T callbackFunction_arg) {
        context = context_arg;
        reco = reco_arg;
        //callbackFunction = callbackFunction_arg;
    }

    @Override
    public void onError(Recognizer recognizer, SpeechError speechError) {
        Toast.makeText(context, "NuanceResult.onError",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResults(Recognizer recognizer, Recognition recoz) {

        Recognition.Result res = recoz.getResult(0);
        String sentence = res.getText();
        //callbackFunction.handleTextFromSpeech(sentence);

        Toast.makeText(context, sentence ,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRecordingBegin(Recognizer recognizer) {
        Toast.makeText(context, "NuanceResult.onRecordingBegin",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRecordingDone(Recognizer recognizer) {
        Toast.makeText(context, "NuanceResult.onRecodingDone",
                Toast.LENGTH_LONG).show();
     }
}