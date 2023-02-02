package com.example.studySpringboot0002.component.scraping;
import com.example.studySpringboot0002.entity.project3.Project3Entity;
import com.example.studySpringboot0002.service.project3.Project3Service;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class komoran_test {
    private static Project3Service project3Service;
    private Project3_kakaomap_scraping project3_kakaomap_scraping;

    @Autowired
    public komoran_test(Project3Service project3Service, Project3_kakaomap_scraping project3_kakaomap_scraping) {
        this.project3Service = project3Service;
        this.project3_kakaomap_scraping = project3_kakaomap_scraping;
    }

    //        public static void main(String[] args) {
//
//        }
    public static void komoran() {

        List<Project3Entity> result_data = project3Service.FindAllProject3db();

        for (Project3Entity item : result_data) {
            System.out.println(item.getTitle());

            Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

            String strToAnalyze = item.getTitle();

            KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

            System.out.println(analyzeResultList.getPlainText());
            //구조 출력
            List<Token> tokenList = analyzeResultList.getTokenList();
            for (Token token : tokenList) {
                System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
                System.out.println("-----------------------");
                System.out.println(token);
            }
            //단어만 출력
            List<String> nounList = analyzeResultList.getNouns();
            for (
                    String noun : nounList) {
                System.out.println(noun);
            }

        }
        String returnLine = "";
        try {
            //?KEY=VALUE 값을 넣어서 Server1에 @RequestParam으로 데이터 전달 (=클라이언트가 form으로 KEY/VALUE전달)
            //?이후에 파라미터 KEY=VALUE를 넣는다, & : 다른 파라미터 라는 표시
            String point_10 = null;
            URL url = new URL("http://192.168.42.100:80/request?point="+point_10); //URL로 데이터 호출
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream()); //byte[] 데이터 받아와서
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream)); //문자열 데이터 변환

            returnLine = bufferedReader.readLine();
        }catch (Exception e) {
        }
        System.out.println("---------------------------return");
        System.out.println(returnLine);
    }
}
//결과
//대한민국/NNP 은/JX 민주공화국/NNP 이/VCP 다/EF ./SF
//        ( 0,  4) 대한민국/NNP
//        ( 4,  5) 은/JX
//        ( 6, 11) 민주공화국/NNP
//        (11, 12) 이/VCP
//        (12, 13) 다/EF
//        (13, 14) ./SF

