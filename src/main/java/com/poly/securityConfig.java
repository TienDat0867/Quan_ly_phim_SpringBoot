//	package com.poly;
//
//import org.hibernate.annotations.Comment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.poly.entity.taikhoan;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@Service
//
//public class securityConfig  implements HandlerInterceptor{
//	@Autowired HttpSession session;
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
////		
//		Integer matk=(Integer) session.getAttribute("matk");
//		Integer role=(Integer) session.getAttribute("role");
//		String requestUri = request.getRequestURI();
//		Integer manv=(Integer) session.getAttribute("tenNvOnl");
//	 System.out.println("matk ở security"+matk);
//	 System.out.println("manv ở security"+manv);
////	 if ("/logout".equals(requestUri) ) {
////            // Không cần xác thực cho trang đăng ký
////            return true;
////            }
//		
//		 if (matk == null) {
//		         requestUri = request.getRequestURI();
//		        request.getSession().setAttribute("secureUri", requestUri);
//		        response.sendRedirect("/login");
//		        return false;
//		    } 
//		 
//		 if(role != 0 && requestUri.startsWith("/Admin/index111"))
//		 {
//			  response.sendRedirect("/");
//		        return false;
//		 }
//		 
//		        return true;
//		    
//		
//	}
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		
//	
//	}
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
//	
//	   
//	}
//
