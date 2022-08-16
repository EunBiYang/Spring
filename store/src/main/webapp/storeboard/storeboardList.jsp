<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 <div class="store_list_container">
        <div class="list_search_area">
            <input type="text" class="store_list_search" value="'위치' 근처 동네 가게" >
       </div>
        
        <nav class="navbar bg-light">
  <div class="container-fluid">
    <form name="searchFrm" method="post" action="storeboardList.do" role="search">
      <img src="img/search.png" class="searchImg" >
      <select name="searchGubun" class="form-control me-2">
         <option value="storeName">가게 이름</option>
         <option value="storePlace">가게 위치</option>
         <option value="storeCategory">가게 카테고리</option>
      </select>
      <input class="form-control me-2" type="search" name="searchText" placeholder="검색" aria-label="Search">
      <button class="btn btn-outline-success" type ="submit">검색</button>
    </form>
  </div>
</nav>
        
       <button><a href="">전체</a></button>
       <button><a href="${dto.storeCategory}">미용</a></button>	
       <button><a href="${dto.cafe}">카페</a></button>	
       <button><a href="${dto.food}">음식</a></button>			
        
         
       
           
             <c:forEach var="dto" items="${list}">
                <table  border="0">
                 <tr>
            <td rowspan="2"><a href="../storeboard/storeboardView.do?seq=${dto.seq}&pg=${pg}">
            <img src="../storage/${dto.image1}" width="50" height="50" border-radius: 5px;></a></td>
            <td>이름: ${dto.storeName} (${dto.storeCategory})</td> 
            </tr>
            <tr>
            <td>위치:${dto.storePlace}</td>
         </tr>
         </table> 
     </c:forEach>  
   <!-- 페이징 -->
		<tr>
			<td colspan="2" align="center">
				<c:if test="${startPage > 3}">
					<a class ="paging" href="storeboardList.do?pg=${startPage-1}">[이전]</a>
				</c:if>
				
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i == pg }">
						<a class="currentPaging" href="storeboardList.do?pg=${i }">[${i}]</a>
					</c:if>
					<c:if test="${i != pg }">
						<a class="paging" href="storeboardList.do?pg=${i}">[${i}]</a>
					</c:if>
			   </c:forEach>
				
				<c:if test="${endPage < totalP}">
					<a class ="paging"   href="storeboardList.do?pg=${endPage+1}">[다음]</a>
				</c:if>
			</td>
		</tr>
		</div>
    <footer class="common_bottom" >
        <div class="common_bottom_home" onclick="location.href ='main'" >
            <img src="img/home.png" alt="home" class="common_home_img_btn" >
            <input type="text" value="홈" class="common_button_home_text" >
        </div>
        <div class="common_bottom_mypage" onclick="location.href =''" >
            <img src="img/myPage.png" alt="myPage" class="common_mypage_img_btn" >
            <input type="text" value="나의 물품" class="common_button_mypage_text" >
        </div>
    </footer>

</body>
</html>