package com.example.diansay_turnbasedgame.controller;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diansay_turnbasedgame.model.Hero;
import com.example.diansay_turnbasedgame.model.Monster;

import java.util.Random;

public class combatSystem {
    Hero me;
    Monster you;
    int turnCount = 1;
    int dmg, prvdmg;
    Random random = new Random();
    public combatSystem(Hero hero, Monster mons){
        me = hero;
        you = mons;
    }
    public void nextTurn(TextView hero_hp, TextView hero_mana, TextView mons_hp, TextView mons_mana, TextView dialogue, ImageView skill_button, TextView name){
        if(turnCount == -2){
            dialogue.setText("You win the game. Play again?");
            updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
            turnCount =-1;
        }
        else if (turnCount == -1){
            dialogue.setText("You awaken once again in the same space station");
            me.resetHero();
            you.resetMonster();
            updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
            turnCount =1;
        }
        else if (turnCount == 0){ //reset game
            you.levelUpMonster();
            me.setHeroMp(me.getHeroMp()+20);
            me.setHeroHp(me.getHeroHp()+75);
            dialogue.setText("A new rival has approached!");
            updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
            turnCount++;
        }
        else if (turnCount % 2 == 1){ // odd if hero turn
            prvdmg = random.nextInt(me.getHeroMaxDamage()-me.getHeroMinDamage()) + me.getHeroMinDamage();
            dmg = prvdmg;
            you.setMonsterHp(you.getMonsterHp()-dmg);
            dialogue.setText("The Main Character dealt "+ String.valueOf(dmg)+" to the enemy");
            Log.d(TAG, "nextTurn: hero");
            turnCount++;
            disableSS(skill_button);
            me.setHeroMp(me.getHeroMp()+1);
            if(you.getMonsterHp()<=0){
                you.setMonsterHp(0);
                updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
                dialogue.setText("You defeated today's rival");
                if (you.getMonsterlvl()==(byte)9){
                    turnCount = -2;
                }else {
                    turnCount = 0;
                }
            }
        }
        else if (turnCount % 2 == 0){ // even if enemy turn
            prvdmg = random.nextInt(you.getMonsterMaxDamage()-you.getMonsterMinDamage()) + you.getMonsterMinDamage();
            dmg = prvdmg;
            me.setHeroHp(me.getHeroHp()-dmg);
            dialogue.setText("The rival dealt "+ String.valueOf(dmg)+" to the hero");
            Log.d(TAG, "nextTurn: mons");
            turnCount++;
            enableSS(skill_button);
            if (me.getHeroHp()<=0){
                me.setHeroHp(0);
                updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
                dialogue.setText("You lose... Restart?");
                turnCount=-1;
            }
        }
        updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
    }
    public void skill_button(TextView hero_hp, TextView hero_mana, TextView mons_hp, TextView mons_mana, TextView dialogue, ImageView skill_button, TextView name){
        if (me.getHeroMp()<3){
            dialogue.setText("You don't have enough mana!");
            disableSS(skill_button);
        }else {
            prvdmg = random.nextInt(me.getHeroCritMaxDamage()-me.getHeroCritMinDamage()) + me.getHeroCritMinDamage();
            dmg = prvdmg;
            you.setMonsterHp(you.getMonsterHp()-dmg);
            dialogue.setText("The Main Character dealt "+ String.valueOf(dmg)+" to the enemy");
            disableSS(skill_button);
            turnCount++;
            me.setHeroMp(me.getHeroMp()-3);
            updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
            if(you.getMonsterHp()<=0){
                you.setMonsterHp(0);
                updateUI(hero_hp, hero_mana, mons_hp, mons_mana, name);
                dialogue.setText("You defeated today's rival");
                turnCount=0;
            }
        }
    }
    public void disableSS(ImageView skill_button){
        skill_button.setVisibility(View.INVISIBLE);
    }
    public void enableSS(ImageView skill_button){
        skill_button.setVisibility(View.VISIBLE);
    }
    public void updateUI(TextView hero_hp, TextView hero_mana, TextView mons_hp, TextView mons_mana,TextView name){
    hero_hp.setText(String.valueOf(me.getHeroHp()));
    hero_mana.setText(String.valueOf(me.getHeroMp()));
    mons_hp.setText(String.valueOf(you.getMonsterHp()));
    mons_mana.setText(String.valueOf(you.getMonsterMp()));
    name.setText(you.getMonsterName());
    }

    public int getTurnCount() {
        return turnCount;
    }
    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }
}
