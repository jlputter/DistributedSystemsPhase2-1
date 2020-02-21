package com.example.distributedsystemsphase2.objects;
import java.util.*;

public class MCQuestion implements Question {

    String prompt;
    ArrayList<String> options;
    String answer;

    public MCQuestion(String prompt, ArrayList<String> options, String answer){
        this.prompt = prompt;
        this.options = options;
        this.answer = answer;
    }

    public void addPrompt(String prompt){
        this.prompt = prompt;
    }

    public void addOptions(ArrayList<String> options){
        for(String o:options){
            this.options.add(o);
        }
    }

    public void addAnswer(String answer){
        this.answer = answer;
        if (!this.options.contains(answer)){
            this.options.add(answer);
        }
    }
}
