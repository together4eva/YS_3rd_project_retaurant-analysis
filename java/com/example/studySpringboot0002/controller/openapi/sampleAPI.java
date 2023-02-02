package com.example.studySpringboot0002.controller.openapi;

import com.example.studySpringboot0002.entity.openapi.Covid19noti;
import com.example.studySpringboot0002.repository.openapi.Covid19notiRepository;
import com.example.studySpringboot0002.service.openapi.DatagokrService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * openapi : data.go.kr / kakao develop site의 api를 관리하는 controller
 */
@Controller
public class sampleAPI {

    /**
     * Repository 연결
     */
    private final Covid19notiRepository covid19notiRepository;
    private final DatagokrService datagokrService;



    private static Long count = 0L;

    @Autowired
    public sampleAPI(Covid19notiRepository covid19notiRepository,
                     DatagokrService datagokrService
    ) {
        this.covid19notiRepository = covid19notiRepository;
        this.datagokrService = datagokrService;
    }

    @GetMapping("read/Covid19noti")
    public String read_covid19noti(Model model) {
        model.addAttribute("result", datagokrService.getCovid19noti());
        return "resultDB/covid19noti";
    }



    /**
     * api 테스트를 위한 메서드로 코로나 공지사항 데이터를 받는 api 작업 완료@@@
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("sampleAPI")
    public Object sampleAPI(Model model) throws Exception {
        // 1. URL을 만들기 위한 StringBuilder : 메모리 주소가 1개인 String 변수
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew"); /*URL*/
        // 2. 오픈 API의 요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
        // append() : urlBuilder 변수에 연결된 heap메모리 주소에 String문자열을 지속적으로 추가하는 메서드
        //URLEncoder.encode() : UTF-8 인코딩 형식으로 문자열을 저장
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Io8hL7HgmY2rteFGVOkVQhoA2YFq27cZN3HFt8GS3WqAB1yGjhq3puzw%2FldMoe8YRmmQrDbU5KA4a1vLpaYhjw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("일본", "UTF-8")); /*한글 국가명*/
        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode("JP", "UTF-8")); /*ISO 2자리코드*/
        String codetest = "http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew?serviceKey=Io8hL7HgmY2rteFGVOkVQhoA2YFq27cZN3HFt8GS3WqAB1yGjhq3puzw%2FldMoe8YRmmQrDbU5KA4a1vLpaYhjw%3D%3D&stdt=20";
        System.out.println(urlBuilder);
        // 3. URL 객체 생성.
        URL url = new URL(urlBuilder.toString());
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET : HttpURLConnection 타입에 setRequestMethod() 메서드를 사용하여 POST, GET방식 선택 가능
        conn.setRequestMethod("GET");
        // 6. 통신을 위한 Content-type SET. : HTTP 메타데이터로 포맷 형식이 json방식이다 라고 선언
        conn.setRequestProperty("Content-type", "application/json");
        // 7. 통신 응답 코드 확인.
        System.out.println("Response code: " + conn.getResponseCode());
        // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 10. 객체 해제.
        rd.close();
        conn.disconnect();
        // 11. 전달받은 데이터 확인.
        System.out.println(sb.toString());
        model.addAttribute("result", sb.toString());


//        //(0)JSON 데이터 만들기 (임의) (JSON API 정상적으로 받을 때 교체)
//        //JSON의 대괄호[]는 배열
//        //JSON의 중괄호{}는 key/value
//        JSONObject test = new JSONObject();
//        //JSONObject는 KEY/VALUE로 구성되어 있는 MAP과 동일하기 때문에 put()으로 데이터 저장
//        test.put("continent_cd", "continent_cd_example");
//        test.put("country_eng_nm", "country_eng_nm_example");
//        test.put("html_origin_cn", "html_origin_cn_example");
//
//        //mission1 : JSONObject를 임의로 3개를 만들고 반복문(for)을 활용하여 DB에 저장하시오
//        //1)JSONObject를 ArrayList에 담아서 하나씩 불러온 뒤에
//        //covid19notiRepository.save(INSTANCE); 실행하기
//
//
//        for(int i = 0; i<3; i++) {
//            //(1)JSON 데이터를 받아와서 get(KEY)으로 인스턴스 인자값 넣기 : 인스턴스 생성자로 데이터 튜플만들기
//            Covid19noti covid19noti = new Covid19noti(
//                    count, test.getString("continent_cd"),
//                    test.getString("country_eng_nm"), test.getString("html_origin_cn")
//            );
//
//            //(2)DB repository에 저장하기 (repository/openapi/Covid19notiRepository 인스턴스 만든 뒤 sampleAPI Controller에서 필드값 주입)
//            covid19notiRepository.save(covid19noti);
//            count++;
//        }


        // String 문자열을 key:value로 되어 있는 JSONObject 타입으로 변환
        // JSONObject : {} : Key/value : 인자값은 항상 문자열(toString())
        JSONObject jObject = new JSONObject(sb.toString());
        System.out.println("------------");
        System.out.println(jObject);
        // data라는 key의 value를 바로 array타입으로 저장하기
        // jObject.getJSONArray(KEY) : jObject 배열 안에 있는 값을 arrayList로 가져오겠다
        JSONArray jsonExample = jObject.getJSONArray("data");
//        JSONObject item = new JSONObject(jsonExample.get(0).toString());
//        System.out.println(item);

        //data key에 저장된 value의 길이만큼 반복문 돌리는 조건문
        for(int i = 0; i<jsonExample.length(); i++) {
//            data key에 저장된 배열 안에 있는 값을 JSONObject 타입으로 받아옴 : JSONArray 배열에 안에 있는 값을 다시 문자열(toString())으로 바꾼 뒤에
            //JSONObject 타입으로 바꿈
            //배열([])안에 JSONOject({})로 되어 있기 때문에 한 번더 Object로 변환
            JSONObject item = new JSONObject(jsonExample.get(i).toString());

            Covid19noti covid19noti_example = new Covid19noti(count,
                    item.getString("continent_eng_nm"),
                    item.getString("sfty_notice_id"));
            //받아온 데이터를 DB에 저장
            covid19notiRepository.save(covid19noti_example);
            count++;
        };
//        JSONArray jsonExample_deptArry = new JSONArray("data");
//        System.out.println(jsonExample_deptArry);
//        JSONObject jsonExample_dept1 = new JSONObject("data");
//        System.out.println("------------");
//        System.out.println(jsonExample_dept1);
//        String html_origin_cn = jsonExample_dept1.getString("html_origin_cn");
//
//        System.out.println("------------");
//        System.out.println(html_origin_cn);


//        jObject.getString(KEY) 메서드를 사용하여 KEY값에 있는 value문자열을 String 변수에 저장
//        String currentCount = jObject.getString("currentCount");
//        String 문자열이 아닌 배열 혹은 KEY VALUE로 되어 있는 데이터 형식 = JSONObject
//        JSONObject data = jObject.getJSONObject("data");

        //mission1 : data JSONBoject의 경우 데이터 덩어리가 2개 존재 확인하기
        //향상된 for문으로 처음부터~끝까지

        //data Object를 2개 나누어야 함
        //mission2 : Covid19noti 인스턴스를 2개 만들어서 필드에 데이터 저장

        //mission3 : DB

//        String continent_cd = jObject.getString("continent_cd");
//        String country_eng_nm = jObject.getString("country_eng_nm");
//        String html_origin_cn = jObject.getString("html_origin_cn");
//
//        Covid19noti covid19noti = new Covid19noti(10L, continent_cd, country_eng_nm, html_origin_cn);


        return "covid/covid";
    }

}
