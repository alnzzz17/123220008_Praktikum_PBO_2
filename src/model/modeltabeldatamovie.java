/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldatamovie extends AbstractTableModel{

    List<datamovie> dm; //dari datamovie.java
    public modeltabeldatamovie(List<datamovie>dm){
        this.dm = dm;
    }
    
    @Override
    public int getRowCount() { //jumlah baris tergantung jumlah data
        return dm.size(); //menghitung size dari data
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "JUDUL";
            case 1:
                return "ALUR";
            case 2:
                return "PENOKOHAN";
            case 3:
                return "AKTING";
            case 4:
                return "NILAI";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dm.get(row).getJudul();
            case 1:
                return dm.get(row).getAlur();
            case 2:
                return dm.get(row).getPenokohan();
            case 3:
                return dm.get(row).getAkting();
            case 4:
                return dm.get(row).getNilai();
            default:
                return null;
        }
    }
    
}
