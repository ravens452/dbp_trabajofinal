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
			sql="INSERT INTO laboratorio VALUES(NULL,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setString(1, laboratorio.getGrupo());
			statement.setInt(2, laboratorio.getCodigo_curso());
			statement.setString(3, laboratorio.getNro_aula());
			statement.setBoolean(4, laboratorio.isPermitir_matricula());
			
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
	
	public boolean editar(Laboratorio laboratorio ) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE laboratorio SET permitir_matricula WHERE id=?";
			statement = connection.prepareStatement(sql);

			statement.setBoolean(1, laboratorio.isPermitir_matricula());
			statement.setInt(2, laboratorio.getId());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}


	public List<Laboratorio> obtenerProductos() throws SQLException{
		ResultSet resultSet = null;
		List<Laboratorio> listaProductos= new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			sql = "SELECT * from laboratorio";
			statement=connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Laboratorio p= new Laboratorio();
				p.setId(resultSet.getInt(1));
				p.setGrupo(resultSet.getString(2));
				p.setCodigo_curso(resultSet.getInt(3));
				p.setNro_aula(resultSet.getString(4));
				p.setPermitir_matricula(resultSet.getBoolean(5));
				
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
			sql = "SELECT * FROM laboratorio WHERE codigo=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {		
				laboratorio.setId(resultSet.getInt(1));
				laboratorio.setGrupo(resultSet.getString(2));
				laboratorio.setCodigo_curso(resultSet.getInt(3));
				laboratorio.setNro_aula(resultSet.getString(4));
				laboratorio.setPermitir_matricula(resultSet.getBoolean(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return laboratorio;
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
