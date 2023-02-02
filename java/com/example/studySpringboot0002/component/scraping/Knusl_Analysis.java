//package com.example.studySpringboot0002.component.scraping;
//
//import com.example.studySpringboot0002.entity.project3.Project3Entity;
//import com.example.studySpringboot0002.service.project3.Project3Service;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//@Service
//public class Knusl_Analysis {
//
//    private static Project3Service project3Service;
//    private Project3_kakaomap_scraping project3_kakaomap_scraping;
//
//    @Autowired
//    public Knusl_Analysis(Project3Service project3Service, Project3_kakaomap_scraping project3_kakaomap_scraping) {
//        this.project3Service = project3Service;
//        this.project3_kakaomap_scraping = project3_kakaomap_scraping;
//    }
//
////    public static void main(String[] args) {
////        knusl();
////    }
//
//    public static ArrayList<Integer> knusl() {
//
////        JSONObject jsonObject1 = new JSONObject(); // 중괄호에 들어갈 속성 정의 { "a" : "1", "b" : "2" }
////        JSONArray jsonArray1 = new JSONArray(); // 대괄호 정의 [{ "a" : "1", "b" : "2" }]
////        JSONObject finalJsonObject1 = new JSONObject(); // 중괄호로 감싸 대괄호의 이름을 정의함 { "c" : [{  "a" : "1", "b" : "2" }] }
//
//        //        word ,word_root,polarity
//        //        print("-2:매우 부정, -1:부정, 0:중립 or Unkwon, 1:긍정, 2:매우 긍정")
//
//
//        ArrayList<Integer> KnuslArrayList = null;
//        try {
//            JSONParser parser = new JSONParser();
//            FileReader reader = new FileReader("D:/KIMJIHYEOK/project3_java/SentiWord_info.json");
//            Object jsonObject = parser.parse(reader);
////            JSONArray array = new JSONArray();
////            array.add(jsonObject);
//
////            System.out.println(array.get(0));
////            String word = (String) jsonObject.get("word");
////            System.out.println(word);
////            Object jsonObject2 =(Object) jsonObject;
//            JSONArray jsonArray = (JSONArray) jsonObject;
////            System.out.println();
////            String so = jsonArray.get(1).toString().strip().split(",")[1];
////            System.out.println(so);
//
//            reader.close();
//
//            ArrayList<HashMap<String, String>> parsedMap = (ArrayList<HashMap<String, String>>) jsonObject;
//            List<Project3Entity> result_data = project3Service.FindAllProject3db();
//            int AnalysisScoreTotal = 0;
//            //            System.out.println("jsonObjects > " + jsonObject);
//            for (Project3Entity result_data1 : result_data) {
//                String ViewMoreReviewDetail = result_data1.getViewMoreReviewDetail().strip();
//                String title = result_data1.getTitle();
//                for (HashMap<String, String> item : parsedMap) {
//                    //긍정적인 단어가 있을수록 + =-
//                    if (item.get("word").equals(ViewMoreReviewDetail)) {
//                        System.out.println("word가 같음");
//                        int AnalysisScore = Integer.parseInt(item.get("polarity"));
//                        System.out.println("점수는 " + AnalysisScore);
//                        AnalysisScoreTotal +=AnalysisScore;
//                    }
//                    //평점
//                    if (result_data1.getNumberScore() > 4) {
//                        AnalysisScoreTotal+=1;
//                    }
//                    //리뷰수
//                    if(result_data1.getNumberOfReview()>20){
//                        AnalysisScoreTotal+=1;
//                    }
//                    System.out.println("------------------------");
//                    System.out.println("음식점명 :" +title +"총 점수 :"+AnalysisScoreTotal);
//                    System.out.println("------------------------");
//                    KnuslArrayList = new ArrayList<>();
//                    KnuslArrayList.add((AnalysisScoreTotal));
//                }
//            }
////            HashMap<String, String> map = new HashMap<>();
//
////            map.put("1번키", "사과"); //값 추가
////            map.put("2번키", "바나나");
////            map.put("3번키", "포도");
////            map.put("4번키", "포도");
////            for (parsedMap.Entry<String, String> item : map.entrySet()) {
////                if (item.getValue().equals("포도")) {
////                    System.out.println("포도의 키 값은 " + item.getKey());
////                }
////                if (item.getKey().equals("1번키")) {
////                    System.out.println("1번키 값은 " + item.getValue());
////                }
////            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
////        List<Project3Entity> result_data = project3Service.FindAllProject3db();
////
////        for (Project3Entity item : result_data) {
////
////            System.out.println(item.getTitle());
////            System.out.println(item.getNumberScore());
////            System.out.println(item.getNumberScoreList());
////            System.out.println(item.getNumberOfReview());
////            System.out.println(item.getViewMoreReviewDetail());
////        }
//        return KnuslArrayList;
//    }
//}
