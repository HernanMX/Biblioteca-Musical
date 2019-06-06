/*
	Programación Lógica y Funcional
	Semestre Enero-Junio 2019
	Mayo del 2019
	Hernán Arturo González Alcaraz, Paul Adrián Padilla Guerrero, Alexis Antonio Porras Lobato
    Conectando JAVA-PROLOG(Biblioteca Musical)    
*/
package prolog;

import java.util.Locale;
import org.jpl7.Query;


public class JavaProlog {

  
    public static void main(String[] args) {
        String consulta = "consult('beatles.pl')";
        Query q = new Query(consulta);
        System.out.println(consulta+ " "+ (q.hasSolution()?"satisfactoria":"insactisfatoria"));
   
        String consulta2 ="acerca_de(scorpions).";
        Query q2 = new Query(consulta2);
        String accion = q2.oneSolution().toString();
        System.out.println("Consulta correcta  "+accion.replace('_', ' ').toUpperCase());
    }
    
}
