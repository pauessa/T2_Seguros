/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.util.Calendar;
import model.Seguro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sandra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SessionFactory sessionfactory;
        Configuration config = new Configuration();
        config.configure();
        config.addClass(Seguro.class);
        sessionfactory = config.buildSessionFactory();
        
        //CREAMOS UN OBJETO
        Seguro seguro=new Seguro(51, "222145Z" ,"Pepe", "García", "Pérez", 20, 0, Calendar.getInstance().getTime());

        //CREAR UNA SESION
        Session session=sessionfactory.openSession();
        session.beginTransaction();
        
        //GUARDAR OBJETO
        session.save(seguro);
        
        //ACTUALIZAR
        seguro=new Seguro(51, "11111M" ,"Antonia", "García", "Pérez", 50, 6, Calendar.getInstance().getTime());
        //session.update(seguro);
        
        //BORRAR
        //session.delete(seguro);
        
        //LEER
        Seguro s=(Seguro)session.get(Seguro.class,50);
        System.out.println(s);
        
        //CERRAR CONEXIÓN
        session.getTransaction().commit();
        session.close();
    }
    
}
