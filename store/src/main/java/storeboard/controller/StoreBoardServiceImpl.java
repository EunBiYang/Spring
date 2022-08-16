package storeboard.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storeboard.bean.StoreBoardDTO;
import storeboard.dao.StoreBoardDAO;

@Service
public class StoreBoardServiceImpl implements StoreBoardService{
	@Autowired
	private StoreBoardDAO dao;

	@Override
	public List<StoreBoardDTO> storeboardList(int startNum, int endNum) {
		return dao.storeboardList(startNum, endNum);
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public int storeboardWrite(StoreBoardDTO dto) {
		return dao.storeboardWrite(dto);
	}


}
