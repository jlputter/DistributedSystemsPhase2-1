package com.example.distributedsystemsphase2.objects;

public class MatchingQuestion implements Question{

    //Author: Trey Roche

    String prompt;
    String set1;
    String set2;
    String answer;

    public MatchingQuestion(String prompt, String set1, String set2, String answer){
        this.prompt = prompt;
        this.set1 = set1;
        this.set2 = set2;
        this.answer = answer;
    }

    public void addPrompt(String prompt) { this.prompt = prompt; }

    public void addSet1(String set1){
        this.set1 = set1;
    }

    public void addSet2(String set2){
        this.set2 = set2;
    }

    public void addAnswer(String answer){
        this.answer = answer;
    }
}
