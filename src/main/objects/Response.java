package objects;

import java.util.*;

public class Response {

    public ArrayList<String> answers;

    public Response(ArrayList<String> answers){
        this.answers = answers;
    }

    public void addAnswer(String answer){
        this.answers.add(answer);
    }
}
