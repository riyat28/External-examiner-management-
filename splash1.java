/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hm
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class splash1 extends javax.swing.JFrame {
public static void main (String[] args)
    {
        
                splash sp = new splash();
                sp.setVisible(true);
                try{
                    for(int i=0; i<=100; i++)
                    {
                        Thread.sleep(40);
                        sp.loadingnumber.setText(Integer.toString(i)+"%");
			login log = new login();                        
			if(i==100)
                        {              
                          sp.dispose();
			  log.show();
                        }
                    }
                   }
                catch(Exception e){}
                
               //.........................................
        
        
    }
}
