/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAOdatamovie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datamovieimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class datamovieDAO implements datamovieimplement {

    Connection connection;

    //query
    final String select = "SELECT * FROM movie";
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE movie SET judul = ?, alur = ?, penokohan = ?, akting = ?, nilai = ? WHERE movie.judul = ?";
    final String delete = "DELETE FROM movie WHERE judul = ?";

    //connect ke database
    public datamovieDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(datamovie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS); //query yang di-excecute adalah query dari variable 'insert'
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                m.setJudul(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datamovie m, String judulLama) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update); //query yang di-excecute adalah query dari variable 'update'
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());
            statement.setString(6, judulLama); //menggunakan judul semula (sebelum di-update) untuk update db

            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, judul);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datamovie> getAll() {
        List<datamovie> dm = null;
        try {
            dm = new ArrayList<datamovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select); //query yang di-excecute adalah query dari variable 'select'
            while (rs.next()) {
                datamovie mv = new datamovie();
                mv.setJudul(rs.getString("judul"));
                mv.setAlur(rs.getDouble("alur"));
                mv.setPenokohan(rs.getDouble("penokohan"));
                mv.setAkting(rs.getDouble("akting"));
                mv.setNilai(rs.getDouble("nilai"));

                dm.add(mv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dm;
    }
}
