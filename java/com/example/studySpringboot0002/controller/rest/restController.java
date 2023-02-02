package com.example.studySpringboot0002.controller.rest;

import com.example.studySpringboot0002.entity.example.entityExample;
import com.example.studySpringboot0002.entity.search.SearchCSV;
import com.example.studySpringboot0002.repository.openapi.Covid19notiRepository;
import com.example.studySpringboot0002.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * server1
 * python 서버와 연동하여 데이터 송수신하는 controller
 */
//@RestController : HTML 파일 경로를 찾지 않고, String 문자열(JSON)로 retrun하는 Controller = @ResponseBody
@RestController()
public class restController {

    private final SearchService searchService;

    @Autowired
    public restController(SearchService searchService) {
        this.searchService = searchService;
    }

    /**
     * csv 파일 위치를 return하는 메서드
     * @param csvRequest
     * @return String(csvLink)
     */
    @GetMapping("/csvlink")
    public String scvlink(@RequestParam(value = "csvRequest")String csvRequest) {
        //http://localhost:8090/csvlink?csvRequest=covid19
        String resutText = "null";
        List<SearchCSV> result = searchService.findAllSearchCSVUrl();
        for(SearchCSV item : result) {
            if(item.getSubject().equals(csvRequest)) {
                resutText = item.getCsvURL();
            }
        }
        return resutText;
    }

    /**
     * put : 데이터 업데이트
     * @return
     */
    @GetMapping("/python/put/id")
    public Object python_put_id() {
        return null;
    }

    /**
     * get : 데이터 조회
     * @return
     */
    @GetMapping("/python/get/id")
    public Object python_get_id() {
        return null;
    }

    /**
     * post : 데이터 입력
     * @return
     */
    @GetMapping("/python/post/id")
    public Object python_post_id() {
        return null;
    }

    /**
     * delete : 데이터 삭제
     * @return
     */
    public Object python_delete_id() {
        return null;
    }

    @GetMapping("/positionData")
    public Object positionData() {
        return null;
    }

    //String으로 전달
    @GetMapping("/restExample")
    public String restExample() {
        return "나는 김준석";
    }

    //1. entity return {}
    //2. arrayList return []
    //3. HashMap return {}
    //4. Integer return 숫자 = 클라이언트는 문자열

    //Entity(인스턴스)로 전달
    @GetMapping("entityExample")
    public Object entityExample() {
        entityExample result = new entityExample(10L, "김준석");
        entityExample result1 = new entityExample(10L, "박준석");
        entityExample result2 = new entityExample(10L, "이준석");
        ArrayList<entityExample> resultArray = new ArrayList<>();
        HashMap<String, entityExample> resultMap = new HashMap<>();
        resultArray.add(result);
        resultArray.add(result1);
        resultArray.add(result2);
        resultMap.put("1번", result);
        resultMap.put("2번", result2);
        Integer integerTest = 5000;
        String returnData = "김준석0001";
        return returnData;
    }
}
