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

//        ArticleService articleService = new ArticleService();
//        ArticleTypeService articleTypeService = new ArticleTypeService();
//
//        //2.1 检查文章是否为空
//        if (request.getParameter("articleName").equals("")) {
//            request.setAttribute("article", article);
//            request.setAttribute("userName", userName);
//            request.setAttribute("errorMessage", "文章名不能为空！");
//            //获取文章类型列表
//
//            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
//            System.out.println(articleTypeList);
//            request.setAttribute("articleTypeList", articleTypeList);
//
//            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
//            return;
//        }
//        System.out.println(request.getParameter("articleTypeName"));
////        检查文章类型是否存在
//        if (request.getParameter("articleTypeName")==null) {
//            request.setAttribute("article", article);
//            request.setAttribute("userName", userName);
//            request.setAttribute("errorMessage", "文章类型不能为空！");
//            //获取文章类型列表
//            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
//            System.out.println(articleTypeList);
//            request.setAttribute("articleTypeList", articleTypeList);
//
//            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
//            return;
//        }
//
//        //3.-1 检查文章内容是否存在
//        if (request.getParameter("articleContent").equals("")) {
//            request.setAttribute("article", article);
//            request.setAttribute("userName", userName);
//            request.setAttribute("errorMessage", "文章内容不能为空！");
//            //获取文章类型列表
//            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
//            System.out.println(articleTypeList);
//            request.setAttribute("articleTypeList", articleTypeList);
//
//            request.getRequestDispatcher("/addArticle.jsp").forward(request, response);
//            return;
//        }

        //3. 新加文章
//        article = articleService.addArticle(article);
        HelpRequestService helpRequestService = new HelpRequestService();
        helpRequestService.addHelpRequest(helpRequest);

        response.sendRedirect("manageMyHelpRequests");

    }

}
