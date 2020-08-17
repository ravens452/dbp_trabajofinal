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

public class LaboratorioDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Laboratorio laboratorio) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INTO laboratorio VALUES(?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, laboratorio.getId());
			statement.setString(2, laboratorio.getGrupo());
			statement.setInt(3, laboratorio.getCodigo_curso());
			statement.setString(4, laboratorio.getNro_aula());
			
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

	public List<Laboratorio> obtenerProductos() throws SQLException{
		ResultSet resultSet = null;
		List<Laboratorio> listaProductos= new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			sql = "SELECT\r\n" + 
					"    l.codigo AS CodigoLab,\r\n" + 
					"    c.nombre AS Nombre,\r\n" + 
					"	c.codigo AS CodigoCurso,\r\n" + 
					
					"    l.grupo AS Grupo,\r\n" + 
					
					"    l.numero_aula AS NAula,\r\n" + 
					"    a.capacidad AS Capacidad\r\n" + 
					"FROM\r\n" + 
					"	(\r\n" + 
					"		laboratorio l\r\n" + 
					"			INNER JOIN\r\n" + 
					"		curso c ON l.codigo_curso = c.codigo\r\n" + 
					"	)\r\n" + 
					"		INNER JOIN\r\n" + 
					"	aula a ON l.numero_aula = a.numero\r\n" + 
					"ORDER BY c.nombre, l.grupo";
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Laboratorio p= new Laboratorio();
				p.setCodigo(resultSet.getInt(1));
				Curso c = obtenerCurso(p.getId());
				Aula a = obtenerAula(p.getNro_aula());
				c.setNombre(resultSet.getString(2));
				p.setCodigo_curso(resultSet.getInt(3));
				p.setGrupo(resultSet.getString(4));
				p.setNro_aula(resultSet.getString(5));
				a.setCapacidad(resultSet.getInt(6));		
				
				p.setNombre(c.getNombre());
				p.setCapacidad(a.getCapacidad());
				
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
		System.out.println("linea 105 fresh");
		connection = obtenerConexion();
		
		System.out.println("linea 107 fresh");
		estadoOperacion = false;
		
		try {
			System.out.println("linea 110 fresh");
			sql = "SELECT * FROM laboratorio WHERE codigo=?";
			System.out.println("linea 112 fresh");
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			System.out.println("linea 117 fresh");
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
	public Curso obtenerCurso(int id) throws SQLException {
		ResultSet resultSet = null;
		Curso curso=new Curso();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM laboratorio l WHERE codigo=? INNER JOIN curso c ON l.codigo = c.codigo";
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
	
	public Aula obtenerAula(String id) throws SQLException {
		ResultSet resultSet = null;
		Aula aula=new Aula();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM laboratorio l WHERE numero_aula=? INNER JOIN aula a ON l.numero_aula = a.numero";
			statement=connection.prepareStatement(sql);
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				aula.setNumero(resultSet.getString(1));
				aula.setCapacidad(resultSet.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aula;
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
