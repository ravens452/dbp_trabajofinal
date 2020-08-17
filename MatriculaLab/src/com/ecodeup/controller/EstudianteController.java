	package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.EstudianteDAO;
import com.ecodeup.model.Estudiante;
import com.ecodeup.dao.LaboratorioDAO;
import com.ecodeup.model.Laboratorio;
import com.ecodeup.dao.MatriculaDAO;
import com.ecodeup.model.Matricula;

@WebServlet(description = "Administra peticion", urlPatterns = { "/estudiante" })
public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudianteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("registrar")) {
			System.out.println("opcion Registrarse presionada");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/registrar.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("listar")) {
			
			EstudianteDAO estudianteDAO=new EstudianteDAO();
			List<Estudiante> lista = new ArrayList<>();
			try {
				lista=estudianteDAO.obtenerProductos();
				for(Estudiante estudiante : lista) {
					System.out.println(estudiante);
				}
				request.setAttribute("lista",lista);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("opcion Listar presionada");
			
		}
		else if(opcion.equals("listarlab"))
		{
			LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
			List<Laboratorio> lista = new ArrayList<>();
			try {
				lista=laboratorioDAO.obtenerProductos();
				for(Laboratorio laboratorio : lista)
				{
					System.out.println(laboratorio);
				}
				request.setAttribute("lista",lista);
				lista=laboratorioDAO.obtenerProductos();
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listarlab.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("opcion Listar presionada");
		}
		else if(opcion.equals("matricula"))
		{
			System.out.println("opcion Matricula presionada");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/views/matricula.jsp");
			System.out.println("89");
			requestDispatcher.forward(request, response);
			
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		if(opcion.equals("guardar"))
		{
			EstudianteDAO estudianteDAO = new EstudianteDAO(); 
			Estudiante estudiante = new Estudiante();
			estudiante.setCui(Integer.parseInt(request.getParameter("cui")));
			estudiante.setNombres(request.getParameter("nombres"));
			estudiante.setApellidos(request.getParameter("apellidos"));
			estudiante.setCorreo(request.getParameter("correo"));
			
			try {
				estudianteDAO.guardar(estudiante);
				System.out.println("Registro de Estudiante guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcion.equals("guardarM"))
		{
			MatriculaDAO matriculaDAO = new MatriculaDAO();
			Matricula matricula = new Matricula();
			matricula.setCui(Integer.parseInt(request.getParameter("cui")));
			matricula.setCodigo_laboratorio(Integer.parseInt(request.getParameter("codigo_laboratorio")));
				System.out.println("Registro de Matricula guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
		}
		
		
		//doGet(request, response);
	}

}
