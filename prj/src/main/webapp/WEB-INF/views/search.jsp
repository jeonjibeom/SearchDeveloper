<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언 -->
<!-- 현재 이 JSP 페이지 실행 후 실행되는 문서는 HTML이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정-->
<!-- 현재 이 JSP 페이지를 저장할 때는 UTF-8 방식으로 인코딩한다. -->
<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->

<!-- <참고> 이 JSP 페이지는 위와 같은 방식으로 처리하라고 설정하는 것 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여 common.jsp 파일 내의 소스를 삽입하기 -->
<!-- <참고> 1개 이상 여러 개를 수입할 수 있음. -->

<!-- ※ include Directive : 현재 JSP 페이지에 다른 JSP 페이지 코드를 삽입할 때 사용 -->
<%-- <%@include file="/WEB-INF/views/common.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개발자 검색</title>

<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/common.js"></script>

<script>
	$(function(){
	    search();
	 })
	function search(){
		//alert("123");

		ajax(
			// WAS 에 접속할 때 사용할 URL 주소 지정
			"/search.do"
			// WAS 에 전송할 파라미터값을 보내는 방법 지정
			, "post"
			// 파라미터값을 내포한 form 태그 관리하는 JQuery 객체
			, $("[name='boardSearchForm']")
			// WAS 와 통신한 후 WAS의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명 함수의 매개변수에는 WAS가 보내온 HTML 문자열이 들어온다.
			, function(responseHtml) {
				var obj = $(responseHtml);
				//$(".test").text(responseHtml);
				//alert("${developerListMap.developerList[0].DEVELOPER_NAME}") 
				//alert("${skillListMap}")
				var searchResult = obj.find(".searchResult").html();
				var pageNos = obj.find(".pageNos").html();
				
				
				$(".searchResult").html(searchResult);
				$(".pageNos").html(pageNos);
			});
	}
	
	function searchAll(){
		$(".reset").click();
		search();
	}
	
	function input(){
		location.replace("/input.do")
	}
	function updel(developer_no){
		$(".updelInfo").val(developer_no);
		
		document.upDelForm.submit();
	}
	

	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	//[페이지 번호] 클릭하면 호출되는 함수 clickPageNo 선언
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	function pageNoClick(clickPageNo //클릭한 번호가 들어오는 매개변수
	) {
		//변수 formObj선언하고 name='boardSearchForm' 를 가진 form태그 관리 JQuery객체 저장
		var formObj = $("[name='boardSearchForm']")
		//name='selectPageNo'를 가진 태가 value값에 매개변수로 들어오는 [클릭한 페이지] 번호 저장
		//즉 <input type="hidden" name="selectPageNo" value="1"> 태그에 
		//		value값에  [클릭한 페이지 번호]를 저장하기.
		formObj.find("[name='selectPageNo']").val(clickPageNo);
		//search함수 호출하기.
		search();
	}
	
	
</script>



</head>

<body>
<!-- <textarea rows="100" cols="100" class="test"></textarea> -->


<center>
<form name="boardSearchForm" action="/search.do" method="post">
		<table border="1" bordercolor="#c3c3c3"
			style="border-collapse: collapse; width:100%;" cellpadding="7" align="center">
			<caption>개발자통합검색</caption>
			<tr>
				 <td colspan='6'>사원 정보 검색</td>
				<!-- 
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				 -->
			</tr>
			<tr>
				<td width="50px">키워드</td>
				<td width="50px">
					<input type="text" name="keyword">
				</td>
				<td width="50px">성별</td>
				<td width="50px">
					<input type="checkbox" name="sex" value="1" >남
					<input type="checkbox" name="sex" value="2" >녀
				</td>
				<td width="50px">종교</td>
				<td width="50px">
					<select name="religion_name">
						<option value=""></option>
						<option value="1">기독교</option>
						<option value="2">천주교</option>
						<option value="3">불교</option>
						<option value="4">이슬람</option>
						<option value="5">무교</option>
						
					</select>
				</td>
			</tr>
			<tr>
				<td width="50px">학력</td>
				<td width="50px">
					<input type="checkbox" name="school_name" value="1" >고졸
					<input type="checkbox" name="school_name" value="2" >전문대졸
					<input type="checkbox" name="school_name" value="3" >일반대졸
				</td>
				<td width="50px">기술</td>
				<td colspan='3'>
					<input type="checkbox" name="skill_name" value="1" >java
					<input type="checkbox" name="skill_name" value="2" >jsp
					<input type="checkbox" name="skill_name" value="3" >asp
					<input type="checkbox" name="skill_name" value="4" >php
					<input type="checkbox" name="skill_name" value="5" >delphi
				</td>
				<!-- 
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
			</tr>
			<tr>
				<td width="50px">졸업일</td>
				<td colspan='5'>
					<select name="graduate_day">
						<option value="000"></option>
						<c:forEach varStatus="vs" begin="1950" end="2024">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>년			
					
					<select name="graduate_day">
						<option value="0"></option>
						<c:forEach varStatus="vs" begin="1" end="12">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>월
					
					<select name="graduate_day">
						<option value="0"></option>
						<c:forEach varStatus="vs" begin="1" end="31">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>일	
					
					
					~
					
					
					<select name="graduate_day2">
						<option value="2100"></option>
						<c:forEach varStatus="vs" begin="1950" end="2024">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>년			
					
					<select name="graduate_day2">
						<option value="12"></option>
						<c:forEach varStatus="vs" begin="1" end="12">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>월
					
					<select name="graduate_day2">
						<option value="31"></option>
						<c:forEach varStatus="vs" begin="1" end="31">
							<option value="${vs.index}">${vs.index}</option>
						</c:forEach>
					</select>일			
					
					
				</td>
				<!--
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
			</tr>
			<tr>
				<td colspan='3'>
					<input type="button" value="검색" onClick="search()">
				</td>
				<!--
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
				<td colspan='3'>
					<input type="button" value="전부검색" onClick="searchAll()">
					<input type="reset" class="reset" value="초기화" >
					<input type="button" value="등록" onClick="input()">
				</td>
				<!--
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
			</tr>
		</table>
			
		<div style="height: 20px;"></div>
	
	
	    <!-- 검색 결과 부분 -->
	    <div class="searchResult">
			<table border="1" bordercolor="#c3c3c3"
				style="border-collapse: collapse; width:100%;" cellpadding="7" align="center">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>성별</td>
					<td>종교</td>
					<td>기술</td>
					<td>졸업일</td>
					<td>수정/삭제</td>
				</tr>
				
				<c:forEach var="map" items="${developerListMap.developerList}" varStatus="vs" step="1">
					<tr>
					
						<td>${developerListMap.begin_serialNo_asc+vs.index}</td>
						<td>${map.DEVELOPER_NAME}</td>
						<td>${map.sex}</td>
						<td>${map.RELIGION_NAME}</td>
						
						<td>

							<c:forEach var="map1" items="${skillListMap}" varStatus="vs" step="1">
								<c:if test="${map.DEVELOPER_NAME==map1.DEVELOPER_NAME}">
									${map1.SKILL_NAME}
								</c:if>
								
							</c:forEach>
			
						</td>
						
						<td>${map.GRADUATE_DAY}</td>
						<td><input type="button" value="수정/삭제" onClick="updel('${map.DEVELOPER_NO}')"></td>
										
					</tr>
				</c:forEach>

				</table>
				

		</div>
		   <!-- mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm -->
   <!-- 게시판 페이징 번호 출력하기 -->
   <!-- mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm -->
    <div class="pageNos">
    
    
    	
    	<!-- [처음] [이전] 출력 -->
    	<span style="cursor:pointer" onClick="pageNoClick(1)">[처음]</span>
    	<span style="cursor:pointer" onClick="pageNoClick(${requestScope.developerListMap.selectPageNo}-1)">[이전]</span>&nbsp;&nbsp;
    	
    	
    	<!-- [반복문 C코어 태그]를 사용하여 페이지 번호 출력하기 -->
    	<c:forEach var="pageNo" begin="${requestScope.developerListMap.begin_pageNo }" end="${requestScope.developerListMap.end_pageNo}">
    	
    			<!-- 만약 선택한 페이지 번호와 화면에 출력할 페이지 번호가 같으면 -->
    			<c:if test="${requestScope.developerListMap.selectPageNo==pageNo}">
    				${pageNo}
    			</c:if>
    			
    			<!-- 만약 선택한 페이지 번호와 화면에 출력할 페이지 번호가 다르면 -->
    			<c:if test="${requestScope.developerListMap.selectPageNo!=pageNo}">
    				<span style="cursor:pointer" onClick="pageNoClick(${pageNo})">[${pageNo}]</span>
    			</c:if>
    	</c:forEach>
    	
    	<span style="cursor:pointer" onClick="pageNoClick(${requestScope.developerListMap.selectPageNo}+1)">[다음]</span>
    	<span style="cursor:pointer" onClick="pageNoClick(${requestScope.developerListMap.last_pageNo})">[마지막]</span>
    			
    
    </div>
			<!-- ------------------------------------ -->
			<!-- 선택한 페이지 번호가 저장되는 입력양식 태그 선언 -->
			<input type="hidden" name="selectPageNo" value="1">
			<!-- ------------------------------------ -->
			<!-- 선택한 페이지 번호가 저장되는 입력양식 태그 선언 -->
			<input type="hidden" name="rowCntPerPage" value="5">
			<!-- ------------------------------------ -->
</form>
</center>	

<!-- updelForm으로 개발자 고유 번호를 넘기기 위한 폼태그 설정. -->
<form name="upDelForm" method="post" action="/updel.do" >
	<input type="hidden" class="updelInfo" name="developer_no">
</form>
	
</body>

</html>

<!-- form, input, select, textarea 태그만 백엔드에서 중요 -->