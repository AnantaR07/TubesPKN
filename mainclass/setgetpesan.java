/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

/**
 *
 * @author USER
 */
public class setgetpesan {
    
      private String Pesan;

    setgetpesan() {
        
    }

    /**
     * @return the Pesan
     */
    public String getPesan() {
        return Pesan;
    }

    /**
     * @param Pesan the Pesan to set
     */
    public void setPesan(String Pesan) {
        this.Pesan = Pesan;
    }
    
    setgetpesan(String pesan){
        this.Pesan = Pesan;
    }
    
    @Override
    public String toString(){
        String viewPenduduk;
        viewPenduduk = getPesan();
        
        return viewPenduduk;        
    }
}
