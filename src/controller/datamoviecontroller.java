/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import java.util.List;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import model.*;
import view.MainView;

public class datamoviecontroller {

    MainView frame;
    datamovieimplement implDataMovie;
    List<datamovie> dm;

    //menambahkan variabel untuk menyimpan judul semula (judul sebelum di-update)
    private String judulSemula;

    public datamoviecontroller(MainView frame) {
        this.frame = frame;
        implDataMovie = new datamovieDAO();
        dm = implDataMovie.getAll();
    }

    public void isitabel() {
        dm = implDataMovie.getAll();
        modeltabeldatamovie mm = new modeltabeldatamovie(dm);
        frame.getTabelDataMovie().setModel(mm);
    }

    public void insert() {
        datamovie dm = new datamovie();

        //field judul
        dm.setJudul(frame.getjTextJudul().getText());
        
        //field alur
        double alur = Double.parseDouble(frame.getjTextAlur().getText());
        dm.setAlur(alur);
        
        //field penokohan
        double penokohan = Double.parseDouble(frame.getjTextPenokohan().getText());
        dm.setPenokohan(penokohan);
        
        //field akting
        double akting = Double.parseDouble(frame.getjTextAkting().getText());
        dm.setAkting(akting);

        //menghitung nilai rating
        double nilai = (alur + penokohan + akting) / 3;
        dm.setNilai(nilai);

        implDataMovie.insert(dm);
    }

    public void update() {
        datamovie dm = new datamovie();

        //menyimpan judul semula
        String judulLama = frame.getTabelDataMovie().getValueAt(frame.getTabelDataMovie().getSelectedRow(), 0).toString();

        //field judul
        dm.setJudul(frame.getjTextJudul().getText());

        //field alur
        double alur = Double.parseDouble(frame.getjTextAlur().getText());
        dm.setAlur(alur);

        //field penokohan
        double penokohan = Double.parseDouble(frame.getjTextPenokohan().getText());
        dm.setPenokohan(penokohan);

        //field akting
        double akting = Double.parseDouble(frame.getjTextAkting().getText());
        dm.setAkting(akting);

        //menghitung nilai rating
        double nilai = (alur + penokohan + akting) / 3;
        dm.setNilai(nilai);

        //memperbarui judul di database menggunakan judul semula
        implDataMovie.update(dm, judulLama);
    }

    public void delete() {
        String judul = frame.getjTextJudul().getText();
        implDataMovie.delete(judul);
    }
}
