package com.example.diansay_turnbasedgame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diansay_turnbasedgame.R;
import com.example.diansay_turnbasedgame.controller.combatSystem;
import com.example.diansay_turnbasedgame.model.Hero;
import com.example.diansay_turnbasedgame.model.Monster;

public class MainActivity extends AppCompatActivity {
    Hero mc;
    Monster rival;
    combatSystem test;
    ImageView skillButton, nextturnbutton;
    TextView mchealth,mcmana, rivalhealth, rivalmana, dialogue, rivalname;
    MediaPlayer bgm, sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mc = new Hero();
        rival = new Monster();
        test = new combatSystem(mc,rival);
        bgm = new MediaPlayer();

        mchealth = findViewById(R.id.hero_hp_value);
        mcmana = findViewById(R.id.hero_mp_value);
        rivalhealth = findViewById(R.id.mons_hp_value);
        rivalmana = findViewById(R.id.mons_mp_value);
        dialogue = findViewById(R.id.dialogue_text);
        rivalname = findViewById(R.id.mons_name);
        sfx = MediaPlayer.create(this,R.raw.sfx);
        bgm = MediaPlayer.create(this,R.raw.bgm);
        bgm.setLooping(true);
        bgm.setVolume(25,25);
        bgm.start();

        nextturnbutton = findViewById(R.id.Nextbutton);
        nextturnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.nextTurn(mchealth,mcmana,rivalhealth, rivalmana, dialogue, skillButton, rivalname);
            }});
        skillButton = findViewById(R.id.skill_button);
        skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test.skill_button(mchealth,mcmana, rivalhealth, rivalmana, dialogue, skillButton, rivalname);
                sfx.start();
            }});
        test.updateUI(mchealth,mcmana,rivalhealth,rivalmana, rivalname);
        enableFullscreen();
    }
    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }
    }
}