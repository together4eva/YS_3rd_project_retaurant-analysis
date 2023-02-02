package com.example.studySpringboot0002.controller.project3;
import com.example.studySpringboot0002.component.scraping.Morphological_Analysis;
import com.example.studySpringboot0002.component.scraping.Project3_kakaomap_scraping;
import com.example.studySpringboot0002.service.project3.Project3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Project3Controller {

private Project3Service project3Service;
private Project3_kakaomap_scraping project3_kakaomap_scraping ;
private Morphological_Analysis morphological_Analysis;

@Autowired
public Project3Controller(Project3Service project3Service, Project3_kakaomap_scraping project3_kakaomap_scraping, Morphological_Analysis morphological_Analysis){
        this.project3Service = project3Service;
        this.project3_kakaomap_scraping = project3_kakaomap_scraping;
        this.morphological_Analysis = morphological_Analysis;
}
/**
 *
 * @param model project3List
 * @return
 */
        //음식점 정보
        @GetMapping("project3_index")
        public String project3_index(Model model ) {
                model.addAttribute("Project3List", this.project3Service.FindAllProject3db());
                return "project3/project3_index";
                }
        //음식점 분석
        @GetMapping("project3_analysis")
        public String project3_analysis(Model model ) {
                model.addAttribute("Project3List", this.project3Service.FindAllProject3db());
                model.addAttribute("AnalysisArrayList", this.morphological_Analysis.Analysis());
                model.addAttribute("AnalysisTitleList", this.morphological_Analysis.AnalysisTitle());
                model.addAttribute("AnalysisProject3List", this.morphological_Analysis.AnalysisProject3());
                return "project3/project3_analysis";
        }
        //음식점 그래프
        @GetMapping("project3_Graph")
        public String project3_Graph(Model model ) {
                model.addAttribute("Project3List", this.project3Service.FindAllProject3db());
                //음식점 분석 점수
                model.addAttribute("AnalysisArrayList", this.morphological_Analysis.Analysis());
                //음식점명
                model.addAttribute("AnalysisTitleList", this.morphological_Analysis.AnalysisTitle());
                //후기 평점
                model.addAttribute("AnalysisNumberScoreList", this.morphological_Analysis.AnalysisNumberScore());
                //리뷰 수
                model.addAttribute("AnalysisNumberOfReviewList", this.morphological_Analysis.AnalysisNumberOfReview());
                //후기 평점 수
                model.addAttribute("AnalysisnumberOfScoreListList", this.morphological_Analysis.AnalysisnumberOfScoreList());
                return "project3/project3_Graph";
        }


        @PostMapping("project3_index")
        public String project3_index(
                        ) {
                this.project3Service.saveAllProject3db(project3_kakaomap_scraping.scraping());
                //redirect 적용
                return "redirect:/project3_index";
                }

        @PostMapping("project3_analysis")
        public String project3_analysis(
        ) {
                this.morphological_Analysis.Analysis();
                //redirect 적용
                return "redirect:/project3_analysis";
        }


//
//        //kakaoMap api test
//        @GetMapping("kakaoMap")
//        public String kakaoMap() {
//
//                return "kakaoMap/kakaoMap";
//        }
}
