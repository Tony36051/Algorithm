import java.io.FileNotFoundException;


public class WriteData {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		java.io.File file = new java.io.File("scores.txt");
		if(file.exists()){
			System.out.println("File already exists.");
		}
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		output.print("Tony ng ");
		output.println(100);
		output.print("CK");
		
		output.close();
	}

}
