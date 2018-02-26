/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Dokumen;
import java.util.ArrayList;

/**
 *
 * @author shaff
 */
public class DokumenManager {
    public DokumenManager(){
    
    }
    
    public ArrayList<ArrayList> get_data(String Path) {
        Dokumen excelmanager = new Dokumen();
        ArrayList<ArrayList> data = excelmanager.load_excel(Path);
        return data;
    }
}
