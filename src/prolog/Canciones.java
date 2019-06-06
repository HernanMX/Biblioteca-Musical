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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jpl7.Query;


public class Canciones extends JFrame{
    
    JLabel imagen,titulo,informacion;
    JTextField consulta;
    JButton btnInfo,btnRegresar;
    JPanel panel;
    Font fuente,fuente1;
    
    public Canciones(){
        super("Canciones");
        crear();
        armar();
    }

    private void crear() {
        panel = new JPanel();
        informacion = new JLabel("");
        panel.setBackground(Color.white);
        consulta = new JTextField();
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon("src/img/rolling_opt.jpg"));
        titulo = new JLabel("Biblioteca Musical");
        btnInfo = new JButton("Consultar");
       // btnInfo.setIcon(new ImageIcon("src/img/cassete.png"));
        fuente = new Font("Tahoma",20,20);
        fuente1 = new Font("Tahoma",15,15);
        btnRegresar = new JButton();
        btnRegresar.setIcon(new ImageIcon("src/img/atras.png"));
    }
    
    private void armar(){
       panel.setLayout(null);
       informacion.setBounds(500, 100, 300, 200);
       informacion.setFont(fuente1);
       consulta.setBounds(50,85,200,30);
       imagen.setBounds(50,150,400, 400);
       titulo.setBounds(300,20,250,30);
       btnInfo.setBounds(300, 78, 100, 40);
       btnInfo.setToolTipText("Informacion");
       btnInfo.setBackground(Color.white);
       titulo.setFont(fuente);
       btnRegresar.setBounds(600,65,67,67);
       btnRegresar.setBackground(Color.white);
       
       btnInfo.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               String consult = "consult('beatles.pl')";
               Query q = new Query(consult);
               if(q.hasSolution()){
               String param = consulta.getText().toLowerCase().replace(" ", "_");
               String consult2 ="cancion_artista("+param+",W,Z,Y).";
               Query q2 = new Query(consult2);
               String album = q2.oneSolution().get("W").toString();
               String artista = q2.oneSolution().get("Z").toString();
               String lanzado = q2.oneSolution().get("Y").toString();
               String result = "<html><body>Album: "+album.replace("_", " ")+"<br>Artista: "+artista.replace("_", " ")+"<br>Año: "+lanzado.replace("_", " ")+"</body></html>";
               informacion.setText(result);
               imagen.setIcon(new ImageIcon("src/img/"+album.replace("_", " ")+".jpg"));
               }else{
                   System.out.println("No se logro conectar");
               }
               }catch(Exception r){
                  informacion.setText("Cancion no esta registrada"); 
                  imagen.setIcon(new ImageIcon("src/img/desconocido.png"));
               }
               
           }
       });
       
       btnRegresar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               Interfaz prueba = new Interfaz();
               prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               prueba.setSize(800,600);
               prueba.setResizable(false);
               prueba.setLocationRelativeTo(null);
               prueba.setVisible(true);
               
           }
       });
       
       panel.add(titulo);
       panel.add(informacion);
       panel.add(consulta);
       panel.add(imagen);
       panel.add(btnInfo);
       panel.add(btnRegresar);
       add(panel);
    }
    
   
    
}
