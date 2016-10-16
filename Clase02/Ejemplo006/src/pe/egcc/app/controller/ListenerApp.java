package pe.egcc.app.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import pe.egcc.app.model.Carrito;

@WebListener
public class ListenerApp implements HttpSessionListener {

    public ListenerApp() {
    }

    public void sessionCreated(HttpSessionEvent event)  {
      HttpSession session = event.getSession();
      session.setAttribute("carrito", new Carrito());
      System.out.println("Que pasa.");
    }

    public void sessionDestroyed(HttpSessionEvent event)  { 
    }
	
}
