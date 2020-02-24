package com.example.distributedsystemsphase2.parsers;

import com.example.distributedsystemsphase2.objects.*;

import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ResponseParser {

    //Author: Trey Roche
    //built with the help of tutorialspoint https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm

    public Response parse(String url){
        ArrayList<String> answers = new ArrayList<String>();
        String name = "";
        Response response = new Response(answers, name);
        try {
            File inputFile = new File(url);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList root = doc.getElementsByTagName("response");
            for (int i = 0; i < root.getLength(); i++) {
                Node currentTag = root.item(i);
                if (currentTag.getNodeName().equals("name")) {
                    response.addName(currentTag.getTextContent());
                } else if (currentTag.getNodeName().equals("answer")) {
                    response.addAnswer(currentTag.getTextContent());
                }
            }
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
