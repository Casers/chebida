package cn.lvhaosir.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("loginNickName");
		if (attribute == null) {
//			String requestUri = request.getRequestURI();
//			System.out.println("拦截的"+attribute+"  "+requestUri);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		return true;
		/*String requestUri = request.getRequestURI();
		if (requestUri.startsWith(request.getContextPath())) {
			requestUri = requestUri.substring(
					request.getContextPath().length(), requestUri.length());
		}
		// /sellers/queryPagerAll.action

		String[] strUrl = { "/sellerinfo/querySellerInfo.action",
				"/sellers/queryPagerAll.action",
				"/sellers/queryCondition.action",
				"/sellerwork/queryAll.action", "/sellerwork/queryOne.action",
				"/userinfo/queryUserInfo.action",
				"/users/queryPagerAll.action", "/users/queryCondition.action",
				"/worktype/queryPagerAll.action",
				"/worktype/saveUpdate.action", "/worktype/delete.action" };
		HttpSession session = request.getSession();
		for (String string : strUrl) {
			if(string.equals(requestUri)){
				Object attribute = session.getAttribute("nickname");
				if (attribute == null) {
					System.out.println(string+"被拦截进去了");
					response.sendRedirect(request.getContextPath()+"/");
					return false;
				}
			}
		}
		return true;*/
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
