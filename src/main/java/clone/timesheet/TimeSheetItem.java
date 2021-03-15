package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem timeSheetItem) {
        employee = timeSheetItem.employee;
        project = timeSheetItem.project;
        from = LocalDateTime.of(timeSheetItem.from.getYear(), timeSheetItem.from.getMonth(), timeSheetItem.from.getDayOfMonth(), timeSheetItem.from.getHour(), timeSheetItem.from.getMinute());
        to = LocalDateTime.of(timeSheetItem.to.getYear(), timeSheetItem.to.getMonth(), timeSheetItem.to.getDayOfMonth(), timeSheetItem.to.getHour(), timeSheetItem.to.getMinute());
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate differentDay) {
        TimeSheetItem result = new TimeSheetItem(timeSheetItem);
        result.setFrom(LocalDateTime.of(differentDay, timeSheetItem.from.toLocalTime()));
        result.setTo(LocalDateTime.of(differentDay, timeSheetItem.to.toLocalTime()));
        return result;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
