/*
	Programación Lógica y Funcional
	Semestre Enero-Junio 2019
	Mayo del 2019
	Hernán Arturo González Alcaraz, Paul Adrián Padilla Guerrero, Alexis Antonio Porras Lobato
    Conectando JAVA-PROLOG(Biblioteca Musical)    
*/
package prolog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interfaz extends JFrame{
    
    JLabel imagen,titulo;
    JButton cancion,banda,album;
    JPanel panel;
    Font fuente;
    
    public Interfaz(){
        super("Musica");
        crear();
        armar();
    }

    private void crear() {
        panel = new JPanel();
        panel.setBackground(Color.white);
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon("src/img/rolling_opt.jpg"));
        titulo = new JLabel("Biblioteca Musical");
        cancion = new JButton();
        cancion.setIcon(new ImageIcon("src/img/cancion.png"));
        banda = new JButton();
        banda.setIcon(new ImageIcon("src/img/banda.png"));
        album = new JButton();
        album.setIcon(new ImageIcon("src/img/album.png"));
        fuente = new Font("Tahoma",20,20);
    }
    
    private void armar(){
       panel.setLayout(null);
       imagen.setBounds(50,55,500, 500);
       titulo.setBounds(300,20,250,30);
       cancion.setBounds(580, 65, 130, 130);
       cancion.setToolTipText("Canciones");
       cancion.setBackground(Color.white);
       banda.setBounds(580, 210, 130, 130);
       banda.setToolTipText("Bandas");
       banda.setBackground(Color.white);
       album.setBounds(580, 350, 130, 130);
       album.setToolTipText("Album's");
       album.setBackground(Color.white);
       titulo.setFont(fuente);
       cancion.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
              dispose();
              Canciones prueba = new Canciones();
              prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              prueba.setSize(800,600);
              prueba.setResizable(false);
              prueba.setLocationRelativeTo(null);
              prueba.setVisible(true); 
           }
       });
       
       banda.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
              dispose();
              Bandas prueba = new Bandas();
              prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              prueba.setSize(800,700);
              prueba.setResizable(false);
              prueba.setLocationRelativeTo(null);
              prueba.setVisible(true); 
           }
       });
       
       album.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
              dispose();
              Album prueba = new Album();
              prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              prueba.setSize(800,700);
              prueba.setResizable(false);
              prueba.setLocationRelativeTo(null);
              prueba.setVisible(true); 
           }
       });
       
       
       panel.add(titulo);
       panel.add(imagen);
       panel.add(cancion);
       panel.add(banda);
       panel.add(album);
       add(panel);
    }
    
    public static void main(String[] args) {
        Interfaz prueba = new Interfaz();
        prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prueba.setSize(800,600);
        prueba.setResizable(false);
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
    }
    
}
