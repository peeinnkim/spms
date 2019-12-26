package com.peeinn.spms;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peeinn.domain.Criteria;
import com.peeinn.domain.ProjectVO;
import com.peeinn.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ProjectDAOTest {

	@Autowired
	private ProjectDAO dao;

	//@Test
	public void testInsert() {
		dao.insert(new ProjectVO(0, "insert test", "it's insert test", new Date(), new Date(), "종료"));
	}

	//@Test
	public void testList() {
		List<ProjectVO> list = dao.selectList(new Criteria(1, 3));

		for (ProjectVO p : list) {
			System.out.println(p);
		}
	}

	//@Test
	public void testUpdate() {
		dao.update(new ProjectVO(91, "엉울엉울", "엉울엉울엉", new Date(), new Date(), "종료"));
	}

	@Test
	public void testDelete() {
		dao.delete(91);
	}

	//@Test
	public void testSelectByNo() {
		ProjectVO p = dao.selectByNo(90);
		System.out.println(p);
	}

	//@Test
	public void testSelectTotalCnt() {
		int cnt = dao.selectTotalCnt();
		System.out.println(cnt);
	}

}// ProjectDAOTest
