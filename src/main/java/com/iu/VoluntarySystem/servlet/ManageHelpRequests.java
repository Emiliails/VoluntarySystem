package com.iu.VoluntarySystem.servlet;

import com.iu.VoluntarySystem.entity.HelpRequest;
import com.iu.VoluntarySystem.service.HelpRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/manageHelpRequests")
public class ManageHelpRequests extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int volunteerTeamId = (int) request.getSession().getAttribute("volunteerTeamId");

        HelpRequestService helpRequestService = new HelpRequestService();
        List<HelpRequest> helpRequests= helpRequestService.findSelectableHelpRequest();
        request.setAttribute("helpRequests",helpRequests);

        request.getRequestDispatcher("/manageHelpRequests.jsp").forward(request, response);
    }

}
