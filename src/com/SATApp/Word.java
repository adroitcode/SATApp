package com.SATApp;


public class Word {
    private String word;
    private String def;
    private String pron;
    private String def1;
    private String def2;
    private String def3;
    private String def4;
    String[] definitions;
    int amtOfDefinitions;

    public Word(String pWord, String pDef, String pPron){
        this.word = pWord;
        this.def = pDef;
        this.pron = pPron;
        amtOfDefinitions = 4;
        this.definitions = new String[amtOfDefinitions];
    }
    public String getWord(){
        return word;
    }
    public String getDef(){
        return def;
    }
    public void setDef(String passedDef,int index){
        if(index == 1){
            def1 = passedDef;
        }
        else if(index == 2){
            def2 = passedDef;
        }
        else if(index == 3){
            def3 = passedDef;
        }
        else if(index == 4){
            def4 = passedDef;
        }
    }

    public String getDef(int index){
        String thisDef = "";
        if(index == 1){
            thisDef = def1;
        }
        else if(index == 2){
            thisDef = def2;
        }
        else if(index == 3){
            thisDef = def3;
        }
        else if(index == 4){
            thisDef = def4;
        }
        return thisDef;
    }
    public String getPron(){
        return pron;
    }
}
