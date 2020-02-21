package com.example.distributedsystemsphase2.parsers;

import com.example.distributedsystemsphase2.objects.*;
import java.util.ArrayList;

public class QuizParser {

    public Quiz parse(String url){
        String title = "Hi";
        String directions = "Testing";
        String prompt = "True or False";
        String answer = "False";
        ArrayList<String> options = new ArrayList<String>();
        options.add(new String("true"));
        options.add(new String("false"));
        ArrayList<Question> questions = new ArrayList<Question>();
        MCQuestion mc = new MCQuestion(prompt, options, answer);
        questions.add(mc);
        return new Quiz(title, directions, questions);
    }
}
