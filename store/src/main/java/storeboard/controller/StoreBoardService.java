package storeboard.controller;

import java.util.List;

import storeboard.bean.StoreBoardDTO;




public interface StoreBoardService {
	public List<StoreBoardDTO> storeboardList(int startNum, int endNum);
	public int getTotalA();
	public int storeboardWrite(StoreBoardDTO dto);
	
}
