package com.example.studySpringboot0002.temp.controller.position;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

//mission : 서버 1과 서버 2를 직접 만들기
//서버 2에서 URL로 id과 pw를 전달하여 서버 1에서 DB에 있는 id/pw가 정확한지(login) true/false를 서버 2으로 return 하시오
//서버 2에서 URL로 id과 pw를 전달하여 서버 1에서 id가 kim이면 "true"값 아니면 "false"를 문자열을 전달하는 HashMap의 body를 만드시오

//@Controller : HTML로 연결
@Controller
public class positionController {

    @GetMapping("position/input")
    public String input_get() {
        return "position/input";
    }

    @PostMapping("position/input")
    public String input(
            @RequestParam("id")String id,
            @RequestParam("pw")String pw,
            Model model) {

        String returnLine = "";
        try {
            //?KEY=VALUE 값을 넣어서 Server1에 @RequestParam으로 데이터 전달 (=클라이언트가 form으로 KEY/VALUE전달)
            //?이후에 파라미터 KEY=VALUE를 넣는다, & : 다른 파라미터 라는 표시
            URL url = new URL("http://192.168.42.100:8090/data/randomPosition?id="+id+"&pw="+pw); //URL로 데이터 호출
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream()); //byte[] 데이터 받아와서
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream)); //문자열 데이터 변환

            returnLine = bufferedReader.readLine();
        }catch (Exception e) {

        }
        System.out.println(returnLine);

        JSONObject jsonObject = new JSONObject(returnLine); //"result"="true"
//        JSONObject body = jsonObject.getJSONObject("body");
        String resultData = jsonObject.getString("result");

//        model.addAttribute("name", name);
        model.addAttribute("resultData", resultData);

        return "position/position";
    }

    @GetMapping("result/position")
    public String position(Model model) {

        //메모리 주소 변경없이 데이터 변화
        StringBuffer result = new StringBuffer();

        String returnLine = "";

        //try {} 코드에서 에러가 나면 catch 로 빠져나감 : 네트워크 연결의 불안성 때문에 자바에서 try/catch 강제함
        try {
            URL url = new URL("http://192.168.42.100:8090/data/randomPosition"); // URL 주소로 연결하는 객체
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // Http 프로토콜로 연결
            httpURLConnection.connect(); //url주소로 연결 (서로 소통 됨)

            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()); //바아트 배열로 데이터 받아옴
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream)); //조각난 바이트 배열 합치기

            //영어권 네트워크, 컴퓨터 = 2진수 <> 문자열 (영어) << 한글/아랍어/중국어..
            returnLine = bufferedReader.readLine();

        }catch (Exception e) {

        }

        //JSONObject : String문자열을 KEY/VALUE 형식의 타입으로 변환 (json=map)
        JSONObject jsonObject = new JSONObject(returnLine);
        //KEY가 header인 value의 속성은 String이므로 String 타입 변수에 VALUE를 받아옴
        //header의 value가 String
        String title = jsonObject.getString("header");
        //body key값은 MAP이므로 동일한 JSON 타입으로 변수 선언
        JSONObject body = jsonObject.getJSONObject("body");

        System.out.println(title);
        System.out.println(body);

        model.addAttribute("body", body);

        return "position/position";
    }
}