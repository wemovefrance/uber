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

@WebFilter ( urlPatterns = "/conducteur/*")
public class DriverRestrictionFilter implements Filter {

	
	public final static String ATTRIBUT_SESSION_CONDUCTEUR = "conducteur";
    
    public DriverRestrictionFilter() {
      
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession();
		
		if ( session.getAttribute( ATTRIBUT_SESSION_CONDUCTEUR ) == null ) {
			
			String message_connexion ="Veuillez vous connecter pour accéder à votre espace personnel";
			session.setAttribute("logmessage", message_connexion );
			resp.sendRedirect( req.getContextPath() +"/accueil");
		} 
		else { 
			
			chain.doFilter(request, response);
			
		}
		
	
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
