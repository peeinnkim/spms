package com.peeinn.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectVO {
	private int no;
	private String project_name;
	private String project_content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date begin_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;
	private String project_statement;

	public ProjectVO() {
	}

	public ProjectVO(int no, String project_name, String project_content, Date begin_date, Date end_date,
			String project_statement) {
		this.no = no;
		this.project_name = project_name;
		this.project_content = project_content;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.project_statement = project_statement;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_content() {
		return project_content;
	}

	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getProject_statement() {
		return project_statement;
	}

	public void setProject_statement(String project_statement) {
		this.project_statement = project_statement;
	}

	@Override
	public String toString() {
		return no + "/" + project_name + "/" + project_content + "/" + begin_date + "/" + end_date + "/"
				+ project_statement;
	}

}// ProjectDTO
