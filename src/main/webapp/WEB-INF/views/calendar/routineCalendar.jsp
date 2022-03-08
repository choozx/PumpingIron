<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">

<link href="resources/css/calendar/routine.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">

<script type="text/javascript"
	src="resources/js/calendar/calendarTodo1.js"></script>
<script type="text/javascript"
	src="resources/js/calendar/calendarTodo2.js"></script>

<title>Calendar</title>
</head>
<body>
	<div class="main">
	
	 
		<div class="content-wrap bg-info" style="width: 62%;">
		
		
		
		
		<!-- -------------------------------Routine--------------------------- -->
		
			<div class="content-left">
				<div class="main-wrap" style="color: white;">
					<div id="main-day" class="main-day" style="color: white;"></div>
					<div id="main-date" class="main-date" style="color: white;"></div>
				</div>
					 
		
				<div class="todo-wrap">
					<div class="todo-title pt-3" style="color: white;"> 루틴 기록 </div>
					<div class="input-wrap">
					
						<%-- <span style="color: white;"> ${result} </span> <br> --%>
						<%-- <input name="cr_date" type="hidden" id="paramDate" value="${param.cr_date}"> 
						<input name="cr_id" type="hidden" id="paramId" value="${sessionScope.loginMember.m_email}">  --%>
						
				<c:if test="${sessionScope.loginMember == null}" >
				
				<input name="cr_date" type="hidden" id="paramDate" value=""> 
					<input type="text" placeholder="로그인을 해주세요." id="input-box" class="input-box">
					<button type="button" name="routineInsert"  class="input-data" onclick="return pleaseLogin_calendar()">기록</button>
				
				</c:if>
				
				
				
				
				<c:if test="${sessionScope.loginMember != null}" >
	
				
						<!-- <form action="routine.insert">
						</form> -->
						
						<input name="cr_id" type="hidden" id="paramId" value="${sessionScope.loginMember.m_email}"> 
						<input name="cr_date" type="hidden" id="paramDate" value="${param.cr_date}"> 
						
						<input name="cr_text"  type="text" placeholder=" 아래에 루틴이 기록됩니다 " id="input-box" class="input-box">
						<button id="input-data" class="input-data" >기록</button>
							
						
							<div style="color: white;" id="routineDIV"></div>
							
				
				</c:if> 
				
							
						<!-- <div id="input-list" class="input-list"></div> -->
						<input type="hidden" id="input-list" class="input-list">
							
					</div>
				</div>
					 
			</div>
			
			
			
			
			
			
			<!-- -------------------Calendar--------------------------  -->
			
			<div class="content-right" >
				<table id="calendar" class="ms-3" align="center" style="width: 600px;" >
					<thead>
						<tr class="btn-wrap clearfix" >
							<td id="prev" class="prev"><label  > &#60; </label></td>
							<td align="center" id="current-year-month" colspan="5"></td>
							<td class="next" id="next"><label > &#62; </label></td>
						</tr>
						<tr>
							<td class="sun" align="center">Sun</td>
							<td align="center">Mon</td>
							<td align="center">Tue</td>
							<td align="center">Wed</td>
							<td align="center">Thu</td>
							<td align="center">Fri</td>
							<td class="sat" align="center">Sat</td>
						</tr>
					</thead>
					<tbody id="calendar-body" class="calendar-body"></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>