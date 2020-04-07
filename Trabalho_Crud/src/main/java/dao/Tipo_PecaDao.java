package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Peca;
import model.Tipo_Peca;
import util.DbUtil;

public class Tipo_PecaDao {
	 private Connection connection;
	 
	 public Tipo_PecaDao() {
	        connection = DbUtil.getConnection();
	    }
	 public void addTipo (Tipo_Peca tipo_Peca) {
		 try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into Tipo_Peca (tipo) values (?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, tipo_Peca.getCategoria());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void deleteTipo(int tipoId) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from Tipo_Peca where id=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, tipoId);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public void updatePeca(Tipo_Peca tipo_Peca) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update Tipo_Peca set tipo=?" +
	                            "where id=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, tipo_Peca.getCategoria());
	            preparedStatement.setInt(2, tipo_Peca.getId());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public List<Tipo_Peca> getAllTipo() {
	        List<Tipo_Peca> listaDeTipos = new ArrayList<Tipo_Peca>();
	        try {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from Tipo_Peca");
	            while (rs.next()) {
	                Tipo_Peca tipo = new Tipo_Peca();
	                tipo.setId(rs.getInt("id"));
	                tipo.setCategoria(rs.getString("tipo"));
	              listaDeTipos.add(tipo);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return listaDeTipos;
	    }
	 
	 public Tipo_Peca getTipoById(int tipo_Peca) {
	        Tipo_Peca tipo = new Tipo_Peca();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from Tipo_Peca where id=?");
	            preparedStatement.setInt(1, tipo_Peca);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	
	            	tipo.setId(rs.getInt("id"));;
	            	tipo.setCategoria(rs.getString("tipo"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return tipo;
	    }

}
