package com.example.studySpringboot0002.component.scraping;

import com.example.studySpringboot0002.entity.project3.Project3Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

//selenium : 동적인 데이터 수집 가능 (직접 브라우저를 통제해서 사람처럼 브라우저 작동을 하여 데이터 수집) : chromeDriver
//jsoup : httpRequest 사용해서 정적인 데이터(HTML, CSS..)를 수집

public class Project3_kakaomapReview_scraping {

    public static void main(String[]args){
        scraping();
    }
    //selenum 드라이버 다운
    private static WebDriver driver;
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

    //    private static final String WEB_DRIVER_PATH = "/Users/js/Cleancode/lecture_spring_2_crudProject/src/main/resources/static/tool/chromedriver";
    //학원
    private static final String WEB_DRIVER_PATH = "D:/KIMJIHYEOK/project3_java/chromedriver.exe";
    //집
//    private static final String WEB_DRIVER_PATH = "C:/KIMJIHYEOK/chromedriver.exe";
    //메서드 매개변수로 받아서 스크래핑 동작을 위한 변수 선언
    private static String base_url;



    public static ArrayList<Project3Entity> scraping() {
        //System.io : 개발한 자바 프로그램(런타임)에서 외부 프로그램을 작동하기 위한 객체
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();

        base_url = "https://map.kakao.com/link/search/수원시청치킨";
//        base_url = "https://map.kakao.com/link/search/수원시청음식점";
        driver.get(base_url);

        ArrayList<Project3Entity> project3EntityArrayList = new ArrayList<>();
        List<WebElement> elements_button;
        List<WebElement> elements_button1;
        List<WebElement> elements_button2;
        List<WebElement> elements_button3;
        List<WebElement> elements_total;;
        List<WebElement> elements_totalReview;
        List<WebElement> elements_viewMoreReviewDetail;
        int number =0;

        try {
            Thread.sleep(10000);

            //스크래핑할 페이지의 전체 데이터 출력
//            System.out.println(driver.getPageSource());
            JavascriptExecutor js = (JavascriptExecutor) driver;
/////////////////////////////////////////////가게 정보 가져오기
            //카카오맵 더 보기 클릭
            WebElement viewMore = driver.findElement(By.id("info.search.place.more"));
            ((ChromeDriver) driver).executeScript("arguments[0].click();", viewMore);
            Thread.sleep(5000);

            //1~5 페이지 넘버 클릭
            for(int z = 1; z<6; z++){
                WebElement numPage = driver.findElement(By.id(String.format("info.search.page.no%d",z)));
                //클릭
                ((ChromeDriver)driver).executeScript("arguments[0].click();", numPage);
                Thread.sleep(5000);

                elements_button = driver.findElements(By.className("link_name"));
                elements_button1 = driver.findElements(By.cssSelector("em[data-id='scoreNum']"));
                elements_button2 = driver.findElements(By.cssSelector("a[data-id='numberofscore']"));
                elements_button3 = driver.findElements(By.cssSelector("em[data-id='numberofreview']"));
                elements_total = driver.findElements(By.cssSelector("em[id='info.search.place.cnt']"));

                for (int i = 0; i < elements_button.size(); i++) {

                    String title = elements_button.get(i).getText();
                    String numberScore = elements_button1.get(i).getText();
                    String numberofscore = elements_button2.get(i).getText();
                    String[] numberOfScoreList = numberofscore.split("건", 5);
                    String numberOfReview = elements_button3.get(i).getText();
                    String total = elements_total.get(0).getText();
                    String viewMoreReviewDetail = null;

                    System.out.println("------------------------------------------");
                    System.out.println("현재 번호 :"+number);
                    System.out.println("음식점명 : "+title);
                    System.out.println("평점 : "+numberScore);
                    System.out.println("평점 리뷰 수 : "+numberOfScoreList[0]);
                    System.out.println("리뷰 수 : "+numberOfReview);
                    System.out.println("------------------------------------------");
                    number+=1;
/////////////////////////////////////////////가게 정보 끝
/////////////////////////////////////////////리뷰 더보기 가져오기
                    //리뷰 클릭
                    elements_button2 = driver.findElements(By.cssSelector("a[data-id='numberofscore']"));
                    ((ChromeDriver) driver).executeScript("arguments[0].click();", elements_button2.get(i));
                    Thread.sleep(5000);

                    //현재 Window 저장
                    String parentHandle = driver.getWindowHandle();

                    //현재 Window 목록 조회
                    Set<String> windowList = driver.getWindowHandles();
                    for (String windowHandle : windowList) {
                        if (parentHandle.equals(windowHandle)) {
                            continue;
                        }
                        //원하는 Window로 이동
                        driver.switchTo().window(windowHandle);
                    }

                    //리뷰 더보기 총 개수에 맞게 클릭
                    elements_totalReview = driver.findElements(By.cssSelector("#mArticle > div.cont_evaluation > strong > span"));
                    String totalReivew = elements_totalReview.get(0).getText();
                    System.out.println("-------------------------");
                    System.out.println("-------------------------");
                    System.out.println("-------------------------");
                    System.out.println(totalReivew);

                    //리뷰 더보기 총 개수가 4이상일 경우
                    if((Integer.parseInt(totalReivew)>3)){
                        for (int a = 0; a < (Integer.parseInt(totalReivew) - 3) / 5 + 1; a++) {
                            System.out.println("dddddddddddddd");
                            System.out.println("dddddddddddddd");
                            System.out.println("dddddddddddddd");
                            System.out.println("dddddddddddddd");
                            //리뷰 더 보기 클릭
                            WebElement viewMoreReview = driver.findElement(By.cssSelector("#mArticle > div.cont_evaluation > div.evaluation_review > a > span.txt_more"));
                            ((ChromeDriver) driver).executeScript("arguments[0].click();", viewMoreReview);
                            Thread.sleep(5000);
                        }
                        //리뷰 더보기 내용 가져오기
                        for (int j = 0; j < Integer.parseInt(totalReivew); j++) {
                            elements_viewMoreReviewDetail = driver.findElements(By.cssSelector(String.format("div.comment_info > p > span")));
                            viewMoreReviewDetail = elements_viewMoreReviewDetail.get(j).getText();
                            System.out.println("-------------------------");
                            System.out.println("리뷰 더보기 내용 : "+viewMoreReviewDetail);
                            System.out.println("-------------------------");
                        }
                    }else{
                        //리뷰 더보기 내용 가져오기
                        for (int j = 0; j < Integer.parseInt(totalReivew); j++) {
                            elements_viewMoreReviewDetail = driver.findElements(By.cssSelector(String.format("div.comment_info > p > span")));
                            viewMoreReviewDetail = elements_viewMoreReviewDetail.get(j).getText();
                            System.out.println("-------------------------");
                            System.out.println("리뷰 더보기 내용 : " + viewMoreReviewDetail);
                            System.out.println("-------------------------");
                        }
                    }

                    //기존 Window로 이동
                    driver.switchTo().window(parentHandle);
/////////////////////////////////////////////////리뷰 더보기 가져오기 끝

                    //scraping 데이터 list에 저장


                    Project3Entity project3Entity = new Project3Entity(
                            number, title, Double.parseDouble(numberScore),
                            Integer.parseInt(numberOfScoreList[0]), Integer.parseInt(numberOfReview),
                            viewMoreReviewDetail
                    );
                    project3EntityArrayList.add(project3Entity);

                    if(number==Integer.parseInt(total)){
                        throw new Exception("마지막 페이지까지 조회 완료 입니다");
                    }
                }
                //다음 페이지 클릭
                if(z%5==0){
                    WebElement nextPage = driver.findElement(By.id("info.search.page.next"));
                    //클릭
                    ((ChromeDriver)driver).executeScript("arguments[0].click();", nextPage);
                    Thread.sleep(5000);
                    z=1;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //공식문서에서는 close()가 아니라 quit() 권장
            driver.quit();
        }
        return project3EntityArrayList;
    }
}
