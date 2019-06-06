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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jpl7.Query;


public class Bandas extends JFrame{
    
    JLabel imagen,titulo,informacion;
    JTextField consulta;
    JButton btnInfo,btnRegresar;
    JPanel panel;
    Font fuente,fuente1;
    JRadioButton canciones,albumes,acerca,pais;
    ButtonGroup grp;
    
    
    public Bandas(){
        super("Bandas");
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
        titulo = new JLabel("Consultar Bandas o Artista");
        btnInfo = new JButton("Consultar");
        //btnInfo.setIcon(new ImageIcon("src/img/cassete.png"));
        fuente = new Font("Tahoma",20,20);
        fuente1 = new Font("Tahoma",15,15);
        canciones = new JRadioButton("Canciones");
        albumes = new JRadioButton("Album's");
        pais = new JRadioButton("Origen");
        acerca = new JRadioButton("Info. Gral.");
        grp = new ButtonGroup();
        btnRegresar = new JButton();
        btnRegresar.setIcon(new ImageIcon("src/img/atras.png"));
    }
    
    private void armar(){
       panel.setLayout(null);
       informacion.setBounds(480, 150, 300, 400);
       informacion.setFont(fuente1);
       consulta.setBounds(50,85,200,30);
       imagen.setBounds(50,200,400, 400);
       titulo.setBounds(300,20,250,30);
       btnInfo.setBounds(300, 78, 100, 40);
       btnInfo.setToolTipText("Informacion");
       btnInfo.setBackground(Color.white);
       titulo.setFont(fuente);
       canciones.setBounds(50, 140, 100, 30);
       canciones.setBackground(Color.WHITE);
       albumes.setBounds(150, 140, 100, 30);
       albumes.setBackground(Color.WHITE);
       pais.setBounds(250, 140, 100, 30);
       pais.setBackground(Color.WHITE);
       acerca.setBounds(350, 140, 100, 30);
       acerca.setBackground(Color.WHITE);
       btnRegresar.setBounds(600,65,67,67);
       btnRegresar.setBackground(Color.white);
       
       grp.add(albumes);
       grp.add(pais);
       grp.add(acerca);
       
       btnInfo.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              if(albumes.isSelected()){
                 try{
               String consult = "consult('beatles.pl')";
               Query q = new Query(consult);
               if(q.hasSolution()){
               String param = consulta.getText().toLowerCase().replace(" ", "_");
               String consult2 ="lista_album("+param+",Album).";
               Query q2 = new Query(consult2);
               String lista_album = q2.oneSolution().get("Album").toString();
               String album2 = lista_album.replace("'", "");
               String album3 = album2.replace("[", "");
               String album4 = album3.replace("|", "");
               String album5 = album4.replace("]", "");
               String album6 = album5.replace("(", "");
               String album7 = album6.replace(")", "");
               String album8 = album7.replace(",", ",");
               String result = "<html><body>Album: "+album8.replace("_", " ")+"</body></html>";
               informacion.setText(result);
               imagen.setIcon(new ImageIcon("src/img/"+param.replace("_", " ")+".jpg"));
               }else{
                   System.out.println("No se logro conectar");
               }
               }catch(Exception r){
                  informacion.setText("Banda no registrada"); 
                  imagen.setIcon(new ImageIcon("src/img/desconocido.png"));
               }
                 
             }else if(pais.isSelected()){
                 try{
               String consult = "consult('beatles.pl')";
               Query q = new Query(consult);
               if(q.hasSolution()){
               String param = consulta.getText().toLowerCase().replace(" ", "_");
               String consult2 ="originario("+param+",W).";
               Query q2 = new Query(consult2);
               String pais = q2.oneSolution().get("W").toString();
               String result = "<html><body>Pais: "+pais.replace("_", " ")+"</body></html>";
               informacion.setText(result);
               imagen.setIcon(new ImageIcon("src/img/"+pais.replace("_", " ")+".jpg"));
               }else{
                   System.out.println("No se logro conectar");
               }
               }catch(Exception r){
                  informacion.setText("Banda no registrada"); 
                  imagen.setIcon(new ImageIcon("src/img/desconocido.png"));
               }
             }else if(acerca.isSelected()){
                try{
               String consult = "consult('beatles.pl')";
               Query q = new Query(consult);
               if(q.hasSolution()){
               String param = consulta.getText().toLowerCase().replace(" ", "_");
               String consult2 ="acerca_de("+param+",Y,Z,W).";
               Query q2 = new Query(consult2);
               String originario = q2.oneSolution().get("Y").toString();
               String lista_album = q2.oneSolution().get("Z").toString();
               String integrantes = q2.oneSolution().get("W").toString();
               String album2 = lista_album.replace("'", "");
               String album3 = album2.replace("[", "");
               String album4 = album3.replace("|", "");
               String album5 = album4.replace("]", "");
               String album6 = album5.replace("(", "");
               String album7 = album6.replace(")", "");
               String album8 = album7.replace(",", ",");
               integrantes = integrantes.replace("'", "");
               integrantes = integrantes.replace("[", "");
               integrantes = integrantes.replace("|", "");
               integrantes = integrantes.replace("]", "");
               integrantes = integrantes.replace("(", "");
               integrantes = integrantes.replace(")", "");
               integrantes = integrantes.replace("_", " ");
               
               String result = "<html><body>Album´s: "+album8.replace("_", " ")+"<br><br><br>Originaria de: "+originario+"<br><br><br>Integrantes: "+integrantes+"</body></html>";
               informacion.setText(result);
               imagen.setIcon(new ImageIcon("src/img/"+param.replace("_", " ")+".jpg"));
               }else{
                   System.out.println("Banda no registrada");
               }
               }catch(Exception r){
                  informacion.setText("Artista no registrado"); 
                  imagen.setIcon(new ImageIcon("src/img/desconocido.png"));
               }
                 
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
       panel.add(albumes);
       panel.add(pais);
       panel.add(acerca);
       panel.add(btnRegresar);
       add(panel);
    }
    
   
    
}
