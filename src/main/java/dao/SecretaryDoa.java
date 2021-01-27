package dao;

import javafx.scene.control.Button;

import java.sql.SQLException;

public interface SecretaryDoa {
    // Get all absent students
    void getAllAbsentStudents() throws SQLException, ClassNotFoundException;

    // For creating action buttons
    Button createActionButtons(String btnId);

    // initialize style based on window size
    void initTableWindowStyle();

    // to justify student absence
    void markAbsenceJustified(String absenceID) throws SQLException, ClassNotFoundException;
}
