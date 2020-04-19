package com.itlaobing.kms.servlet;

import com.itlaobing.kms.models.TblKnowledgeModel;
import com.itlaobing.kms.services.TblKnowledgeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname TblKnowledgeDeleteServlet
 * @Description TODO()
 * @Date 2019/11/25 11:56
 * @Author by Alex
 */
@WebServlet("/delete")
public class TblKnowledgeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TblKnowledgeService service = new TblKnowledgeService();
        int id = Integer.parseInt(req.getParameter("id"));

        int x = service.delete(id);

        if(x > 0){
            req.getRequestDispatcher("delete.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("fiald.jsp").forward(req,resp);
        }
    }
}
