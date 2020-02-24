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
                    Element elem = (Element) currentTag;
                    if (elem.getAttribute("type").equals("matching")) {
                        //matching q
                        String prompt = elem.getElementsByTagName("prompt").item(0).getTextContent();
                        String answer = elem.getElementsByTagName("answer").item(0).getTextContent();
                        String set1 = elem.getElementsByTagName("set1").item(0).getTextContent();
                        String set2 = elem.getElementsByTagName("set2").item(0).getTextContent();
                        MatchingQuestion mc = new MatchingQuestion(prompt, set1, set2, answer);
                        quiz.addQuestion(mc);
                    } else if (elem.getAttribute("type").equals("fill-in-blank")){
                        //fill in blank q
                        String before = elem.getElementsByTagName("before").item(0).getTextContent();
                        String after = elem.getElementsByTagName("after").item(0).getTextContent();
                        String prompt = before + " BLANK " + after;
                        String answer = elem.getElementsByTagName("answer").item(0).getTextContent();
                        FillInBlankQuestion fib = new FillInBlankQuestion(prompt, answer);
                        quiz.addQuestion(fib);
                    } else if (elem.getAttribute("type").equals("short-answer")){
                        //short answer q
                        String prompt = elem.getElementsByTagName("prompt").item(0).getTextContent();
                        String answer = elem.getElementsByTagName("answer").item(0).getTextContent();
                        ShortAnswerQuestion sa = new ShortAnswerQuestion(prompt, answer);
                        quiz.addQuestion(sa);
                    } else {
                        //mc or tf q
                        String prompt = elem.getElementsByTagName("prompt").item(0).getTextContent();
                        String answer = elem.getElementsByTagName("answer").item(0).getTextContent();
                        ArrayList<String> options = (ArrayList<String>) elem.getElementsByTagName("option");
                        MCQuestion mcq = new MCQuestion(prompt, options, answer);
                        quiz.addQuestion(mcq);
                    }
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
