import java.util.Scanner;

public class Driver_Program {
	
	public static void main(String[] args) {
		
		boolean ON = false;
		boolean Blocked = true;
		boolean playing = false;
		ICancion[] My_IPodSongs = new ICancion[50];
		ICancion[] My_FavoriteSongs = new ICancion[10];
		int CurrentSongIndex = 0;
		float volume = 0;
		
		Scanner Strscaner = new Scanner(System.in);
		
		IPodController Controller = new IPodController(ON, Blocked, My_IPodSongs, My_FavoriteSongs, CurrentSongIndex, volume);  
		
		String status = Controller.getStatus(ON, Blocked, playing, My_IPodSongs[CurrentSongIndex]); 
		
		String opcion = "0";
		
		while(!opcion.equals("8")) {
			
			/**
			 * The call for the method to 
			 */
			opcion = ShowIPod(Strscaner, status);
			
			
			if (opcion.equals("1")){
				ON = Controller.SwitchONOFF(ON);
				if(!ON) {
					playing = false;
					Blocked = Controller.LockUnlockDevice(Blocked);
				}
			}
			
			if(opcion.equals("9")){
				System.exit(0);
			}
			
			if (ON) {
				
				if(opcion.equals("2")){
					
				}
				
				else if(opcion.equals("3")){
					
				}
				
				else if(opcion.equals("4")){
					
				}
				
				else if(opcion.equals("5")){
					
				}
				
				else if(opcion.equals("6")){
					
				}
				
				else if(opcion.equals("7")){
					
				}
				
				else if(opcion.equals("8")){
					
				}
				
			}
			else {
				System.out.println("No se puede realizar la accion, el IPod esta apagado");
			}
			
			status = Controller.getStatus(ON, Blocked, playing, My_IPodSongs[CurrentSongIndex]);
			
		}
		
		
	
	
		
	}
	
	public static String ShowIPod(Scanner _strScan, String Status) {
		System.out.println("**********************************");
		System.out.println("*Bienvenido al simulador de IPOD**");
		System.out.println("**********************************");
		System.out.println(Status);
		System.out.println("\nQue Deseas hacer: \n"
						+ "1.Cambiar estado (Encendido/Apgado) \n"
						+ "2.Poner play a la cancion \n"
						+ "3.Bloquear/Desbloquear \n"
						+ "4.Ir a la siguiente Cancion\n"
						+ "5.Ir a la cancion anterior\n"
						+ "6.Agregar una cancion\n"
						+ "7.Agregar la cancion actual al top 10 favoritos\n"
						+ "8.Poner una cancion de la lista de favoritos\n"
						+ "9.Salir de la simulacion");
		String Selection = _strScan.next();
		return Selection;
		
	}	
	
	
}
