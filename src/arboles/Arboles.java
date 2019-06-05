/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author vsuarezj
 */
public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree nt = new Tree();
        nt.insert(3);
        nt.insert(8);
        nt.insert(1);
        nt.insert(4);
        nt.insert(6);
        nt.insert(2);
        nt.insert(10);
        nt.insert(9);
        nt.insert(25);
        nt.insert(15);
        nt.insert(16);
        
        nt.displayI(nt.getRoot()); System.out.println("");
        nt.displayPr(nt.getRoot()); System.out.println("");
        nt.displayPs(nt.getRoot()); System.out.println("");
        
        
    }
    
}
