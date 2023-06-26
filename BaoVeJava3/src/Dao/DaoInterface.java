/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface DaoInterface<T> {

    public int insert(T t);

    public int update(T t);

    public int delete(T t);

    public T selectByID(T t);

    public ArrayList<T> selectAll();

    public ArrayList<T> selectBySQL(String sql, Object t);

    public ArrayList<T> selectByCondition(String condition);
}
