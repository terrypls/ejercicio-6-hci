package observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView extends Observable implements ActionListener {

    JTextField stId = new JTextField(20);
    JTextField stName = new JTextField(20);
    JTextArea showData = new JTextArea(40, 20);
    JButton addButton = new JButton("Add Student");
    JButton updateButton = new JButton("Update Student");
    JButton deleteButton = new JButton("Delete Student");


    StudentView() {
        JFrame frame = new JFrame("StudentView");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        JLabel idLabel = new JLabel("Student Id");
        idLabel.setBounds(10, 20, 80, 25);
        panel.add(idLabel);

        stId.setBounds(100, 20, 165, 25);
        panel.add(stId);

        JLabel nameLabel = new JLabel("Student Name");
        nameLabel.setBounds(10, 50, 80, 25);
        panel.add(nameLabel);

        stName.setBounds(100, 50, 165, 25);
        panel.add(stName);

        addButton.setBounds(10, 80, 120, 25);
        panel.add(addButton);

        updateButton.setBounds(130, 80, 130, 25);
        panel.add(updateButton);

        deleteButton.setBounds(260, 80, 120, 25);
        panel.add(deleteButton);

        showData.setBounds(10, 120, 350, 250);
        showData.setBackground(new Color(200, 200, 200));
        showData.setEditable(false);
        panel.add(showData);
        frame.setVisible(true);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
    }

    public void updateView(StudentModel sm) {
        showData.setText(sm.getList());
    }

    public String getIdText() {
        return stId.getText();
    }

    public String getNameText() {
        return stName.getText();
    }

    public void actionPerformed(ActionEvent e) {
        String observer = "";
        if (e.getSource() == this.addButton) {
            notifyObservers();
            observer = "add";
        }
        if (e.getSource() == this.deleteButton) {
            notifyObservers();
            observer = "delete";
        }
        if (e.getSource() == this.updateButton) {
            observer = "update";
        }
        setChanged();
        notifyObservers(observer);
    }
}