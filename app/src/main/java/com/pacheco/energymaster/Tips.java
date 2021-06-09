package com.pacheco.energymaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Tips extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener  {
    String claveYoutube = "AIzaSyD9tTNHZi8SGWLglXaMTFHCqQJsie2wnFc";
    TextView textconsejos;


    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.videosyoutube);
        youTubePlayerView.initialize(claveYoutube,this);
        textconsejos=findViewById(R.id.tipsmsjtxt);

        textconsejos.setText(R.string.mensajestips);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {
        if (!fueRestaurado){
            youTubePlayer.cueVideo("LyK3F7PLzAg");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String error="ERROR AL INICIAR YOUTUBE"+youTubeInitializationResult.toString();
            Toast.makeText(getApplicationContext(),error, Toast.LENGTH_LONG).show();
        }

    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if (resultcode==1){
            getYouTubePlayerProvide().initialize(claveYoutube,this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvide(){
        return youTubePlayerView;
    }
}