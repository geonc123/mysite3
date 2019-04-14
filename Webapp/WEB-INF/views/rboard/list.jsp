<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">
		<div id="header">

			<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		</div>
		<!-- /header -->

		<div id="navigation">
			<ul>

				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div>
		<!-- /navigation -->

		<div id="content">
			<div id="c_box">
				<div id="board">
					<h2>게시판-리스트</h2>
					<form action="" method="get">
						<input type="text" id="kwd" name="searchKwd" value=""> <input type="submit" value="찾기">
					</form>

					<table class="tbl-ex">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th>작성일</th>
							<th>&nbsp;</th>
						</tr>
						<c:forEach items="${boardList}" var="vo" varStatus="status">

							<tr>
								<td>${vo.no }</td>
								<c:choose>
									<c:when test="${vo.statement eq 'deadpoint'}">
										<td>삭제된 게시글입니다.</td>
									</c:when>
									<c:otherwise>
										<td><a href="${pageContext.request.contextPath}/rboard/read?no=${vo.no}">${vo.title}</a></td>
									</c:otherwise>
								</c:choose>
								<td>${vo.user_no}</td>
								<td>${vo.hit }</td>
								<td>${vo.reg_date}</td>
								<c:if test="${vo.depth eq 0}">
									<td><a href="${pageContext.request.contextPath}/rboard/inwriteform?group_no=${vo.group_no}&order_no=${vo.order_no}">댓글 달기</a>
								</c:if>
								<c:if test="${vo.depth >= 1}">
									<td><a
										href="${pageContext.request.contextPath}/rboard/in_inwriteform?depth=${vo.depth }&order_no=${vo.order_no}&group_no=${vo.group_no}">eo댓글
											달기</a>
								</c:if>
								<td><c:if test="${vo.user_no eq sessionScope.authUser.no}">
										<td><a href="${pageContext.request.contextPath}/rboard/delete?no=${vo.no}" class="del">삭제</a></td>
									</c:if></td>

							</tr>


						</c:forEach>

					</table>




					<div class="pager"></div>
					<div class="bottom">
						<c:if test="${sessionScope.authUser != null }">
							<a href="${pageContext.request.contextPath}/rboard/writeform" id="new-book">글쓰기</a>
						</c:if>
					</div>

				</div>
				<!-- /board -->
			</div>
			<!-- /c_box -->
		</div>
		<!-- /content -->



		<div id="footer">
			<div id="footer">
				<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
			</div>
		</div>
		<!-- /footer -->
	</div>
	<!-- /container -->
</body>
</html>

