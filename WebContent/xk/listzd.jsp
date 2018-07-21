<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>九江职业大学校园风景</title>
<style type="text/css">
.top {
	width: 100%;
	height: 60px;
	font-size: 35px;
	text-align: center;
	line-height: 60px;
	font-family: "PingFang SC", "Hiragino Sans GB", "Microsoft Yahei";
	color: rgb(93, 169, 249);
}

a {
	text-decoration: none;
	font-family: "PingFang SC", "Hiragino Sans GB", "Microsoft Yahei";
	font-size: 13px;
	color: black;
}

a:hover {
	color: rgb(93, 169, 249);
	text-decoration: none;
}

img {
	width: 295px;
	height: 200px;
}
img:click {
    position: relative;
    transform: scale(1.9);
	transition: all 2s; 
}
</style>


<body>
	<div class="top">
		<b>九江职业大学校园风景</b>
	</div>
	<!-- 遍历Map集合 -->
	<c:forEach var="me" items="${fileNameMap}">
		<c:url value="download_zd" var="downurl">
			<c:param name="fileName" value="${me.key}"></c:param>
		</c:url>
				
		<a href="${downurl}"><img id="img1" src="/pic/zd/${me.value} "title="单击图片下载"></a>
	</c:forEach>
</body>
</html>