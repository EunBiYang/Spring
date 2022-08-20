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
	Scanner sc=new Scanner(System.in);	
	@Autowired
	private ScoreService scoreService;
	
	private void menu() {
		int num;
		do {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 검색  (학번으로 검색)");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("------------------");
			System.out.print("번호 : ");
			num=sc.nextInt();
			
			switch(num) {
			case 1:
				insert();
				break;
			case 2:
				print();
				break;
			case 3:
				search();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			case 6:
				System.out.println("종료합니다.");
				return;
				
			}
			System.out.println();	
		}while(true);
			
	}
	
	private void print_title() {
		  String title = "학번\t이름\t국어\t영어\t수학\t총점\t평균\t입력일";
	      System.out.println(title);
	}
	
	private void insert() {
		ScoreVO vo=new ScoreVO();
		System.out.print("학번 : ");
		vo.setStudNo(sc.next());
		
		System.out.print("이름 : ");
		vo.setName(sc.next());
		
		System.out.print("국어점수 : ");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어점수 : ");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학점수 : ");
		vo.setMat(sc.nextInt());
		
		vo.setTot(vo.getEng()+vo.getKor()+vo.getMat());
		vo.setAvg((double)vo.getTot()/3);
		
		if(scoreService.insertScore(vo)>0) {
			System.out.println("저장 성공");
		}else {
			System.out.println("저장 실패");
		}
	}
	
	private void print() {
		List<ScoreVO> list=scoreService.getScoreList();
		print_title();
		for(ScoreVO scoreVO:list) {
			System.out.println(scoreVO.toString());
		}		
	}
	
	private void search() {
		System.out.print("찾아볼 학번 : ");
		ScoreVO vo2=scoreService.getScore(sc.next());
		
		if(vo2==null) {
			System.out.println("학번 조회 실패");
		}else {
			print_title();
			System.out.println(vo2.toString());
		}		
	}
	
	private void modify() {
		ScoreVO vo3=new ScoreVO();
		System.out.print("수정할 학번 : ");
		vo3.setStudNo(sc.next());
		
		System.out.print("이름 : ");
		vo3.setName(sc.next());
		
		System.out.print("국어점수 : ");
		vo3.setKor(sc.nextInt());
		
		System.out.print("영어점수 : ");
		vo3.setEng(sc.nextInt());
		
		System.out.print("수학점수 : ");
		vo3.setMat(sc.nextInt());
		
		vo3.setTot(vo3.getEng()+vo3.getKor()+vo3.getMat());
		vo3.setAvg((double)vo3.getTot()/3);
		
		if(scoreService.updateScore(vo3)>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		
	}
	
	private void delete() {
		System.out.print("삭제할 학번 : ");
		if(scoreService.deleteScore(sc.next())>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("학번 삭제 실패");
		}
		
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext context=
				new GenericXmlApplicationContext("bean.xml");
		
		HelloSpring helloSpring=(HelloSpring) context.getBean("helloSpring");
		helloSpring.menu();
		
		context.close();		
	}
}
