import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassroomController {
	
	StudentModel studentModel;
	StudentView studentView;
	
	public ClassroomController(StudentModel model, StudentView view){
		this.studentModel = model;
		this.studentModel.setLocation("./data/classroomData.properties");
		this.studentView = view;
		
		initialize();
	}
	
	public void initialize(){
		studentView.retrivedPannel.setText("Waiting");
		studentView.addRetrivalListener(new Retrival());
	}
	
	public class Retrival implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			studentModel.setStudentData();
			studentView.DisplayData("");
			studentView.DisplayData(studentModel.printStudentData());
		}
		
	}
	
}
