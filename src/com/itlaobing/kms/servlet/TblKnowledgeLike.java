package com.itlaobing.kms.servlet;

import com.itlaobing.kms.models.TblKnowledgeModel;
import com.itlaobing.kms.services.TblKnowledgeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname TblKnowledgeLike
 * @Description TODO()
 * @Date 2019/11/25 20:16
 * @Author by Alex
 */
@WebServlet("/like")
public class TblKnowledgeLike extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name =  req.getParameter("search");

        TblKnowledgeService service = new TblKnowledgeService();

        List<TblKnowledgeModel> list = new ArrayList<TblKnowledgeModel>();

        list =  service.likeFind(name);

        HttpSession session = req.getSession();

        session.setAttribute("list",list);

        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

}
