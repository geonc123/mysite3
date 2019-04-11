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
					<form action="${pageContext.request.contextPath}/board/search" method="post">
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
						<c:forEach items="${guestList}" var="vo" varStatus="status">
							<tr>
								<td>${vo.no }</td>
								<td><a href="${pageContext.request.contextPath}/board/read/${vo.no}">${vo.title}</a></td>
								<td>${vo.name}</td>
								<td>${vo.hit }</td>
								<td>${vo.reg_date}</td>
								<td><c:if test="${vo.user_no eq sessionScope.authUser.no}">
										<a href="${pageContext.request.contextPath}/board/delete/${vo.no}" class="del">삭제</a>
									</c:if></td>
							</tr>
						</c:forEach>

					</table>

							<div class="pager">
								<ul>
									<li><c:choose>
											<c:when test="${pageno>1}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno-1 }">◀</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno>3}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno-3 }">${pageno-3 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno>2}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno-2 }">${pageno-2 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno>1}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno-1 }">${pageno-1 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li class="selected"><a href="${pageContext.request.contextPath}/board/list/${pageno }">${pageno }</a></li>

									<li><c:choose>
											<c:when test="${pageno+1<=maxPage}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno+1 }">${pageno+1 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno+2<=maxPage}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno+2 }">${pageno+2 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno+3<=maxPage}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno+3 }">${pageno+3 }</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>
									<li><c:choose>
											<c:when test="${pageno+1<=maxPage}">
												<a href="${pageContext.request.contextPath}/board/list/${pageno+1 }">▶</a>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose></li>

								</ul>
							</div>
					<div class="pager"></div>
					<div class="bottom">
						<c:if test="${sessionScope.authUser != null }">
							<a href="${pageContext.request.contextPath}/board/writeform" id="new-book">글쓰기</a>
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

