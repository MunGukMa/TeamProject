package one.two.three.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class loginInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String fitc_id = (String) session.getAttribute("fitc_id");
		
		if(fitc_id==null)
		{
			response.sendRedirect("/three");
			return false;
		}
		return true;
	}
}
