package com.example.studySpringboot0002.component.scraping;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class testesteeeeeeeee {

    public static void main(String[] args) {
        ArrayList<Integer> soso =new ArrayList<>();

        int total=0;

        for(int i=0; i<10; i++){
            for(int z=0; z<10; z++){
                total=+1;
                System.out.println(total);


            }
            soso.add(total);
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println(soso);
        System.out.println(soso.size());
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        String ss = "안녕하세오 오요오 로로";
        String[] dd=ss.split(" ");
        for(String s : dd){
            System.out.println(s);
        }


        try{

        FileReader reader = new FileReader("D:/KIMJIHYEOK/project3_java/SentiWord_info.json");
        JSONParser parser = new JSONParser();
        Object jsonObject = parser.parse(reader);

        ArrayList<HashMap<String, String>> parsedMap = (ArrayList<HashMap<String, String>>) jsonObject;
        String str ="쾌적";
        String str2 ="알쏭하다";
        String str3 ="쾌적 알쏭하다 이구만요";
            int total22 = 0;
        String[] strArray= str3.split(" ");
        for(HashMap<String, String> item : parsedMap) {
            for(String asd : strArray){
                if(item.get("word").equals(asd)){
                    Object[] keys = item.keySet().toArray();
                    String r_word=item.get(keys[0]);
                    String s_word=item.get(keys[2]);
                    System.out.println("-------------------------");
                    System.out.println(r_word);
                    System.out.println(s_word);
                    total22 +=Integer.parseInt(s_word);
                }
            }
        }
            System.out.println(total22);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
