<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../script/storeRegistration.js"></script>
<script type="text/javascript" src="../script/storeboardScript.js"></script>
<script>
window.onload = function(){
    document.getElementById("storePlace").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("storePlace").value = data.address; // 주소 넣기
                
            }
        }).open();
    });
}
</script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="store_container">
    <form action="storeboardWrite.do" id="form" name="storeboardWriteForm"  enctype="multipart/form-data" method="post" >
       <h1 class="common_title">
        동네가게 등록하기
       </h1>
      
     <div class="image_area">
            <input type="file" id="image1" name="image1" accept="image/*" onchange="setThumbnail(event);" />
            <div class="image_container"></div>
            <!--가게 사진 등록-->
        </div>
        <!--가게 이름-->
        <div class="store_box">
            <input type="text" class="store_text" id="storeName" name="storeName" placeholder="가게이름"/>
        </div>
          <!--가게 위치-->
         <div class="store_box">
            <input type="text" class="store_text" id="storePlace" name="storePlace" placeholder="가게위치"/>
        </div>
          <!--가게 번호-->
         <div class="store_box">
            <input type="text" class="store_text" id="storeNum" name="storeNum" placeholder="가게 전화번호"/>
        </div>
          <!--가게 카테고리-->
        <div class="store_box">
            <select class="store_text" id="storeCategory" name="storeCategory" >
                <option value="" selected="selected">가게 카테고리</option>
                <option value="미용" id="hair" name="hair">미용</option>
                <option value="음식" id="food" name="food">음식</option>
                  <option value="카페" id="cafe" name="cafe">카페</option>
            </select>
        </div>
          <!--가게 소개-->
        <div>
            <input type="text" class="store_text_detail" id="storeContent" name="storeContent" placeholder="가게 소개 내용을 작성해주세요."/>
        </div>
        <button type="submit" class="store_save_button" id="store_save_button">가게 등록하기</button>
        <button type="reset" class="store_save_button" id="store_save_button">다시 작성</button>
    </form>
   </div>
</body>
</html>