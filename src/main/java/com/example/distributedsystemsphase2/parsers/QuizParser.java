package com.example.distributedsystemsphase2.parsers;

import com.example.distributedsystemsphase2.objects.*;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class QuizParser {

    //Author: Trey Roche
    //built with the help of tutorialspoint https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm

    public Quiz parse(String url){
        ArrayList<Question> questions = new ArrayList<Question>();
        String title = "";
        String directions = "";
        Quiz quiz = new Quiz(title, directions, questions);
        try {
            File inputFile = new File(url);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList root = doc.getElementsByTagName("response");
            for (int i = 0; i < root.getLength(); i++) {
                Node currentTag = root.item(i);
                if (currentTag.getNodeName().equals("title")) {
                    quiz.addTitle(currentTag.getTextContent());
                } else if (currentTag.getNodeName().equals("directions")) {
                    quiz.addDirections(currentTag.getTextContent());
                } else if (currentTag.getNodeName().equals("question")){
                    //TODO: add each question
                }
            }
            return quiz;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return quiz;
    }
}
