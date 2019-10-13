/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
public class NamePasswordHelper {
    private Session session;
    public NamePasswordHelper(){
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();        
    }
    public List<NamePassword> getAllNamePassword(){
        List<NamePassword> list = null;
        try{
            Transaction ta = session.beginTransaction();
            Query q = session.createQuery("from NamePassword");
            list = (List<NamePassword>)q.list();
            ta.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
