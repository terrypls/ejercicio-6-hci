package no_observer;

import java.awt.event.*;

class StudentController implements ActionListener {
    StudentModel stModel;
    StudentView stView;

    StudentController(StudentModel x, StudentView y) {
        stModel = x;
        stView = y;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String name = stView.getNameText();
        String id = stView.getIdText();

        if (e.getActionCommand().equals("Delete Student")) {
            stModel.delete(id);
        } else if (e.getActionCommand().equals("Update Student")) {
            stModel.update(id, name);
        } else {
            stModel.add(id, name);
        }
        stView.updateView(stModel);
    }

    public static void main(String[] args) {
        StudentModel sm = new StudentModel();
        StudentView sv = new StudentView();
        StudentController sc = new StudentController(sm, sv);
        sv.setController(sc);
    }

}