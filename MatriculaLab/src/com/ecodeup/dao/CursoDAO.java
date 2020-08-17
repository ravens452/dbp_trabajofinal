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

public class CursoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public boolean guardar(Curso curso) throws SQLException {
		String sql=null;
		estadoOperacion=false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="INSERT INTO curso VALUES(?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, curso.getCodigo());
			statement.setString(2, curso.getNombre());
			statement.setString(3, curso.getDescripcion());
			
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
	public List<Curso> obtenerProductos() throws SQLException{
		ResultSet resultSet = null;
		List<Curso> listaProductos= new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			sql = "SELECT * from curso";
			
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Curso c= new Laboratorio();
				c.setCodigo(resultSet.getInt(1));
				c.setNombre(resultSet.getString(2));
				c.setDescripcion(resultSet.getString(3));
				
				listaProductos.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProductos;
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
