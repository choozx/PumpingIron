package com.fp.pi.calendar;

import java.util.List;

public interface CalendarMapper {

	int recordRoutine(RoutineBean r);

	List<RoutineBean> showRoutine();

}
