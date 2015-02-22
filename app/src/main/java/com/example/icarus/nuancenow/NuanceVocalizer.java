package com.example.icarus.nuancenow;

import android.content.Context;
import android.widget.Toast;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;

/**
 * Created by Alex on 21/02/2015.
 */
public class NuanceVocalizer implements Vocalizer.Listener {
    Context context;

    NuanceVocalizer(Context context_arg){
        context = context_arg;
    }

    @Override
    public void onSpeakingBegin(Vocalizer vocalizer, String s, Object o) {
        Toast.makeText(context, "NuanceVocalizer.onSpeakingBeing",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speechError, Object o) {

        Toast.makeText(context, speechError.getErrorDetail(), Toast.LENGTH_LONG).show();
    }
}
