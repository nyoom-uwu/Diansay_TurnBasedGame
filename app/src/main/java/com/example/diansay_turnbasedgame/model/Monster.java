package com.example.diansay_turnbasedgame.model;

import static android.content.ContentValues.TAG;

import android.util.Log;

public class Monster {
    private int MonsterHp = 200;
    private int MonsterMp = 10;
    private int MonsterMinDamage = 3;
    private int MonsterMaxDamage = 10;
    private byte Monsterlvl = 0;
    private String[] MonsNamebyLvl = new String[]{"Sindel 1","Zyra  2","Dianne 3","Anj 4","Chek  5","Lica  6","Karrel  7","Kofi  8","Nyoom 9","Chari 10"};
    private String MonsterName =MonsNamebyLvl[0];

    public Monster(){}
    public Monster(String monsname){
        setMonsterName(monsname);
    }

    public String getMonsterName() {
        return MonsterName;
    }
    public void setMonsterName(String monsterName) {
        MonsterName = monsterName;
    }
    public int getMonsterHp() {
        return MonsterHp;
    }
    public void setMonsterHp(int monsterHp) {
        MonsterHp = monsterHp;
    }
    public int getMonsterMp() {
        return MonsterMp;
    }
    public void setMonsterMp(int monsterMp) {
        MonsterMp = monsterMp;
    }
    public int getMonsterMinDamage() {
        return MonsterMinDamage;
    }
    public int getMonsterMaxDamage() {
        return MonsterMaxDamage;
    }
    public byte getMonsterlvl() {
        return Monsterlvl;
    }
    public void setMonsterlvl(byte monsterlvl) {
        Monsterlvl = monsterlvl;
    }

    public void resetMonster(){
        setMonsterName(MonsNamebyLvl[0]);
        setMonsterHp(200);
        setMonsterMp(10);
        setMonsterlvl((byte) 0);
    }
    public void levelUpMonster(){
        setMonsterlvl((byte) (getMonsterlvl()+1));
        setMonsterName(MonsNamebyLvl[getMonsterlvl()]);
        Log.d(TAG, "levelUpMonster: "+getMonsterName());
        setMonsterHp(200);
        setMonsterMp(10);
    }
}
