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
<title>aaa</title>

<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/common.js"></script>

<script>
	
	function input(){
		
		document.inputForm.submit();
	}
	function deleteDeveloper(){
		//alert("123");
		document.deleteDeveloperForm.submit();
	}
	

</script>


</head>

<body>
<!-- <textarea rows="100" cols="100" class="test"></textarea> -->


<center>
<form name="inputForm" action="/updel.do" method="post" >
		<table border="1" bordercolor="#c3c3c3"
			style="border-collapse: collapse; width:100%;" cellpadding="7" align="center">
			<caption>[수정]</caption>
			<tr>
				 <td colspan='6'>사원 정보 수정</td>
				<!-- 
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				<td width="50px">1</td>
				 -->
			</tr>
			<tr>
				<td width="50px">이름</td>
				<td width="50px">
					<input type="text" name=developer_name>
				</td>
				<td width="50px">주민번호</td>
				<td width="50px">
					<input type="text" name="jumin_no"  style="width: 80px;"> ~
					<input type="password" name="jumin_no"  style="width: 80px;">
				</td>
				<td width="50px">종교</td>
				<td width="50px">
					<select name="religion_code">
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
					<input type="radio" name="school_code" value="1">고졸
					<input type="radio" name="school_code" value="2">전문대졸
					<input type="radio" name="school_code" value="3">일반대졸
				</td>
				<td width="50px">기술</td>
				<td colspan='3'>
					<input type="checkbox" name="skill_code" value="1" >java
					<input type="checkbox" name="skill_code" value="2" >jsp
					<input type="checkbox" name="skill_code" value="3" >asp
					<input type="checkbox" name="skill_code" value="4" >php
					<input type="checkbox" name="skill_code" value="5" >delphi
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
					<input type="button" value="수정" onClick="input()">
				</td>
				<!--
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
				<td colspan='3'>
					
					<input type="button" value="삭제" onClick="deleteDeveloper()">
					
				</td>
				<!--
				<td width="50px">1</td>
				<td width="50px">1</td>
				-->
			</tr>
		</table>
			
		
	
	
				</table>

		</div>
	<input type="hidden" value="${developer_no}" name="developer_no">
</form>
</center>	
<form name="deleteDeveloperForm" action="/del.do" method="post" >
	<input type="text" value="${developer_no}" name="developer_no">
</form>
</body>

</html>

<!-- form, input, select, textarea 태그만 백엔드에서 중요 -->