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
		
		while(!opcion.equals("11")) {
			
			/**
			 * The call for the method to show the status, it is shown independently if its on or off
			 */
			opcion = ShowIPod(Strscaner, status);
			
			/**
			 * Turning on the Ipod
			 */
			if (opcion.equals("1")){
				ON = Controller.SwitchONOFF(ON);
				if(!ON) {
					playing = false;
					Blocked = Controller.LockUnlockDevice(false);
				}
			}
			
			/**
			 * Checking if the option was to quit the emulator
			 */
			if(opcion.equals("11")){
				System.exit(0);
			}
			
			/**
			 * Checking for the ipod to be ON
			 */
			if (ON) {
				
				
				if(opcion.equals("2")){
					Blocked = Controller.LockUnlockDevice(Blocked);
				}
				
				/**
				 * Checking for the ipod to be unlocked
				 */
				if(!Blocked) {
					
					if(opcion.equals("3")){
						
						if (volume + 0.5 < 10) {
							
							volume += 0.5;
							
							volume = Controller.setVolume(volume);
							
							System.out.println("Volumen actual: " + volume);
						}
						else {
							volume = 10;
							System.out.println("Volumen actual: " + volume);
						}
						
					}
					
					else if(opcion.equals("4")){
						if (volume - 0.5 > 0) {
							
							volume -= 0.5;
							
							volume = Controller.setVolume(volume);
							
							System.out.println("Volumen actual: " + volume);
						}
						else {
							volume = 0;
							System.out.println("Volumen actual: " + volume);
						}
					}
					
					else if(opcion.equals("5")){
						if(playing) {
							playing = false;
						}
						else {
							playing = true;
						}
					}
					
					else if(opcion.equals("6")){
						CurrentSongIndex = Controller.Next(CurrentSongIndex);
						System.out.println("Posicion Actual del reproductor: " + CurrentSongIndex);
					}
					
					else if(opcion.equals("7")){
						CurrentSongIndex = Controller.Prev(CurrentSongIndex);
						System.out.println("Posicion Actual del reproductor: " + CurrentSongIndex);
					}
					
					else if(opcion.equals("8")){
						
					}
					
					else if(opcion.equals("8")){
						
					}
					
					else if(opcion.equals("9")){
						
					}
					
					else if(opcion.equals("10")){
						
					}
					
				}
				/**
				 * Message when ipod is Bloqued
				 */
				else {
					System.out.println("IPod esta bloqueado");
				}
				
				
			}
			
			/**
			 * Message whe ipod is OFF
			 */
			else {
				System.out.println("El IPod esta apagado");
			}
			
			/**
			 * Refreshing Status
			 */
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
						+ "2.Bloquear/Desbloquear\n"
						+ "3.Subir volumen\n"
						+ "4.Bajar Volumen\n"
						+ "5.Poner play/pausar cancion \n"
						+ "6.Ir a la siguiente Cancion\n"
						+ "7.Ir a la cancion anterior\n"
						+ "8.Agregar una cancion\n"
						+ "9.Agregar la cancion actual al top 10 favoritos\n"
						+ "10.Poner una cancion de la lista de favoritos\n"
						+ "11.Salir de la simulacion");
		String Selection = _strScan.next();
		return Selection;
		
	}	
	
	
}
