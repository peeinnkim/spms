<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../include/header.jsp" %>

	<form action="update" method="post" class="inner-section">
		<input type="hidden" name="no" value="${p.no}">
		<input type="hidden" name="page" value="${cri.page}">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="project_name" size="40" value="${p.project_name}">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea name="project_content" cols="50" rows="10">${p.project_content}</textarea>
		</p>
		<p>
			<label>시작날짜</label>
			<fmt:formatDate value="${p.begin_date}" type="date" pattern="yyyy-MM-dd" var="bDate"/>
			<input type="date" name="begin_date" value="${bDate}">
		</p>
		<p>
			<label>마감날짜</label>
			<fmt:formatDate value="${p.end_date}" type="date" pattern="yyyy-MM-dd" var="eDate"/>
			<input type="date" name="end_date" value="${eDate}">
		</p>
		<p>
			<label>상태</label>
			<select name="project_statement">
				<option ${p.project_statement == '준비'? "selected='selected'" : ""}>준비</option>
				<option ${p.project_statement == '진행중'? "selected='selected'" : ""}>진행중</option>
				<option ${p.project_statement == '종료'? "selected='selected'" : ""}>종료</option>
				<option ${p.project_statement == '보류'? "selected='selected'" : ""}>보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</p>
	</form>

	
<script>
	$("input[type='reset']").click(function(){
		var no = $("input[name='no']").val();
		var page = $("input[name='page']").val();
		location.href="${pageContext.request.contextPath}/project/detail?no=" + no + "&page=" + page;
	})
	
	$("form").submit(function(){
		if($("input[name='project_name']").val() == "") {
			alert("프로젝트 이름 미입력");
			return false;
		}
		if($("textarea").val() == "") {
			alert("프로젝트 내용 미입력");
			return false;
		}
		if($("input[name='begin_date']").val() == "") {
			alert("시작 날짜 미입력");
			return false;
		}
		if($("input[name='end_date']").val() == "") {
			alert("종료 날짜 미입력");
			return false;
		}
		
		var date1 = new Date($("input[name='begin_date']").val());
		var date2 = new Date($("input[name='end_date']").val());
		
		if(date1.getTime() > date2.getTime()) {
			alert("날짜설정 오류");
			return false;
		}
	})
		
	
</script>		
		
<%@ include file="../include/footer.jsp" %>