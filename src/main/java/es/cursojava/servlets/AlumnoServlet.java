package es.cursojava.servlets;

import java.io.IOException;

import es.cursojava.hibernate.ejercicio1.dto.AlumnoDTO;
import es.cursojava.hibernate.ejercicio1.service.AlumnoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AltaAlumnoServlet")
public class AlumnoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String email = req.getParameter("email");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		
		AlumnoDTO alumnoDTO = new AlumnoDTO(nombre, email, edad);
		AlumnoService alumnoService = new AlumnoService();
		
		try {
			alumnoService.altaAlumnoService(alumnoDTO);
			resp.getWriter().println("Alumno dado de alta correctamente.");
		} catch (IllegalArgumentException e) {
			resp.getWriter().println("Error al dar de alta el alumno: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}
