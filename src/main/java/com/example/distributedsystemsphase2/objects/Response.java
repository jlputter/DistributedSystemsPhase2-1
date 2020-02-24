package com.example.distributedsystemsphase2.objects;

import java.util.*;

public class Response {

    //Author: Trey Roche

    public ArrayList<String> answers;
    public String name;

    public Response(ArrayList<String> answers, String name){
        this.name = name;
        this.answers = answers;
    }

    public void addAnswer(String answer){
        this.answers.add(answer);
    }

    public void addName(String name) { this.name = name; }
}
