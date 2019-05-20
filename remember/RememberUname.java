package remember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RememberUname{

	private static Scanner sc;


	public static void save(String username) throws IOException {
		
		FileWriter writer= new FileWriter("src/proyecto/RememberUname");
		writer.write(username);
		writer.close();


	}
	
	
	public static String remember() throws IOException {
		String text= "";
		
		String ruta = "src/proyecto/RememberUname";
		File fichero = new File(ruta);
		sc = new Scanner(fichero);
		
		while(sc.hasNextLine()) {
			text += sc.nextLine();
			
		}
		
		return text;
		
	}


	public static String rememberuname() {
		
		return null;
	}


	public static void guardar(String text) {
		
		
	}
	
}