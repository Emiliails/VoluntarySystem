package com.iu.VoluntarySystem.servlet;

import com.iu.VoluntarySystem.service.HelpRequestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectHelpRequest")
public class SelectHelpRequest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int volunteerTeamId = (int) request.getSession().getAttribute("volunteerTeamId");
        int helpRequestId = Integer.parseInt(request.getParameter("helpRequestId"));
        HelpRequestService helpRequestService = new HelpRequestService();
        helpRequestService.volunteerTeamSelectHelpRequest(volunteerTeamId,helpRequestId);

        response.sendRedirect("manageHelpRequests");

    }

}