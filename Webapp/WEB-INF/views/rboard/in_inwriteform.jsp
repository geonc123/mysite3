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
			<h1>MySite</h1>
			
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

			
		</div><!-- /header -->
	
		<div id="navigation">
			<ul>

				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div><!-- /navigation -->
		
		<div id="content">
			<div id="c_box">
				<div id="board">
					<h2>게시판-등록</h2>					
					<form class="board-form" method="post" action="${pageContext.request.contextPath}/rboard/in_inwrite">
						<table class="tbl-ex">
							<tr>
							<input type="text" name="user_no" value="${sessionScope.authUser.no }"></td>
								<th colspan="2">글쓰기</th>
							<input type="text" name="order_no" value="${param.order_no }"></td>
							<input type="text" name="group_no" value="${param.group_no }"></td>
							<input type="text" name="depth" value="${param.depth }"></td>
							</tr>
							<tr>
								<td class="label">제목</td>
								<td><input type="text" name="title" value=""></td>
							</tr>
							<tr>
								<td class="label">내용</td>
								<td>
									<textarea id="content" name="content"></textarea>
								</td>
							</tr>
						</table>
						<div class="bottom">
							<a href="${pageContext.request.contextPath}/rboard/list">취소</a>
							<input type="submit" value="등록">
						</div>
					</form>	
					
				</div><!-- /board -->
			</div><!-- /c_box -->
		</div><!-- /content -->
			
			
			
		<div id="footer">
			<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div>
		</div><!-- /footer -->
	</div><!-- /container -->
</body>
</html>

