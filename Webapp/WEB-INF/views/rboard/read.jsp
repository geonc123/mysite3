<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
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
				<div id="board" class="board-form">
					<h2>게시판-보기</h2>

					<table class="tbl-ex">
						<tr>
							<th colspan="2">글보기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td>${getList.title }</td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<div class="view-content">${getList.content }</div>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="${pageContext.request.contextPath}/rboard/list">글목록</a>
						<c:if test="${getList.user_no == sessionScope.authUser.no}">
							<a href="${pageContext.request.contextPath}/rboard/modifyform?no=${getList.no}">글수정</a>
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


