/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mypackage.NamePassword;
import mypackage.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author student
 */
class NamePasswordHelper implements NamePasswordDAO{
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
    public void addNamePassword(String name, String password){
        try{
            Transaction ta = session.beginTransaction();
            NamePassword np = new NamePassword(name, password);
            session.save(np);
            ta.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteNamePassword(String name, String password){
        try{
            Transaction ta = session.beginTransaction();
            NamePassword np = new NamePassword(name, password);
            session.delete(np);
            ta.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteNamePassword(String name){
        try{
            Transaction ta = session.beginTransaction();
            NamePassword np = new NamePassword();
            np.setName(name);                    
            session.delete(np);
            ta.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void upDateNamePassword(String name, String password){
        try{
            Transaction ta = session.beginTransaction();
            NamePassword np = new NamePassword(name, password);
            session.update(np);
            ta.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
