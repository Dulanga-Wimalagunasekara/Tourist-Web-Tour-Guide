package sliit.oop.tour.sliitoop.controller;

import sliit.oop.tour.sliitoop.dao.StaffDAO;
import sliit.oop.tour.sliitoop.service.ServiceFactory;
import sliit.oop.tour.sliitoop.service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "staffServlet", value = "/staff-servlet")
public class StaffServlet extends HttpServlet {

    private final StaffService staffService;

    public StaffServlet() {
        staffService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.STAFF);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String staffId = req.getParameter("staffId");
        StaffDAO staffMember = staffService.getUserById(staffId);
        req.setAttribute("staffMember", staffMember);
        req.getRequestDispatcher("/users-profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!Boolean.parseBoolean(req.getParameter("loginCredentialsUpdate"))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                StaffDAO staffDAO = new StaffDAO(Integer.parseInt(req.getParameter("staffId")), req.getParameter("firstname"), req.getParameter("lastname"),
                        dateFormat.parse(req.getParameter("dob")), req.getParameter("address"), req.getParameter("email"),
                        req.getParameter("role"), null, null);

                StaffDAO member = staffService.saveStaff(staffDAO);
                req.setAttribute("staffMember", member);
                req.getRequestDispatcher("/users-profile.jsp").forward(req, resp);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        staffService.deleteById(Integer.parseInt(req.getParameter("memberId")));
        req.getRequestDispatcher("/users-profile.jsp").forward(req, resp);
    }
}
