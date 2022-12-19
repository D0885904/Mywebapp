package com.mycompany.user;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, name = "Name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "studentID")
    private String studentID;

    @Column(length = 45, nullable = false, name = "majorIn")
    private String majorIn;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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


    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +

                ", firstName='" + getFirstName() + '\'' +
                '}';
                /*", studentID='" + getStudentID() + '\'' +
                '}';*/


    }

}
