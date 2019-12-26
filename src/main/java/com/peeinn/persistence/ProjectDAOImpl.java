package com.peeinn.persistence;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peeinn.domain.Criteria;
import com.peeinn.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "mappers.spmsMapper";

	@Override
	public List<ProjectVO> selectList(Criteria cri) {
		return sqlSession.selectList(namespace + ".selectList", cri);
	}

	@Override
	public void insert(ProjectVO p) {
		sqlSession.insert(namespace + ".insert", p);
	}

	@Override
	public ProjectVO selectByNo(int no) {
		return sqlSession.selectOne(namespace + ".selectByNo", no);
	}

	@Override
	public void update(ProjectVO p) {
		sqlSession.update(namespace + ".update", p);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete(namespace + ".delete", no);
	}

	@Override
	public int selectTotalCnt() {
		return sqlSession.selectOne(namespace + ".selectTotalCnt");
	}

}// ProjectDAOImpl
