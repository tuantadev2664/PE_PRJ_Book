/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Book;
import model.Loans;
import model.User;

/**
 *
 * @author FPTSHOP
 */
public class DAO {

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from Books";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }

    public List<Loans> getLoansByUserID(int userID) {
        List<Loans> list = new ArrayList<>();
        String sql = "select * from loans where borrower_name = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Loans(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }

    public List<Loans> getLoansByUserIDOverdue(int userID) throws ParseException {
        List<Loans> list = new ArrayList<>();
        String sql = "select * from loans where borrower_name = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            while (rs.next()) {
                Date date = dateFormat.parse(rs.getString(5));
                if (currentDate.after(date)) {
                    list.add(new Loans(rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5)
                    ));
                }
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
        return list;
    }

    public void returns(int id) {
        String sql = "delete from loans where id = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//   

    public void borrowing(int book_idString, int borrow_name, String loan_date, String return_date) {
        String sql = "insert into loans values(?, ?, ?, ?)";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, book_idString);
            st.setInt(2, borrow_name);
            st.setString(3, loan_date);
            st.setString(4, return_date);
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
//    public Bookings getBooking(){
//      List<Room> list = new ArrayList<>();
//        String sql = "select * top 1 from bookings order by desc";
//        try {
//            java.sql.Connection connection = new DBContext().getConnect();
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            if(rs.next()){
//                return new Bookings(rs.getString(1), 
//                        rs.getString(2), 
//                       rs.getString(3), 
//                       rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6)
//                     );
//            }
//            rs.close();
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("e");
//        }
//        return null;  
//    }

    public User login(String user, String pass) {
        String sql = "select * from Users\n"
                + "where [username] = ?\n"
                + "and password = ?";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1),
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

    public User checkAcoountExist(String user) {
        String sql = "select * from Users\n"
                + "where [username] = ?\n";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1),
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

    public void signUp(String user, String pass) {
        String sql = "insert into Users values(?, ?, ?)";
        try {
            java.sql.Connection connection = new DBContext().getConnect();
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, user + "@gmail.com");
            st.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    public static void main(String[] args) throws ParseException {
        DAO dao = new DAO();
        for(Loans loans : dao.getLoansByUserIDOverdue(3))
            System.out.print(loans);
    }
}
