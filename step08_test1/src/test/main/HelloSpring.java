package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import test.bean.ScoreVO;
import test.service.ScoreService;

@Component
public class HelloSpring {
   Scanner sc = new Scanner(System.in);
   
   @Autowired
   private ScoreService scoreService;
   
   private void menu() {
      int sel = 0;
      
      do {
         System.out.println("");
         System.out.println("1. 입력");
         System.out.println("2. 출력");
         System.out.println("3. 검색   (학번으로 검색)");
         System.out.println("4. 수정");
         System.out.println("5. 삭제");
         System.out.println("6. 종료");
         System.out.println("--------------");
         System.out.print("번호 : ");
         sel = sc.nextInt();
         
         switch(sel) {
            case 1: score_insert();   break;
            case 2: score_list();    break;
            case 3: score_get(); break;
            case 4: score_modify(); break;
            case 5: score_delete(); break;
            case 6: System.out.println("프로그램 종료");
            return; //호출한 곳으로 돌아간다.           
         }
      }while(true);
   }
   
   private void score_insert() {
      ScoreVO vo = new ScoreVO();
      System.out.print("학번 : ");
      vo.setStudNo(sc.next());
      System.out.print("이름 : ");
      vo.setName(sc.next());
      System.out.print("국어 : ");
      vo.setKor(sc.nextInt());
      System.out.print("영어 : ");
      vo.setEng(sc.nextInt());
      System.out.print("수학 : ");
      vo.setMat(sc.nextInt());
      
      int tot = vo.getKor() + vo.getEng() + vo.getMat();
      double avg = tot / 3.0;
      
      vo.setTot(tot);
      vo.setAvg(avg);
      
      int result = scoreService.insert_score(vo);
      
      if(result > 0) System.out.println("저장 성공");
      else System.out.println("저장 실패");
   }
   
   private void score_modify() {
      ScoreVO vo = new ScoreVO();
      System.out.print("수정할 학번 : ");
      vo.setStudNo(sc.next());
      System.out.print("이름 : ");
      vo.setName(sc.next());
      System.out.print("국어 : ");
      vo.setKor(sc.nextInt());
      System.out.print("영어 : ");
      vo.setEng(sc.nextInt());
      System.out.print("수학 : ");
      vo.setMat(sc.nextInt());
      
      int tot = vo.getKor() + vo.getEng() + vo.getMat();
      double avg = tot / 3.0;
      
      vo.setTot(tot);
      vo.setAvg(avg);
      
      int result = scoreService.update_score(vo);
      
      if(result > 0) System.out.println("수정 성공");
      else System.out.println("수정 실패");
   }
   
   private void score_delete() {
      System.out.print("삭제할 학번 : ");
      String studNo = sc.next();
      
      int result = scoreService.delete_score(studNo);
      
      if(result > 0) System.out.println("삭제 성공");
      else System.out.println("삭제 실패");
   }
   
   private void score_get() {
		System.out.print("학번 검색 : ");
		ScoreVO Searchvo = scoreService.get_score(sc.next());
		if(Searchvo == null) {
			System.out.println("검색한 학번이 없습니다.");
		} else {
			System.out.println(Searchvo.toString());
		}
	}
   private void score_list() {
      List<ScoreVO> list = scoreService.get_scorelist();
      
      String title = "학번\t이름\t국어\t영어\t수학\t총점\t평균\t입력일";
      System.out.println(title);
      
      for(ScoreVO scoreVO : list) {
         System.out.println(scoreVO.toString());
      }
   }
   
   public static void main(String[] args) {      
      GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
      
      HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
      
      helloSpring.menu();
      
      context.close();      
   }
}