package com.peeinn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peeinn.domain.Criteria;
import com.peeinn.domain.PageMaker;
import com.peeinn.domain.ProjectVO;
import com.peeinn.service.ProjectService;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	ProjectService service;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model, Criteria cri) {
		logger.info("----------list----------");
		List<ProjectVO> list = service.selectList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.selectTotalCnt());
		
		model.addAttribute("list", list);  
		model.addAttribute("pageMaker", pageMaker);  
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public void insertGet() {
		logger.info("----------insertGet----------");
	}  

	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertPost(ProjectVO p) {
		logger.info("----------insertPost----------");
		service.insert(p);
		
		return "redirect:/project/list";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void updateGet(int no, Model model, Criteria cri) {
		logger.info("----------updateGet----------");
		ProjectVO p = service.selectByNo(no);
		model.addAttribute("p", p);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePost(ProjectVO p, Criteria cri) {
		logger.info("----------updatePost----------");
		service.update(p);
		
		return "redirect:/project/detail?no=" + p.getNo() + "&page=" + cri.getPage();
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void detail(int no, Model model, Criteria cri) {
		logger.info("----------detail----------");
		ProjectVO p = service.selectByNo(no);
		model.addAttribute("p", p);
		model.addAttribute("cri", cri);
	}

	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(Model model, int no, Criteria cri) {
		logger.info("----------delete----------");
		service.delete(no);
		model.addAttribute("cri", cri);
		
		return "redirect:/project/list?&page=" + cri.getPage();
	}
	
	
}//ProjectController
