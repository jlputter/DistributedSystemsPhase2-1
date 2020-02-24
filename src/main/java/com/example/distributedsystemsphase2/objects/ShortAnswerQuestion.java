package com.example.distributedsystemsphase2.objects;

public class ShortAnswerQuestion implements Question {

    //Author: Trey Roche

    String prompt;
    String answer;

    public ShortAnswerQuestion(String prompt, String answer){
        this.prompt = prompt;
        this.answer = answer;
    }

    public void addAnswer(String answer){
        this.answer = answer;
    }

    public void addPrompt(String prompt){
        this.prompt = prompt;
    }
}
