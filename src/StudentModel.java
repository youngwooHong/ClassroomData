import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class StudentModel {
	
	private StudentData studentData [];
	private String classroomLocation;
	private Properties prop;
	
	public StudentModel(){
		prop = new Properties();
	}
	
	public StudentModel(String location){
		
		try{
			classroomLocation = location;
			prop = new Properties();
			prop.load(new FileInputStream("./data/classroomData.properties"));
		}
		
		catch(IOException ex){
			System.out.print(ex.getMessage());
		}
		
		catch(Exception ex){
			System.out.print(ex.getMessage());
		}
	}
	
	public void setLocation(String value){
		this.classroomLocation = value;
	}
	
	public StudentData[] getStudentData(){
		return this.studentData;
	}
	
	public void setStudentData(){

		try{
			String runnerValue = "";
			int totalStudents = Integer.parseInt(prop.getProperty("numberOfStudents"));
			int[] holder = new int[4];
			this.studentData = new StudentData[totalStudents];
			
			for(int runner = 0; runner < totalStudents; runner++){
				runnerValue = "Student" + runner + "-";
				
				this.studentData[runner] = new StudentData();
				this.studentData[runner].setFirstName(prop.getProperty(runnerValue + "firstName"));
				this.studentData[runner].setLastName(prop.getProperty(runnerValue + "lastName"));
				
				for(int testRunner = 0; testRunner < 4;testRunner++){
					holder[testRunner] = Integer.parseInt(prop.getProperty(runnerValue + "test"+testRunner));
				}
				
				this.studentData[runner].setStudentTestData(holder);
				this.studentData[runner].calculateAverage(holder);
				holder = null;
				holder = new int[4];
			}
		}
		
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	
	public String printStudentData(){
		
		StudentData printOut[] = this.studentData;
		int length  = studentData.length;
		String data = "";
		
		
		for(int runner = 0; runner < length; runner++){
			data += "First Name: " + printOut[runner].getFirstName() + "\n";
			data += "Last Name: " + printOut[runner].getLastName() + "\n";
			
			for(int runnerTwo = 0; runnerTwo < printOut[runner].getStudentTestData().length - 1; runnerTwo++){
				data += "Test "+runnerTwo + " : " + printOut[runner].getStudentTestData()[runnerTwo] + "\n";
			}
			
			data += "Average :" + printOut[runner].getAverage() + "\n";
			data += "\n";
		}
		
		return data;
	}
	
	
	
}
