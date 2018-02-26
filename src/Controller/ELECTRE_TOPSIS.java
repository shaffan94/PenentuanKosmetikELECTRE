/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author shaff
 */
public class ELECTRE_TOPSIS {
    ELECTRE electre;
    TOPSIS topsis;
    double[][] matriksKeputusan;
    ArrayList<ArrayList> altInfos;
    int[] bestRanking;
    double[] bestValue;
    
    public ELECTRE_TOPSIS(){
        
    }
    
    public void InisialisasiData(double[][] matriksX){
        int i,j;
        
        matriksKeputusan = new double[matriksX.length][matriksX[0].length];
        
        for(i=0; i<matriksX.length; i++){
            for(j=0; j<matriksX[i].length; j++){
                matriksKeputusan[i][j] = matriksX[i][j];
            }
        }
    }
    
    public double[][] hitungElectre(int[] bobotKriteria){
        double[][] matriksV;
        
        electre = new ELECTRE();
        topsis = new TOPSIS();
        
        electre.inisialisasiData(matriksKeputusan);
        electre.inisialisasiBobot(bobotKriteria);
        electre.normalisasiData();
        electre.pembobotanMatriksNormalisasi();
        matriksV = electre.getMatriksV();
        
        return matriksV;
    }
    
    public int hitungTopsis(double[][] matriksV){
        int alternativeValue, i;
        
        topsis.inisialisasiMatriksBobotTernomalisasi(matriksV);
        topsis.setSolusiIdealPositive();
        topsis.setSolusiIdealNegative();
        topsis.setJarakAlternatifPositive();
        topsis.setJarakAlternatifNegative();
        alternativeValue = topsis.setNilaiPreferensiAlternative();
        altInfos = topsis.getNilaiPreferensiAlternativeRanking();
        
        bestValue = new double[5];
        bestRanking = new int[5];
        
        for(i=0; i<altInfos.get(0).size(); i++){
            bestValue[i] = Double.parseDouble(altInfos.get(0).get(i).toString());
        }
        
        for(i=0; i<altInfos.get(1).size(); i++){
            bestRanking[i] = Integer.parseInt(altInfos.get(1).get(i).toString());
        }
        
        return alternativeValue;
    }
    
    public int hitungElectreTopsis(int[] bobotKriteria){    
        int alternativeValue;
        double[][] matriksV;
        
        matriksV = hitungElectre(bobotKriteria);
        alternativeValue = hitungTopsis(matriksV);
        
        return alternativeValue;
    }
    
    public int[] getBestRanking(){
        return bestRanking;
    }
    
    public double[] getBestValue(){
        return bestValue;
    }
}
