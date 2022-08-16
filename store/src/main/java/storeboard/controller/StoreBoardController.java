package storeboard.controller;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import storeboard.bean.StoreBoardDTO;
import storeboard.dao.StoreBoardDAO;

@Controller
public class StoreBoardController {
	@Autowired
	private StoreBoardService storeboardService;

	@RequestMapping(value="/storeboard/storeboardWriteForm.do")
	public String storeboardWriteForm() {
		return "storeboardWriteForm";
	}
	
	@RequestMapping(value="/storeboard/storeboardWrite.do")
	public ModelAndView storeboardWrite(HttpServletRequest request, MultipartFile image1) {
		 String filePath = request.getSession().getServletContext().getRealPath("/storage");
	     String fileName = image1.getOriginalFilename();
	      
	      File file = new File(filePath, fileName);
	     
	      try {
	         FileCopyUtils.copy(image1.getInputStream(), new FileOutputStream(file));
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		 
	      String storeName = request.getParameter("storeName");
	      String storePlace =  request.getParameter("storePlace");
	      int storeNum = Integer.parseInt(request.getParameter("storeNum"));
          String storeCategory = request.getParameter("storeCategory");
          String storeContent = request.getParameter("storeContent");
        		  
	      StoreBoardDTO dto = new StoreBoardDTO();
	      dto.setStoreName(storeName);
	      dto.setStorePlace(storePlace);
	      dto.setStoreNum(storeNum);
	      dto.setStoreCategory(storeCategory);
	      dto.setStoreContent(storeContent);
	      dto.setImage1(fileName);
	      
	      
		  int result = storeboardService.storeboardWrite(dto);
		
		// 화면 네비게이션 = 데이터 공유 + view 처리 파일명 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("storeboardWrite");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/storeboard/storeboardList.do")
	public ModelAndView storeboardList(HttpServletRequest request) {
		// 데이터
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 1. 목록보기 : 5개
		int endNum = pg * 10;
		int startNum = endNum - 9;

		
		List<StoreBoardDTO> list = storeboardService.storeboardList(startNum, endNum);

		// 2. 페이징 처리
		int totalA = storeboardService.getTotalA(); // 총글수
		int totalP = (totalA + 9) / 10; // 총 페이지수

		// 블럭 설정 : 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;
		
		// 3. 화면 네비게이션 = 데이터 공유 + view 처리 파일명 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("storeboardList");
		
		return modelAndView;
	}
	
	
}
