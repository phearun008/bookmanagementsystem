package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterBook implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletReponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) servletRequest;
		HttpServletResponse res =(HttpServletResponse) servletReponse;
		 
		HttpSession session = req.getSession();
		 if(session.getAttribute("user") != null){
			 System.out.println("User Logined");
			 chain.doFilter(servletRequest, servletReponse);
		 }else{
			 System.out.println("User Logined");
			 req.setAttribute("message", "User or passwword");
			 req.getRequestDispatcher("/login").forward(req, res);
		 }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
