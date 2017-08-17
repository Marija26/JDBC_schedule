package model;


import java.time.LocalDateTime;
import java.util.Date;

public class Schedule {

        private int id;
        private int suserId;
        private Date startLess;
        private Date endLess;
        private String subject;

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", suserId=" + suserId +
                ", startLess=" + startLess +
                ", endLess=" + endLess +
                ", subject='" + subject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (id != schedule.id) return false;
        if (suserId != schedule.suserId) return false;
        if (startLess != null ? !startLess.equals(schedule.startLess) : schedule.startLess != null) return false;
        if (endLess != null ? !endLess.equals(schedule.endLess) : schedule.endLess != null) return false;
        return subject != null ? subject.equals(schedule.subject) : schedule.subject == null;
    }

    @Override
    public int hashCode() {

        int result = id;
        result = 31 * result + suserId;
        result = 31 * result + (startLess != null ? startLess.hashCode() : 0);
        result = 31 * result + (endLess != null ? endLess.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuserId() {
        return suserId;
    }

    public void setSuserId(int suserId) {
        this.suserId = suserId;
    }

    public Date getStartLess() {
        return startLess;
    }

    public void setStartLess(Date startLess) {
        this.startLess = startLess;
    }

    public Date getEndLess() {
        return endLess;
    }

    public void setEndLess(Date endLess) {
        this.endLess = endLess;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}


