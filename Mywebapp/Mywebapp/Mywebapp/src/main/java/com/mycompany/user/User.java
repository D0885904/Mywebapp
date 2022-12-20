package com.mycompany.user;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, name = "password")
    private String password;

    @Column(length = 45, nullable = false, name = "studentID")
    private String studentID;

    @Column(length = 1000, nullable = false, name = "post")
    private String post;

    @Column(length = 45, nullable = false, name = "majorIn")
    private String majorIn;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String firstName) {
        this.password = password;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getMajorIn() {
        return majorIn;
    }
    public void setMajorIn(String majorIn) {
        this.majorIn = majorIn;
    }
    public String getPost(){return post;}
    public void setPost(String post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +

                ", password='" + getPassword() + '\'' +
                '}';
                /*", studentID='" + getStudentID() + '\'' +
                '}';*/


    }

}
