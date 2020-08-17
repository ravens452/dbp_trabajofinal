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
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.dao.CursoDAO;
import com.ecodeup.model.Curso;
import com.ecodeup.dao.LaboratorioDAO;
import com.ecodeup.model.Laboratorio;
import com.ecodeup.dao.MatriculaDAO;
import com.ecodeup.model.Matricula;
import com.ecodeup.model.Estudiante;
/**
 * Servlet implementation class LaboratorioController
 */
@WebServlet(description = "Administra peticion", urlPatterns = { "/laboratorio" })
public class LaboratorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LaboratorioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("registrarlab")) {
			System.out.println("opcion Registrarse el laboratorio presionada");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/registrarlab.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(opcion.equals("listar")) 
		{	
			LaboratorioDAO laboratorioDAO=new LaboratorioDAO();
			List<Laboratorio> lista = new ArrayList<>();

			try {
				lista=laboratorioDAO.obtenerProductos();
				for(Laboratorio laboratorio : lista) {
					System.out.println(laboratorio);
				}
				request.setAttribute("lista",lista);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/listar.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("opcion Listar presionada");
			
		}
		else if(opcion.equals("registrar")) {
			System.out.println("opcion Registrar el curso presionada");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/registrar.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("listarcurso")) {
			
			CursoDAO cursoDAO=new CursoDAO();
			List<Curso> lista = new ArrayList<>();
			try {
				lista=cursoDAO.obtenerProductos();
				for(Curso curso : lista) {
					System.out.println(curso);
				}
				request.setAttribute("lista",lista);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/listarcurso.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("opcion Listar presionada");
			
		}
		else if(opcion.equals("listarMatricula"))
		{
			MatriculaDAO matriculaDAO=new MatriculaDAO();
			List<Matricula> lista = new ArrayList<>();
			List<Laboratorio> listal = new  ArrayList<>();
			List<Curso> listac = new  ArrayList<>();
			List<Estudiante> listae = new ArrayList<>();
			try {
				lista=matriculaDAO.obtenerProductos();
				for(Matricula matricula : lista) {
						System.out.println(matricula);
				}
				request.setAttribute("lista",lista);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/listarmatricula.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("opcion Listar presionada");
			
		}
		else if(opcion.equals("meditar"))
		{

			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
			Laboratorio p = new Laboratorio();
			try {
				p = laboratorioDAO.obtenerLaboratorio(id);
				System.out.println(p);
				request.setAttribute("laboratorio", p);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/editarLab.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		System.out.println("Opcion es: " + opcion);
		
		if(opcion.equals("guardarCurso"))
		{
			CursoDAO cursoDAO = new CursoDAO();
			Curso curso = new Curso();
			curso.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			curso.setNombre(request.getParameter("nombre"));
			curso.setDescripcion(request.getParameter("descripcion"));
			
			try {
				cursoDAO.guardarC(curso);
				System.out.println("Registro guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcion.equals("guardarLab"))
		{
			LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
			Laboratorio laboratorio = new Laboratorio();
			laboratorio.setGrupo(request.getParameter("grupo"));
			laboratorio.setCodigo_curso(Integer.parseInt(request.getParameter("codigo_curso")));
			laboratorio.setNro_aula(request.getParameter("nro_aula"));
			laboratorio.setPermitir_matricula(Boolean.parseBoolean(request.getParameter("permitir_matricula")));
			
			try {
				laboratorioDAO.guardar(laboratorio);
				System.out.println("Registro guardado");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(opcion.equals("editar"))
		{
			Laboratorio laboratorio = new Laboratorio();
			LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

			laboratorio.setPermitir_matricula(Boolean.parseBoolean(request.getParameter("permitir_matricula")));
			try {
				laboratorioDAO.editar(laboratorio);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
