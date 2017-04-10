package fr.wemove.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= "/WEB-INF/views/jsp/Utilisateur" )
public class RestrictionFilter implements Filter {

	public static final String VUE_ACCUEIL = "/WEB-INF/views/jsp/accueil/accueil.jsp";
    
    public RestrictionFilter() {
      
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession();
		
		if ( session.getAttribute("conducteur") == null ) {
			
			resp.sendRedirect( req.getContextPath() + VUE_ACCUEIL);
		} 
		else { 
			chain.doFilter(request, response);
			
		}
		
	
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
