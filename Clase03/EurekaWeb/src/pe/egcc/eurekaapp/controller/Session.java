package pe.egcc.eurekaapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class Session {
  
  private Session() {
  }
  
  public static void put(HttpServletRequest request,
      String key, Object value){
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute(key, value);
  }
  
  public static Object get(HttpServletRequest request,
      String key){
    HttpSession httpSession = request.getSession();
    return httpSession.getAttribute(key);
  }

}
