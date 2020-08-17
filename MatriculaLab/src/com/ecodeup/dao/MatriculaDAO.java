package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Curso;
import com.ecodeup.model.Aula;
import com.ecodeup.model.Laboratorio;
import com.ecodeup.model.Matricula;
import com.ecodeup.model.Estudiante;

public class MatriculaDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Matricula matricula) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		Laboratorio l = obtenerLaboratorio(matricula.getCodigo_laboratorio());
		if(l.isPermitir_matricula() == false)
		{
			System.out.println("No se permiten Matriculas en este Laboratorio");
			return false;
		}
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INTO matricula VALUES(?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, matricula.getCui());
			statement.setInt(2, matricula.getCodigo_laboratorio());
			
			
			estadoOperacion=statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) { 
			connection.rollback();
			e.printStackTrace();
		}
		
		return true;
	}
	
	public List<Matricula> obtenerProductos() throws SQLException{
		ResultSet resultSet = null;
		List<Matricula> listaProductos= new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			sql = "SELECT\r\n" + 
					"	m.id AS NMatricula,\r\n" + 
					"    m.cui_estudiante AS CUI_Matriculado,\r\n" + 
					"    CONCAT(e.nombres, ' ', e.apellidos) AS Nombres,\r\n" + 
					"    e.correo AS Correo,\r\n" + 
					"	c.nombre AS Curso,\r\n" + 
					"	lab.grupo AS Grupo, lab.numero_aula AS Aula\r\n" + 
					"FROM\r\n" + 
					"	(\r\n" + 
					"		(\r\n" + 
					"			laboratorio lab\r\n" + 
					"				INNER JOIN\r\n" + 
					"			curso c ON lab.codigo_curso = c.codigo\r\n" + 
					"		)\r\n" + 
					"			INNER JOIN\r\n" + 
					"		matricula m ON m.codigo_laboratorio = lab.codigo\r\n" + 
					"	)\r\n" + 
					"		INNER JOIN\r\n" + 
					"	estudiante e ON m.cui_estudiante = e.cui;";
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Matricula p= new Matricula();
				p.setCodigo_laboratorio(resultSet.getInt(1));
				p.setCui(resultSet.getInt(2));
				Laboratorio l = obtenerLaboratorio(p.getCodigo_laboratorio());
				Curso c = obtenerCurso(p.getCodigo_laboratorio());
				Estudiante e = obtenerEstudiante(p.getCui());
				p.setNombre(resultSet.getString(3));
				e.setCorreo(resultSet.getString(4));
				c.setNombre(resultSet.getString(5));
				l.setGrupo(resultSet.getString(6));
				p.setAula(resultSet.getString(7));
				p.setCorreo(e.getCorreo());
				
				p.setGrupo(l.getGrupo());
				p.setCurso(c.getNombre());
				p.setC_curso(c.getCodigo());
	
				listaProductos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}
	
	
	public Laboratorio obtenerLaboratorio(int id) throws SQLException {
		ResultSet resultSet = null;
		Laboratorio laboratorio=new Laboratorio();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM matricula m WHERE codigo_laboratorio=? INNER JOIN laboratorio l ON m.codigo_laboratorio = l.codigo";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {		
				laboratorio.setId(resultSet.getInt(1));
				laboratorio.setGrupo(resultSet.getString(2));
				laboratorio.setCodigo_curso(resultSet.getInt(3));
				laboratorio.setNro_aula(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return laboratorio;
	}
	
	public Estudiante obtenerEstudiante(int id) throws SQLException {
		ResultSet resultSet = null;
		Estudiante estudiante = new Estudiante();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM matricula m WHERE cui_estudiante=? INNER JOIN estudiante e ON m.cui_estudiante = e.cui";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {		
				estudiante.setCui(resultSet.getInt(1));
				estudiante.setNombres(resultSet.getString(2));
				estudiante.setApellidos(resultSet.getString(3));
				estudiante.setCorreo(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return estudiante;
	}
	
	public Curso obtenerCurso(int id) throws SQLException {
		ResultSet resultSet = null;
		Curso curso = new Curso();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM (matricula m WHERE codigo_laboratorio=? INNER JOIN laboratorio l ON m.codigo_laboratorio = l.codigo) INNER JOIN curso c ON l.codigo_curso = c.codigo";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {		
				curso.setCodigo(resultSet.getInt(1));
				curso.setNombre(resultSet.getString(2));
				curso.setDescripcion(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return curso;
	}
	
	public boolean getEstadoOperacion()
	{
		return this.estadoOperacion;
	}
	
	private Connection obtenerConexion() throws SQLException 
	{
		
		return Conexion.getConnection();
	}
}
