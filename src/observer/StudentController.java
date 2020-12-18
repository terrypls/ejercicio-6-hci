package observer;


class StudentController {
    StudentModel stModel;
    StudentView stView;

    StudentController(StudentModel stModel, StudentView stView) {
        this.stModel = stModel;
        this.stView = stView;
    }

    public void updateView() {
        this.stView.updateView(this.stModel);
    }

    public void addStudent() {
        String nombre = this.stView.getNameText();
        String id = this.stView.getIdText();
        this.stModel.add(id, nombre);
    }

    public void deleteStudent() {
        String id = this.stView.getIdText();
        this.stModel.delete(id);
    }

    public void updateStudent() {
        String nombre = this.stView.getNameText();
        String id = this.stView.getIdText();
        this.stModel.update(id, nombre);
    }

    public static void main(String[] args) {
        StudentModel sm = new StudentModel();
        StudentView sv = new StudentView();
        StudentController sc = new StudentController(sm,sv);
        ObserverView Oview= new ObserverView(sc);
        ObserverModel Omodel = new ObserverModel(sc);
        sm.addObserver(Omodel);
        sv.addObserver(Oview);



    }

}