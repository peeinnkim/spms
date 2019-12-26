package com.peeinn.spms;

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
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProjectDAOTest {

	@Autowired
	private ProjectDAO dao;
	
	@Test
	public void testList() {
		List<ProjectVO> list = dao.selectList(new Criteria(1, 3));
		
		for(ProjectVO p : list) {
			System.out.println(p);
		}
	}
}//ProjectDAOTest
