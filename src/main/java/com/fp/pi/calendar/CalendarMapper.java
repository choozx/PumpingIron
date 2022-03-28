package com.fp.pi.calendar;

import java.util.List;

import com.fp.pi.infomap.InfoMapBean;

public interface CalendarMapper {

	public int recordRoutine(RoutineBean r);

	public List<RoutineBean> showRoutine(RoutineBean r);

	public int delRoutine(RoutineBean r);
	
	/////////////////////////////////////////////////////
	
	public int regSchedule(ContestBean c);
	
	public List<ContestBean> contestSchedule();

	public int delSchedule(ContestBean c);

	public List<ContestDetailBean> detailSchedule(ContestDetailBean cd);

	public List<ContestDetailBean> detailSchedule2();

	public int regSchduleDetail(ContestDetailBean cd);

	public int delScheduleDetail(ContestDetailBean cd);

}
