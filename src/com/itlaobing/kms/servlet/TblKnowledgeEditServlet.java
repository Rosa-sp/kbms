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
import java.util.Arrays;

/**
 * @Classname TblKnowledgeEditServlet
 * @Description TODO()
 * @Date 2019/11/24 17:34
 * @Author by Alex
 */
@WebServlet("/edit")
public class TblKnowledgeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        TblKnowledgeService service = new TblKnowledgeService();

        HttpSession session = req.getSession();

        int id = Integer.parseInt((String) session.getAttribute("id"));

        TblKnowledgeModel model = service.findById(id);

        String title = req.getParameter("title");
        int isPublish = Integer.parseInt(req.getParameter("isPublish")) ;
        String[] fromName = req.getParameterValues("fromName");
        int typeld = Integer.parseInt(req.getParameter("typeld"));
        String content = req.getParameter("content");

        model.setTitle(title);
        model.setIsPublish(isPublish);
        String str = Arrays.toString(fromName);
        String s = str.replace("[","");
        String s1 = s.replace("]","");
        String s2 = s1.replace(",","、");
        model.setFromName(s2);
        model.setTypeld(typeld);
        model.setContent(content);

        int row = service.update(model);

        if(row > 0){
            req.getRequestDispatcher("delete.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("fiald.jsp").forward(req,resp);
        }

    }
}
