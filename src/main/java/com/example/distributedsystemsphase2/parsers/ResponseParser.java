package com.example.distributedsystemsphase2.parsers;

import com.example.distributedsystemsphase2.objects.*;
import java.util.ArrayList;

public class ResponseParser {

    public Response parse(String url){
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("false");
        return new Response(answers);
    }
}
