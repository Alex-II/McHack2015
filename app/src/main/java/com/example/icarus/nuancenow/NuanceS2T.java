package com.example.icarus.nuancenow;

import android.content.Context;
import android.os.Handler;

import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechKit;

/**
 * Created by Alex on 21/02/2015.
 */
public class NuanceS2T{
    static private String appID  = "NMDPTRIAL_alcoolex20150221163155";
    static private String serverHost = "sandbox.nmdp.nuancemobility.net";
    static final int serverPort = 443;
    static final byte[] SpeechKitApplicationKey = { (byte)0xda , (byte)0x4d , (byte)0x90 , (byte)0xd1 , (byte)0x8a , (byte)0x06 , (byte)0x20 , (byte)0xc8 , (byte)0x16 , (byte)0xee , (byte)0xb6 , (byte)0xc6 , (byte)0x48 , (byte)0xcb , (byte)0x36 , (byte)0x6c , (byte)0xee , (byte)0x92 , (byte)0x4e , (byte)0x76 , (byte)0x0c , (byte)0x27 , (byte)0xd5 , (byte)0x17 , (byte)0x10 , (byte)0x94 , (byte)0x7b , (byte)0x7d , (byte)0x8b , (byte)0x2a , (byte)0xaa , (byte)0x66 , (byte)0x77 , (byte)0x3b , (byte)0x37 , (byte)0x01 , (byte)0x41 , (byte)0x57 , (byte)0xc9 , (byte)0x57 , (byte)0x45 , (byte)0x7f , (byte)0x1e , (byte)0x8e , (byte)0x4a , (byte)0x54 , (byte)0xfa , (byte)0x39 , (byte)0xe6 , (byte)0x48 , (byte)0xaf , (byte)0xf2 , (byte)0x6f , (byte)0x84 , (byte)0x0a , (byte)0x7f , (byte)0x18 , (byte)0x85 , (byte)0xfd , (byte)0xa4 , (byte)0xaf , (byte)0xa7 , (byte)0x0a , (byte)0x26 };




    public interface IFunctionNuanceS2T { //this is the interface declaration
        public void handleTextFromSpeech(String text);
    }



    Context context;

    SpeechKit sk;
//    Vocalizer voc;
    Recognizer reco;
//    NuanceVocalizer nuanceVocalizer;

    Handler handlerRecognize;
//    Handler handlerVocalize;

    //expecting the context from getApplication().getApplicationContext()
    NuanceS2T(Context context_arg){//, IFunctionNuanceS2T CallbackFunction){
        context = context_arg;
        //load nuance .so library
        System.loadLibrary("nmsp_speex");

        sk = SpeechKit.initialize(context, appID, serverHost, serverPort, false, SpeechKitApplicationKey );
        // optional
        sk.connect();

        handlerRecognize = new Handler();

        // nuanceResult object gets results and errors; implements an interface
        NuanceResult nuanceResult = new NuanceResult(context, reco);//, CallbackFunction);
        reco = sk.createRecognizer(Recognizer.RecognizerType.Dictation,
                Recognizer.EndOfSpeechDetection.Short,
                "eng-USA", nuanceResult, handlerRecognize);

//        handlerVocalize = new Handler();

//        nuanceVocalizer = new NuanceVocalizer(context);
//        voc = sk.createVocalizerWithLanguage("en_US", nuanceVocalizer, handlerVocalize);

    }

    public String speech2Text()
    {
        String ret = "";
        reco.start();


        return ret;
    }



}
