package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverView implements Observer {
    StudentController controller;

    public ObserverView(StudentController controller){
        this.controller = controller;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(arg =="add"){
            controller.addStudent();
        }
        if(arg=="update"){
            controller.updateStudent();
        }
        if(arg=="delete"){
            controller.deleteStudent();
        }
    }
}
