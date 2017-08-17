package controller;

import dao.ScheduleDao;

import model.Schedule;
import model.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleController extends HttpServlet {
    private ScheduleDao dao;
    static int suserId;

    private static final String SCHEDULE_LIST = "scheduleList.jsp";
    private static final String SCHEDULE_EDIT = "scheduleEdit.jsp";
    private static final String USER_LIST = "userList.jsp";

    public ScheduleController() {
        this.dao = new ScheduleDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("schedule")) {
            suserId = Integer.parseInt(req.getParameter("suserId"));
            forward = SCHEDULE_LIST;
            req.setAttribute("schedules", dao.getAllpoints(suserId));
        } else if (action.equalsIgnoreCase("deleteSchedule")) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteSchedule(id);
            forward = SCHEDULE_LIST;
            req.setAttribute("schedules", dao.getAllpoints(suserId));
        } else if (action.equalsIgnoreCase("editSchedule")) {
            forward = SCHEDULE_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            Schedule schedule = dao.getScheduleById(id, suserId);
            req.setAttribute("schedule", schedule);
        } else {
            forward = SCHEDULE_EDIT;
            Schedule schedule = new Schedule();
            schedule.setSuserId(suserId);
            req.setAttribute("schedule", schedule);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
        Integer[] abs = new Integer[35];

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Schedule schedule = new Schedule();

        try {
            Date timestamp = new SimpleDateFormat("hh.mm").parse(req.getParameter("startLess"));
            schedule.setStartLess(timestamp);
            Date end = new SimpleDateFormat("hh.mm").parse(req.getParameter("endLess"));
            schedule.setEndLess((end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        schedule.setSubject(req.getParameter("subject"));
        int userId = Integer.parseInt(req.getParameter("suserId"));
        schedule.setSuserId(userId);
        String id = req.getParameter("id");
        int intId = 0;
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {

        }
        if (id == null || id.isEmpty() || intId == 0) {
            dao.addSchedule(schedule);
        } else {
            schedule.setId(Integer.parseInt(id));
            dao.updateSchedule(schedule);
        }

        RequestDispatcher rd = req.getRequestDispatcher(SCHEDULE_LIST);
        req.setAttribute("schedules", dao.getAllpoints(userId));
        rd.forward(req, resp);

    }
}


