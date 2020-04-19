package com.itlaobing.kms.servlet;

import com.itlaobing.kms.models.TblKnowledgeModel;
import com.itlaobing.kms.services.TblKnowledgeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Classname TblKnowledgeAddServlet
 * @Description TODO()
 * @Date 2019/11/24 16:21
 * @Author by Alex
 */
@WebServlet("/add")
public class TblKnowledgeAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String title = req.getParameter("title");
        int isPublish = Integer.parseInt(req.getParameter("isPublish")) ;
        String[] fromName = req.getParameterValues("fromName");
        int typeld = Integer.parseInt(req.getParameter("typeld"));
        String content = req.getParameter("content");

        TblKnowledgeModel model = new TblKnowledgeModel();

        model.setTitle(title);
        model.setIsPublish(isPublish);
        String str = Arrays.toString(fromName);
        String s = str.replace("[","");
        String s1 = s.replace("]","");
        String s2 = s1.replace(", ","、");
        model.setFromName(s2);
        model.setTypeld(typeld);
        model.setContent(content);

        TblKnowledgeService service = new TblKnowledgeService();

        int z = service.add(model);

        if(z > 0){
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        }else {
            resp.getWriter().print("添加失败");
        }
    }
}
