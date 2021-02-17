package model;

import dao.SecretaryDoa;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Secretary  extends Personne{
    // Secretary Attributes
    private SimpleStringProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty nickName;
    private SimpleStringProperty email;
    private SimpleStringProperty absenceDate;
    private Button isJustified;

    // Constructor
    public Secretary(String id, String firstName, String lastName, String nickName, String email,
                     String absenceDate, Button btn) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.nickName = new SimpleStringProperty(nickName);
        this.email = new SimpleStringProperty(email);
        this.absenceDate = new SimpleStringProperty(absenceDate);
//        this.period = new SimpleStringProperty(period);
        this.isJustified = btn;
    }

    // Getters
    public String getId() {
        return id.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getNickName() {
        return nickName.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getAbsenceDate() {
        return absenceDate.get();
    }

    public Button getIsJustified() {
        return isJustified;
    }

}

