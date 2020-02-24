package com.example.distributedsystemsphase2.objects;
import java.util.*;

public class Quiz {

    //Author: Trey Roche

    public String title;
    public String directions;
    public ArrayList<Question> questions;

    public Quiz(String title, String directions, ArrayList<Question> questions){
        this.title = title;
        this.directions = directions;
        this.questions = questions;
    }

    public void addTitle(String title){
        this.title = title;
    }

    public void addDirections(String directions){
        this.directions = directions;
        return;
    }

    public void addQuestions(ArrayList<Question> questions){
        for(Question q:questions){
            this.questions.add(q);
        }
    }

    public void addQuestion(Question q){
        this.questions.add(q);
    }

}
