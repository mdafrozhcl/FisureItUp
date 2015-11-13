package com.wglen.fisure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class loginServ
 */
public class loginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		Properties p = new Properties();
		p.load(new FileInputStream(Thread.currentThread()
				.getContextClassLoader()
				.getResource("hibernate.properties").getPath()));
		cfg.addProperties(p);
		SessionFactory sf = cfg.buildSessionFactory();
		
		String username = request.getParameter("uname");
		String pass = request.getParameter("pass");
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("from FIU_User where uname =:uname and pass = :pass");
		q.setParameter("uname", username);
		q.setParameter("pass", pass);
		List<FIU_User> l = q.list();
		
		for(FIU_User u: l){
			if(u.getUname().equals(username) && u.getPass().equals(pass)){
				System.out.println("Authenticated user");
				HttpSession session = request.getSession();
				session.setAttribute("hib_session", s);
				session.setAttribute("username", username);
				session.setAttribute("u_id", u.getUid());
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			}
		}
	}

}
