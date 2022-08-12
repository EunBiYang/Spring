package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.service.ScoreService;

public class HelloSpring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		ScoreService scs = (ScoreService) context.getBean("scoreService");
		
		ScoreVO vo = new ScoreVO();
		int result = 0;
		String studNo, name;
		int kor, eng, mat, tot;
		double avg;
		
		int sel = 0;
		
		do {
			System.out.println("");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.println("--------------");
			System.out.print("번호 : ");
			sel = sc.nextInt();
			
			if(sel == 5) {
				System.out.println("프로그램 종료");
				System.exit(0);
				context.close();
			} else {
				switch(sel) {
				case 1:
					System.out.print("학번 : ");
					studNo = sc.next();
					System.out.print("이름 : ");
					name = sc.next();
					System.out.print("국어 : ");
					kor = sc.nextInt();
					System.out.print("영어 : ");
					eng = sc.nextInt();
					System.out.print("수학 : ");
					mat = sc.nextInt();
					tot = kor + eng + mat;
					avg = tot / 3.0;
					
					vo.setStudNo(studNo);
					vo.setName(name);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMat(mat);
					vo.setTot(tot);
					vo.setAvg(avg);
					
					result = scs.insert_score(vo);
					if(result > 0) System.out.println("저장 성공");
					else System.out.println("저장 실패");
					break;
				case 2:
					List<ScoreVO> list = scs.get_scorelist();
					
					for(ScoreVO scoreVO : list) {
						System.out.println(scoreVO.toString());
					}
					break;
				case 3:
					System.out.print("학번 : ");
					studNo = sc.next();
					System.out.print("이름 : ");
					name = sc.next();
					System.out.print("국어 : ");
					kor = sc.nextInt();
					System.out.print("영어 : ");
					eng = sc.nextInt();
					System.out.print("수학 : ");
					mat = sc.nextInt();
					tot = kor + eng + mat;
					avg = tot / 3.0;
					
					vo.setStudNo(studNo);
					vo.setName(name);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMat(mat);
					vo.setTot(tot);
					vo.setAvg(avg);
					
					result = scs.update_score(vo);
					if(result > 0) System.out.println("수정 성공");
					else System.out.println("수정 실패");
					break;
				case 4:
					System.out.print("학번 : ");
					studNo = sc.next();
					
					result = scs.delete_score(studNo);
					if(result > 0) System.out.println("삭제 성공");
					else System.out.println("삭제 실패");
					break;
				}
			}
		} while(true);
	}
}
