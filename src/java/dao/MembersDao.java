/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Members;

/**
 *
 * @author FPTSHOP
 */
public class MembersDao {
    public List<Members> getAllMembers(){
        List<Members> list = new ArrayList<>();
        String sql = "select * from Members";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Members(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
    public List<String> getAllEmails(){
        List<String> list = new ArrayList<>();
        String sql = "select email from Members";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }
    
   public void addNewMember(String name, String email) {
        String sql = "INSERT INTO Members (name, email, join_date) values(?, ?, ?)";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            String join_date = dateFormat.format(currentDate);
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, join_date);
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
   
   public Members getMemberByEmail(String email) {
        String sql = "select * from Members where email = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Members(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public static void main(String[] args) {
        MembersDao membersDao = new MembersDao();
        for(Members members : membersDao.getAllMembers()){
            System.out.println(members);
        }
        
        for(String string : membersDao.getAllEmails()){
            System.out.println(string);
        }
    }
}
