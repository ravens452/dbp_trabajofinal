package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Estudiante;

public class EstudianteDAO {
		private Connection connection;
		private PreparedStatement statement;
		private boolean estadoOperacion;
		
		//guardar
		public boolean guardar(Estudiante estudiante) throws SQLException {
			String sql=null;
			estadoOperacion=false;
			connection=obtenerConexion();
			
			try {
				connection.setAutoCommit(false);
				sql="INSERT INTO estudiante VALUES(?,?,?,?)";
				statement=connection.prepareStatement(sql);
				
				statement.setInt(1, estudiante.getCui());
				statement.setString(2, estudiante.getNombres());
				statement.setString(3, estudiante.getApellidos());
				statement.setString(4, estudiante.getCorreo());
				
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
		
		public List<Estudiante> obtenerProductos() throws SQLException{
			ResultSet resultSet = null;
			List<Estudiante> listaProductos= new ArrayList<>();
			
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
			
			try {
				sql = "SELECT * FROM estudiante";
				statement=connection.prepareStatement(sql);
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Estudiante p=new Estudiante();
					p.setCui(resultSet.getInt(1));
					p.setNombres(resultSet.getString(2));
					p.setApellidos(resultSet.getString(3));
					p.setCorreo(resultSet.getString(4));
					
					listaProductos.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listaProductos;
		}
		
		public Estudiante obtenerEstudiante(int cui) throws SQLException {
			ResultSet resultSet = null;
			Estudiante estudiante=new Estudiante();
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try {
				sql = "SELECT * FROM estudiante WHERE cui=?";
				statement=connection.prepareStatement(sql);
				statement.setInt(1, cui);
				
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
		
		public boolean getEstadoOperacion()
		{
			return this.estadoOperacion;
		}
		
		private Connection obtenerConexion() throws SQLException {
			return Conexion.getConnection();
		}
}
