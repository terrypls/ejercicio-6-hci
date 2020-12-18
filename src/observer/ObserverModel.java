package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverModel implements Observer {
    StudentController controller;

    public ObserverModel(StudentController controller){
        this.controller = controller;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.controller.updateView();
    }
}
