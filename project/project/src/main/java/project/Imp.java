package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Imp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("name");
		String parameter2 = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		writer.println(parameter+parameter2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("google");
		EntityManager createEntityManager = emf.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
	    Login l=new Login();
	    l.setUsername(parameter);
	    l.setPassword(parameter2);
	    createEntityManager.persist(l);
		transaction.commit();
		
		
	}

}
