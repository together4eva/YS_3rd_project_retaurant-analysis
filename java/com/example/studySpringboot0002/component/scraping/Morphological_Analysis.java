package com.example.studySpringboot0002.component.scraping;

import com.example.studySpringboot0002.dto.Project3Dto;
import com.example.studySpringboot0002.entity.project3.Project3Entity;
import com.example.studySpringboot0002.service.project3.Project3Service;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class Morphological_Analysis {

    private static Project3Service project3Service;
    private Project3_kakaomap_scraping project3_kakaomap_scraping;

    @Autowired
    public Morphological_Analysis(Project3Service project3Service, Project3_kakaomap_scraping project3_kakaomap_scraping) {
        this.project3Service = project3Service;
        this.project3_kakaomap_scraping = project3_kakaomap_scraping;
    }

//    public static void main(String[] args) {
//        Analysis();
//    }


    public static ArrayList<Integer> Analysis() {

//        JSONObject jsonObject1 = new JSONObject(); // 중괄호에 들어갈 속성 정의 { "a" : "1", "b" : "2" }
//        JSONArray jsonArray1 = new JSONArray(); // 대괄호 정의 [{ "a" : "1", "b" : "2" }]
//        JSONObject finalJsonObject1 = new JSONObject(); // 중괄호로 감싸 대괄호의 이름을 정의함 { "c" : [{  "a" : "1", "b" : "2" }] }

        //        word ,word_root,polarity
        //        print("-2:매우 부정, -1:부정, 0:중립 or Unkwon, 1:긍정, 2:매우 긍정")

        //json 파일 위치
        String dir ="D:/KIMJIHYEOK/project3_java/SentiWord_info.json";

        ArrayList<Integer> AnalysisArrayList = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(dir);
            Object jsonObject = parser.parse(reader);
//            JSONArray array = new JSONArray();
//            array.add(jsonObject);

//            System.out.println(array.get(0));
//            String word = (String) jsonObject.get("word");
//            System.out.println(word);
//            Object jsonObject2 =(Object) jsonObject;
            JSONArray jsonArray = (JSONArray) jsonObject;
//            System.out.println();
//            String so = jsonArray.get(1).toString().strip().split(",")[1];
//            System.out.println(so);

            reader.close();

            ArrayList<HashMap<String, String>> parsedMap = (ArrayList<HashMap<String, String>>) jsonObject;

            //Entity의 값 조회 해서 불러오기
            List<Project3Entity> result_data = project3Service.FindAllProject3db();
            int AnalysisScoreTotal = 0;



            for (Project3Entity result_data1 : result_data) {
                String ViewMoreReviewDetail = result_data1.getViewMoreReviewDetail().strip();
                String title = result_data1.getTitle();
                for (HashMap<String, String> item : parsedMap) {

                   //리뷰 더보기 내용을 가져와서 공백으로 나누고 다시 list에 저장
                    String[] ArrayStr=ViewMoreReviewDetail.split(" ");
                    for(String str : ArrayStr) {
                        System.out.println(str);

                        //리뷰 더보기 내용과 같다면
                        if (item.get("word").equals(str)) {
                            //map을 array로 변환
                            Object[] keys = item.keySet().toArray();
                            //word_root  값
                            String r_word=item.get(keys[0]);
                            //porality 값
                            String s_word=item.get(keys[2]);
                            System.out.println("-------------------------");
                            System.out.println(r_word);
                            System.out.println(s_word);
                            System.out.println("----------------------------------------");
                            System.out.println("word가 같음");
                            System.out.println("----------------------------------------");

                            int AnalysisScore = Integer.parseInt(s_word);
                            if(s_word==null || s_word=="Unkwon"){
                                AnalysisScore=0;
                            }
                            System.out.println("----------------------------------------");
                            System.out.println("word 점수는 :" + AnalysisScore);
                            System.out.println("----------------------------------------");
                            AnalysisScoreTotal +=AnalysisScore;

                            System.out.println("------------------------");
                            System.out.println("음식점명 :" +title);
                            System.out.println("word 총 점수 :"+AnalysisScoreTotal);
                            System.out.println("------------------------");
                        }
                    }
                }
                //평점 가중치
                if (result_data1.getNumberScore() > 5) {
                    AnalysisScoreTotal+=4;
                }else if(result_data1.getNumberScore() > 4.5){
                    AnalysisScoreTotal+=3;
                }else if (result_data1.getNumberScore() > 4){
                    AnalysisScoreTotal+=2;
                }else if (result_data1.getNumberScore() > 3.5){
                    AnalysisScoreTotal+=1;
                }

                //리뷰수
                if(result_data1.getNumberOfReview()>20){
                    AnalysisScoreTotal+=2;
                }

                AnalysisArrayList.add((AnalysisScoreTotal));
                AnalysisScoreTotal=0;

            }
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println(AnalysisScoreTotal);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return AnalysisArrayList;
    }
    //제목
    public static ArrayList<String> AnalysisTitle(){
        ArrayList<String>AnalysisTitleList = new ArrayList<>();
        List<Project3Entity> result_data = project3Service.FindAllProject3db();
        for (Project3Entity result_data1 : result_data) {
            result_data1.getTitle();
            AnalysisTitleList.add(result_data1.getTitle());
        }
//        ArrayList<Integer> AnalysisGraphList1 = Analysis();
//        for(Integer result_data2  :AnalysisGraphList1){
//            AnalysisGraphList.add(String.valueOf(result_data2));
//        }
        return AnalysisTitleList;
    }
    //평점
    public static ArrayList<Double> AnalysisNumberScore(){
        ArrayList<Double>AnalysisNumberScoreList = new ArrayList<>();
        List<Project3Entity> result_data = project3Service.FindAllProject3db();
        for (Project3Entity result_data1 : result_data) {
            result_data1.getNumberScore();
            AnalysisNumberScoreList.add(result_data1.getNumberScore());
        }
//        ArrayList<Integer> AnalysisGraphList1 = Analysis();
//        for(Integer result_data2  :AnalysisGraphList1){
//            AnalysisGraphList.add(String.valueOf(result_data2));
//        }
        return AnalysisNumberScoreList;
    }
    //리뷰수 분석+project3 entity
    public static ArrayList<Project3Dto> AnalysisProject3(){
        ArrayList<String>AnalysisProject3List = new ArrayList<>();
        List<Project3Entity> result_data = project3Service.FindAllProject3db();
        ArrayList<Integer> result_data_index_ver = Analysis();
        ArrayList<Project3Dto> result_calc = new ArrayList<>();
        for(int i = 0; i<result_data.size(); i++) {
            Project3Dto new_dto = new Project3Dto(
                    result_data.get(i).getId(),
                    result_data.get(i).getNumber(),
                    result_data.get(i).getTitle(),
                    result_data.get(i).getNumberScore(),
                    result_data.get(i).getNumberScoreList(),
                    result_data.get(i).getNumberOfReview(),
                    result_data_index_ver.get(i)
                    );
            result_calc.add(new_dto);
        }

        return result_calc;
    }
    //리뷰수
    public static ArrayList<Integer> AnalysisNumberOfReview(){
        ArrayList<Integer>AnalysisNumberOfReviewList = new ArrayList<>();
        List<Project3Entity> result_data = project3Service.FindAllProject3db();
        for (Project3Entity result_data1 : result_data) {
            result_data1.getNumberOfReview();
            AnalysisNumberOfReviewList.add(result_data1.getNumberOfReview());
        }
//        ArrayList<Integer> AnalysisGraphList1 = Analysis();
//        for(Integer result_data2  :AnalysisGraphList1){
//            AnalysisGraphList.add(String.valueOf(result_data2));
//        }
        return AnalysisNumberOfReviewList;
    }

    //후기 수
    public static ArrayList<Integer> AnalysisnumberOfScoreList(){
        ArrayList<Integer>numberOfScoreListList = new ArrayList<>();
        List<Project3Entity> result_data = project3Service.FindAllProject3db();
        for (Project3Entity result_data1 : result_data) {
            result_data1.getNumberScoreList();
            numberOfScoreListList.add(result_data1.getNumberScoreList());
        }
//        ArrayList<Integer> AnalysisGraphList1 = Analysis();
//        for(Integer result_data2  :AnalysisGraphList1){
//            AnalysisGraphList.add(String.valueOf(result_data2));
//        }
        return numberOfScoreListList;
    }
}
