<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../include/header.jsp" %>
		
	<form action="insert" method="post" class="inner-section">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="project_name" size="40">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea name="project_content" cols="50" rows="10"></textarea>
		</p>
<!-- 		<p>
			<label>참여인원</label>
			<div></div>
			<button>추가</button>
		</p> -->
		<p>
			<label>시작날짜</label>
			<input type="date" name="begin_date">
		</p>
		<p>
			<label>마감날짜</label>
			<input type="date" name="end_date">
		</p>
		<p>
			<label>상태</label>
			<select name="project_statement">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="저장">
			<input type="reset" value="취소" >
		</p>
	</form>
	
<script>
	$("input[type='reset']").click(function(){
		location.href="${pageContext.request.contextPath}/project/list";
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