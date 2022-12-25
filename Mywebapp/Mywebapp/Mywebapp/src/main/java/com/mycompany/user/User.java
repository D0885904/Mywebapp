package com.mycompany.user;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, name = "firstName")
    private String firstName;

    @Column(length = 45, nullable = false, name = "class")
    private String class_s;

    @Column(length = 45, nullable = false, name = "studentID")
    private String studentID;


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




    public String getClass_s() {
        return class_s;
    }

    public void setClass_s(String class_s) {
        this.class_s = class_s;
    }



    public String getStudentID() {return studentID; }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +

                ", firstName='" + getFirstName() + '\'' +

                ", class='" + getClass_s() + '\'' +

                ", StudentID='" + getStudentID() + '\'' +
                '}';
    }

}
