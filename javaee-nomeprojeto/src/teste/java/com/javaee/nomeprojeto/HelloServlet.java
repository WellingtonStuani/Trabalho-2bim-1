package com.javaee.nomeprojeto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = { "/principal"})
public class HelloServlet extends HttpServlet{
	
	List<Pessoa> lista  = new ArrayList<Pessoa>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = req.getParameter("nome");
		Pessoa p = new Pessoa();
		p.setNome(nome);
		lista.add(p);
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>Meu Servlet</title>");					
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h2> Listar pessoas </h2>");
		for (Pessoa pessoa : lista) {
			out.println("<p>nome: "+ pessoa.getNome() + "</p>");	
			
		}
			
		out.println("</body>");
		out.println("</html>");
	
		out.close();
		
	}

}
