/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author shaff
 */
public class ELECTRE {
    double[][] matriksV;
    double[][] matriksKeputusan;
    double[][] matriksBobot;
    
    public ELECTRE(){
    
    }
    
    public void inisialisasiData(double[][] matriksX){
        int i,j;
        
        matriksKeputusan = new double[matriksX.length][matriksX[0].length];
        
        for(i=0; i<matriksX.length; i++){
            for(j=0; j<matriksX[i].length; j++){
                matriksKeputusan[i][j] = matriksX[i][j];
            }
        }
    }
    
    public void inisialisasiBobot(int[] bobotKriteria){        
        int i,j;
        
        matriksBobot = new double[bobotKriteria.length][bobotKriteria.length];
        
        for(i=0; i<matriksBobot.length; i++){
            for(j=0; j<matriksBobot.length; j++){
                if(i==j){
                    matriksBobot[i][j] = bobotKriteria[i];
                }
                else{
                    matriksBobot[i][j] = 0.0;
                }
            }
        }
    }
    
    public void normalisasiData(){
        int i,j;
        double[] teta;
        double sum;
        
        sum = 0;
        teta = new double[matriksKeputusan[0].length];
        for(i=0; i<matriksKeputusan[0].length; i++){
            for(j=0; j<matriksKeputusan.length; j++){
                sum = sum + Math.pow(matriksKeputusan[j][i], 2.0) ;
            }
            teta[i] = Math.sqrt(sum);
        }
        
        for(i=0; i<matriksKeputusan[0].length; i++){
            for(j=0; j<matriksKeputusan.length; j++){
                matriksKeputusan[j][i] = matriksKeputusan[j][i]/teta[i]; 
            }
        }
    }
    
    public void pembobotanMatriksNormalisasi(){
        int i,j,k;
        matriksV = new double[matriksKeputusan.length][matriksKeputusan[0].length];
        
        for(i=0; i<matriksKeputusan.length; i++){
            for(j=0; j<matriksKeputusan[i].length; j++){
                matriksV[i][j] = 0.0;
            }
        }
        
        for(i=0; i<matriksKeputusan.length; i++){
            for(j=0; j<matriksKeputusan[i].length; j++){
                for(k=0; k<matriksKeputusan[i].length; k++){
                    matriksV[i][j] = matriksV[i][j] + matriksKeputusan[i][k]*matriksBobot[k][j];
                }
            }
        }
    }
    
    public double[][] getMatriksV(){
        return matriksV;
    }
}
