package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.entity.Kisi;

public class KayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KayitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Kisi kullanici = new Kisi(request.getParameter("kullaniciadi"), request.getParameter("sifre"));
		
		boolean k = new com.dao.KullaniciDAO().kullaniciKayit(kullanici);

		if (k) {
			request.getSession().setAttribute("kullanici", kullanici);
			response.sendRedirect("index.jsp");
		} else {
			String mesaj = "tekrar deneyiniz";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("uyekayit.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
