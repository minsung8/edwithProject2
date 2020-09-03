package org.edwith.webbe.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String name = request.getParameter("name");
    	String content = request.getParameter("content");
    	Guestbook dto = new Guestbook(name, content);
    	GuestbookDao dao = new GuestbookDao();
    	dao.addGuestbook(dto);
    	
    	List<Guestbook> list = new ArrayList<Guestbook>();
    	list = dao.getGuestbooks();
    	
    	System.out.println(list.size());
    	for (int i=0; i<list.size(); i++) {
    		out.println("<html>");
    		out.println("<head><title>form</title></head>");
    		out.println("<body>");
    		out.println("<form method='get' action='/guestbook/guestbooks'>");
    		out.println("<h1>id :" + list.get(i).getId() + "</h1>");
    		out.println("<h1>name :" + list.get(i).getName() + "</h1>");
    		out.println("<h1>" + list.get(i).getContent() + "</h1>");
    		out.println("<h1>regdate :" + list.get(i).getRegdate() + "</h1>");
    		out.println("<h1>--------------------------------------------</h1>");
    		out.println("</form>");
    		out.println("</body>");
    		out.println("</html>");
    	}
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='get' action='/guestbook/guestbooks'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("content : <input type='comment' name='content'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    	
    }

}
