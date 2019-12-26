package com.peeinn.service;

import java.util.List;

import com.peeinn.domain.Criteria;
import com.peeinn.domain.ProjectVO;

public interface ProjectService {
	
	public void insert(ProjectVO p);
	public void update(ProjectVO p);
	public void delete(int no);

	public List<ProjectVO> selectList(Criteria cri);
	public ProjectVO selectByNo(int no);
	
	public int selectTotalCnt();
	
}//ProjectService
