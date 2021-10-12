/*
 * To change this license header, choose License Headers in PicsShow Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealer;
import java.sql.*;
/**
 *
 * @author Mathur
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PicsShow extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;


    //Images Path In Array
    String[] list = {
                      "C:\\Users\\Mathur\\Desktop\\duster1.jpg",//0
                      "C:\\Users\\Mathur\\Desktop\\DUSTER.jpg",//1
                      "C:\\Users\\Mathur\\Desktop\\Renault.jpg",//2
                      "C:\\Users\\Mathur\\Desktop\\duster2.jpg",
                    };
    
    public PicsShow(){
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(40, 30, 700, 300);



        //Call The Function SetImageSize
        SetImageSize(3);
        

       //set a timer
        tm = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();
        setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        
    }
    //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

public static void main(String[] args){ 
      
    new PicsShow();
   // new PicsShow().setVisible(false);
    
}
}
