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
    public class pesan {

        private String pesan;
        
        public pesan (String pesan) { 
             this.pesan = pesan;
        }

    pesan() {
        
    }
    /**
     * @return the pesan
     */
    public String getPesan() {
        return pesan;
    }

    /**
     * @param pesan the pesan to set
     */
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
     
    @Override
    public String toString(){
        String viewdata;
        viewdata =   getPesan();
        
        return viewdata;        
    }

}
