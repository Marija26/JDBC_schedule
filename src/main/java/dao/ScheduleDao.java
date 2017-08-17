package dao;

import model.Schedule;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {

    private Connection connection;

    public ScheduleDao() {
        connection = DBUtil.getConnection();
    }

    public void addSchedule(Schedule schedule) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO schedule(suserId, startless, endLess, subject ) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, schedule.getSuserId());
            preparedStatement.setTimestamp(2, new Timestamp(schedule.getStartLess().getTime()));
            preparedStatement.setTimestamp(3, new Timestamp(schedule.getEndLess().getTime()));
            preparedStatement.setString(4, schedule.getSubject());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSchedule(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM schedule WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSchedule(Schedule schedule) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE schedule SET  startless = ?, endless= ?, subject = ? WHERE id = ?");
            preparedStatement.setTimestamp(1, new Timestamp(schedule.getStartLess().getTime()));
            preparedStatement.setTimestamp(2, new Timestamp(schedule.getEndLess().getTime()));
            preparedStatement.setString(3, schedule.getSubject());
            preparedStatement.setInt(4, schedule.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Schedule> getAllpoints(int suserId) { // TODO: 03.08.2017 Изменить реализацию
        List<Schedule> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM schedule WHERE suserid = ?");
            ps.setInt(1, suserId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setStartLess(rs.getTimestamp("startLess"));
                schedule.setEndLess(rs.getTimestamp("endLess"));
                schedule.setSubject(rs.getString("subject"));
                schedule.setSuserId(rs.getInt("suserId"));

                list.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Schedule getScheduleById(int id, int suserId) {
        Schedule schedule = new Schedule();
        schedule.setSuserId(suserId);
        try {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM schedule WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                schedule.setId(rs.getInt("id"));
                schedule.setSuserId(rs.getInt("suserId"));
                schedule.setStartLess(rs.getTimestamp("startLess"));
                schedule.setEndLess(rs.getTimestamp("endLess"));
                schedule.setSubject(rs.getString("subject"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }
}
