<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../include/header.jsp" %>
	

		<div class="inner-section">
		<a href="${pageContext.request.contextPath}/project/insert" class="add-href">새 프로젝트 등록</a>
			<table>
				<tr>
					<th>프로젝트 이름</th>
					<th>시작날짜</th>
					<th>종료날짜</th>
					<th>상태</th>
				</tr>
				<c:forEach var="p" items="${list}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/project/detail?no=${p.no}&page=${pageMaker.cri.page}">${p.project_name}</a></td>
						<td><fmt:formatDate value="${p.begin_date}" type="date" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${p.end_date}" type="date" pattern="yyyy-MM-dd"/></td>
						<td>${p.project_statement}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div class="pagination-wrap">
				<ul class="pagination">
					<c:if test="${pageMaker.prev == true}">
						<li class="previous">
							<a href="list?page=${pageMaker.startPage-1}">
								◀
							</a>
						</li>
					</c:if>				
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
						<li ${idx == pageMaker.cri.page? 'class=active': ''}>
							<a href="list?page=${idx}">
								${idx}
							</a>									
						</li>
					</c:forEach>
					<c:if test="${pageMaker.next == true}">
						<li class="next">
							<a href="list?page=${pageMaker.endPage+1}">
								▶
							</a>
						</li>
					</c:if>					
				</ul>
			</div>
			
		</div>

		
<%@ include file="../include/footer.jsp" %>