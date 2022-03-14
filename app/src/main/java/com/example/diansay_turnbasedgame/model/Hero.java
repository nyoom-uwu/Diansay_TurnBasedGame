package com.example.diansay_turnbasedgame.model;

public class Hero {
    private String HeroName;
    private int HeroHp = 100;
    private int HeroMp = 20;
    private int HeroMinDamage = 7;
    private int HeroMaxDamage = 12;
    private int HeroCritMinDamage = 14;
    private int HeroCritMaxDamage = 24;
    private byte Herolvl = 1;

    public Hero(){}

    public String getHeroName() {
        return HeroName;
    }
    public void setHeroName(String heroName) {
        HeroName = heroName;
    }
    public int getHeroHp() {
        return HeroHp;
    }
    public void setHeroHp(int heroHp) {
        HeroHp = heroHp;
    }
    public int getHeroMp() {
        return HeroMp;
    }
    public void setHeroMp(int heroMp) {
        HeroMp = heroMp;
    }
    public int getHeroMinDamage() {
        return HeroMinDamage;
    }
    public void setHeroMinDamage(int heroMinDamage) {
        HeroMinDamage = heroMinDamage;
    }
    public int getHeroMaxDamage() {
        return HeroMaxDamage;
    }
    public void setHeroMaxDamage(int heroMaxDamage) {
        HeroMaxDamage = heroMaxDamage;
    }
    public int getHeroCritMinDamage() {
        return HeroCritMinDamage;
    }
    public void setHeroCritMinDamage(int heroCritMinDamage) {
        HeroCritMinDamage = heroCritMinDamage;
    }
    public int getHeroCritMaxDamage() {
        return HeroCritMaxDamage;
    }
    public void setHeroCritMaxDamage(int heroCritMaxDamage){
        HeroCritMaxDamage = heroCritMaxDamage;
    }
    public byte getHerolvl() {
        return Herolvl;
    }
    public void setHerolvl(byte herolvl) {
        Herolvl = herolvl;
    }

    public void resetHero() {
        setHerolvl((byte) 1);
        setHeroHp(100);
        setHeroMp(20);
    }
}
