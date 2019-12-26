<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../include/header.jsp" %>

	<script>
		$(function() {
			$("#del-href").click(function() {
				var result = confirm("삭제하시겠습니까?");
	
				if (result == true) {
					return true;
				} else {
					return false;
				}
			});
	
		})
	</script>
	
	<div class="inner-section">
		<a href="insert" class="add-href">새 프로젝트 등록</a>
		<table>
			<tr>
				<th>프로젝트 이름</th>
				<td>${p.project_name}</td>
			</tr>
			<tr>
				<th>프로젝트 내용</th>
				<td>${p.project_content}</td>
			</tr>
			<tr>
				<th>시작날짜</th>
				<fmt:formatDate value="${p.begin_date}" type="date" pattern="yyyy-MM-dd" var="bDate" />
				<td>${bDate}</td>
			</tr>
			<tr>
				<th>종료날짜</th>
				<fmt:formatDate value="${p.end_date}" type="date" pattern="yyyy-MM-dd" var="eDate" />
				<td>${eDate}</td>
			</tr>
			<tr>
				<th>상태</th>
				<td>${p.project_statement}</td>
			</tr>
		</table>
		<p>
			<a href="${pageContext.request.contextPath}/project/update?no=${p.no}&page=${cri.page}">수정</a>
			<a href="${pageContext.request.contextPath}/project/delete?no=${p.no}&page=${cri.page}" id="del-href">삭제</a> 
			<a href="${pageContext.request.contextPath}/project/list?page=${cri.page}">돌아가기</a>
		</p>
	</div>

<%@ include file="../include/footer.jsp" %>
