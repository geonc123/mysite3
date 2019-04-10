<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">
		
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
				<div id="guestbook" class="deleteform">
					<h2>방명록삭제</h2>

					<form class="form-box" method="post" action="${pageContext.request.contextPath}/guestbook/delete">
						<div class="form-group">
							<label class="block-label">비밀번호</label> 
							<input type="password"name="password" value=""> 
							<input type="text" name="no" value="${vo.no }">
						</div>

						<input type="submit" value="확인">
					</form>
					<a href="${pageContext.request.contextPath}/guestbook/addList">방명록 리스트</a>

				</div>
				<!-- /guestbook -->
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