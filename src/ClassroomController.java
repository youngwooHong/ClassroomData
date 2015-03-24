import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import org.apache.log4j.Logger;

public class ClassroomController {
	
	StudentModel studentModel;
	StudentView studentView;
	//Logger logging;
	
	public ClassroomController(StudentModel model, StudentView view){
		this.studentModel = model;
		this.studentModel.setLocation("./data/classroomData.properties");
		this.studentView = view;
		//this.logging = Logger.getLogger(ClassroomController.class);
		
		initialize();
	}
	
	public void initialize(){
		studentView.retrivedPannel.setText("Waiting");
		studentView.addRetrivalListener(new Retrival());
		//logging.debug("Initialized At Controller");
	}
	
	public class Retrival implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			studentModel.setStudentData();
			studentView.DisplayData("");
			studentView.DisplayData(studentModel.printStudentData());
		}
		
	}
	
}
