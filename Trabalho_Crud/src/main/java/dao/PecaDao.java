package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Peca;
import util.DbUtil;

public class PecaDao {

    private Connection connection;

    public PecaDao() {
        connection = DbUtil.getConnection();
    }

    public void addPeca(Peca peca) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into peca(nome,descricao,tipo,valor,cod_tipo) values (?, ?, ?, ?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, peca.getNome());
            preparedStatement.setString(2, peca.getDesc());
            preparedStatement.setString(3, peca.getTipo());
            preparedStatement.setFloat(4, peca.getValor());
            preparedStatement.setInt(5, Integer.parseInt(peca.getTipo()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePeca(int pecaId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from peca where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pecaId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePeca(Peca peca) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update peca set nome=?, descricao=?, cod_tipo=?, valor=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, peca.getNome());
            preparedStatement.setString(2, peca.getDesc());
            preparedStatement.setString(3, peca.getTipo());
            preparedStatement.setFloat(4, peca.getValor());
            preparedStatement.setInt(5, peca.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Peca> getAllPecas() {
        List<Peca> listaDePecas = new ArrayList<Peca>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vwPecas");
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDesc(rs.getString("descricao"));
                peca.setTipo(rs.getString("tipo"));
                peca.setValor(rs.getFloat("valor"));
              listaDePecas.add(peca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDePecas;
    }

    public Peca getPecaById(int pecaId) {
        Peca peca = new Peca();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from peca where id=?");
            preparedStatement.setInt(1, pecaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	
            	peca.setId(rs.getInt("id"));
            	peca.setNome(rs.getString("nome"));
                peca.setDesc(rs.getString("descricao"));
                peca.setTipo(rs.getString("tipo"));
                peca.setValor(rs.getFloat("valor"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peca;
    }
}