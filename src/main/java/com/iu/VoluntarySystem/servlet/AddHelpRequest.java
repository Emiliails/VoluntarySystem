package com.iu.VoluntarySystem.servlet;

import com.iu.VoluntarySystem.entity.HelpRequest;
import com.iu.VoluntarySystem.service.HelpRequestService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addHelpRequest")
public class AddHelpRequest extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int helpSeekerId = (int) request.getSession().getAttribute("helpSeekerId");
        request.setAttribute("helpSeekerId", helpSeekerId);


        request.getRequestDispatcher("/addHelpRequest.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String helpSeekerId = request.getParameter("helpSeekerId");

        HelpRequest helpRequest = new HelpRequest();
        helpRequest.setHelpSeekerId(Integer.parseInt(request.getParameter("helpSeekerId")));
        helpRequest.setHelpRequestCreateTime(request.getParameter("helpRequestCreateTime"));
        helpRequest.setHelpRequestLocation(request.getParameter("helpRequestLocation"));
        helpRequest.setHelpRequestContent(request.getParameter("helpRequestContent"));

        //2. 检查数据


        HelpRequestService helpRequestService = new HelpRequestService();
        helpRequestService.addHelpRequest(helpRequest);

        response.sendRedirect("manageMyHelpRequests");

    }

}
