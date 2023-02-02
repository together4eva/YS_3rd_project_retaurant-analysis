package com.example.studySpringboot0002.component.scraping;


import com.example.studySpringboot0002.entity.project3.Project3Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class selenium_test {

    //selenum 드라이버 다운
    private static WebDriver driver;
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "D:/KIMJIHYEOK/project3_java/chromedriver.exe";
    //메서드 매개변수로 받아서 스크래핑 동작을 위한 변수 선언
    private static String base_url;

    public static void main(String[] args) {
        scraping_test();
    }

    public static void scraping_test() {
        //System.io : 개발한 자바 프로그램(런타임)에서 외부 프로그램을 작동하기 위한 객체
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();


        base_url = "https://map.kakao.com/";
//        base_url = "https://place.map.kakao.com/933221404#comment";
//        base_url = "https://map.kakao.com/link/search/수원시청음식점";
        driver.get(base_url);

//        ArrayList<Project3Entity> project3EntityArrayList = new ArrayList<>();
        List<WebElement> elements_button;
        List<WebElement> elements_button1;
        List<WebElement> elements_button2;
        List<WebElement> elements_button3;
        List<WebElement> elements_total;
        List<WebElement> elements_totalReview;
        List<WebElement> elements_viewMoreReviewDetail;
        List<WebElement> elements_search;
        boolean check_5page = true;
        int number = 0;
        String viewMoreReviewDetail=null;
        try {
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            elements_search = driver.findElements(By.cssSelector("#search\\.keyword\\.query"));
//            elements_search.send_keys("");
//            elements_search.submit();



//            for(int i =0; i<3; i++){
/////////////////////////////////////리뷰 더보기 가져오기
//
//
//
//                //리뷰 클릭
//                elements_button2 = driver.findElements(By.cssSelector("a[data-id='numberofscore']"));
//                ((ChromeDriver) driver).executeScript("arguments[0].click();", elements_button2.get(i));
//                Thread.sleep(5000);
//
//            //현재 Window 저장
//            String parentHandle = driver.getWindowHandle();
//
//            //현재 Window 목록 조회
//            Set<String> windowList = driver.getWindowHandles();
//            for (String windowHandle : windowList) {
//                if (parentHandle.equals(windowHandle)) {
//                    continue;
//                }
//                //원하는 Window로 이동
//                driver.switchTo().window(windowHandle);
//            }
//                //리뷰 더보기 총 개수에 맞게 클릭
//                elements_totalReview = driver.findElements(By.cssSelector("#mArticle > div.cont_evaluation > strong > span"));
//                String totalReivew = elements_totalReview.get(0).getText();
//                System.out.println("-------------------------");
//                System.out.println("-------------------------");
//                System.out.println("-------------------------");
//                System.out.println(totalReivew);
//
//                //리뷰 더보기 총 개수가 4이상일 경우
//                if((Integer.parseInt(totalReivew)>3)){
//                    for (int a = 0; a < (Integer.parseInt(totalReivew) - 3) / 5 + 1; a++) {
//                        System.out.println("dddddddddddddd");
//                        System.out.println("dddddddddddddd");
//                        System.out.println("dddddddddddddd");
//                        System.out.println("dddddddddddddd");
//                        //리뷰 더 보기 클릭
//                        WebElement viewMoreReview = driver.findElement(By.cssSelector("#mArticle > div.cont_evaluation > div.evaluation_review > a > span.txt_more"));
//                        ((ChromeDriver) driver).executeScript("arguments[0].click();", viewMoreReview);
//                        Thread.sleep(5000);
//                    }
//                    //리뷰 더보기 내용 가져오기
//                    for (int j = 0; j < Integer.parseInt(totalReivew); j++) {
//                        elements_viewMoreReviewDetail = driver.findElements(By.cssSelector("div.comment_info > p > span"));
//                        viewMoreReviewDetail = elements_viewMoreReviewDetail.get(j).getText();
//                        System.out.println("-------------------------");
//                        System.out.println("리뷰 더보기 내용 : "+viewMoreReviewDetail);
//                        System.out.println("-------------------------");
//                    }
//                }else{
//                    //리뷰 더보기 내용 가져오기
//                    for (int j = 0; j < Integer.parseInt(totalReivew); j++) {
//                        elements_viewMoreReviewDetail = driver.findElements(By.cssSelector("div.comment_info > p > span"));
//                        viewMoreReviewDetail = elements_viewMoreReviewDetail.get(j).getText();
//                        System.out.println("-------------------------");
//                        System.out.println("리뷰 더보기 내용 : " + viewMoreReviewDetail);
//                        System.out.println("-------------------------");
//                    }
//                }
//
//
/////////////////////////////////////리뷰 더보기 가져오기 끝
//                //탭 닫기
//                driver.close();
//                //기존 Window로 이동
//                driver.switchTo().window(parentHandle);
//            }
//
//

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //공식문서에서는 close()가 아니라 quit() 권장
            driver.quit();
        }
//        String ddd = "17777건";
//
//        String[] arr = ddd.split("건", 6);
//        System.out.println(arr[0]);

    }
}
