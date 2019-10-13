/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mypackage.NamePassword;

/**
 *
 * @author student
 */
public interface NamePasswordDAO {
    public List<NamePassword> getAllNamePassword();
    public void addNamePassword(String name, String password);
    public void deleteNamePassword(String name, String password);
    public void deleteNamePassword(String name);
    public void upDateNamePassword(String name, String password);
    
}
