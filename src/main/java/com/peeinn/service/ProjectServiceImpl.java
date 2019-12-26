package com.peeinn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peeinn.domain.Criteria;
import com.peeinn.domain.ProjectVO;
import com.peeinn.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO dao;

	@Override
	public void insert(ProjectVO p) {
		dao.insert(p);
	}

	@Override
	public void update(ProjectVO p) {
		dao.update(p);
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
	}

	@Override
	public List<ProjectVO> selectList(Criteria cri) {
		return dao.selectList(cri);
	}

	@Override
	public ProjectVO selectByNo(int no) {
		return dao.selectByNo(no);
	}

	@Override
	public int selectTotalCnt() {
		return dao.selectTotalCnt();
	}

}
