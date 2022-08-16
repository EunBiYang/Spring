<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${result > 0 }) {
		alert("가게 등록에 성공하였습니다.");
		location.href = "storeboardList.do?pg=1";
	} else {
		alert("가게 등록에 실패했습니다.");
		location.href = "storeboardWriteForm.do";
	}
</script>
</head>
<body>
   
</body>
</html>