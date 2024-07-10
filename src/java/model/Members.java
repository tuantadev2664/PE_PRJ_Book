/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPTSHOP
 */
public class Members {
    private String id;
    private String name;
    private String email;
    private String join_date;

    public Members() {
    }

    public Members(String id, String name, String email, String join_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.join_date = join_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    @Override
    public String toString() {
        return "Members{" + "id=" + id + ", name=" + name + ", email=" + email + ", join_date=" + join_date + '}';
    }
    
    
}
