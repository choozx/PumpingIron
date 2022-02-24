<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>Calendar</title>
</head>
<body>
	<div class="main">
		<div class="content-wrap">
			<div class="content-left">
				<div class="main-wrap" style="color: white;">
					<div id="main-day" class="main-day" style="color: white;"></div>
					<div id="main-date" class="main-date" style="color: white;"></div>
				</div>
				<div class="todo-wrap">
					<div class="todo-title" style="color: white;"> 루틴 기록 </div>
					<div class="input-wrap">
						<input type="text" placeholder=" today's routine "
							id="input-box" class="input-box">
						<button type="button" id="input-data" class="input-data">기록</button>
						<div id="input-list" class="input-list" ></div>
					</div>
				</div>
			</div>
			
			<div class="content-right">
				<table id="calendar" align="center">
					<thead>
						<tr class="btn-wrap clearfix">
							<td><label id="prev"> &#60; </label></td>
							<td align="center" id="current-year-month" colspan="5"></td>
							<td><label id="next"> &#62; </label></td>
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