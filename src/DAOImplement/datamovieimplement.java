/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

//interface -> fungsi-fungsi di program
package DAOImplement;
import java.util.List;
import model.*;

public interface datamovieimplement {
    public void insert(datamovie m);
    public void update(datamovie m, String judulLama);
    public void delete(String judul);
    public List<datamovie> getAll();
}
