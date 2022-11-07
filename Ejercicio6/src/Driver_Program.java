import java.util.Scanner;

public class Driver_Program {
	
	public static void main(String[] args) {
		
		boolean ON = false;
		boolean Blocked = false;
		ICancion[] My_IPodSongs = new ICancion[50];
		ICancion[] My_FavoriteSongs = new ICancion[10];
		int CurrentSongIndex = 0;
		float volume = 0;
		
		Scanner Strscaner = new Scanner(System.in);
		
		IPodController Controller = new IPodController(ON, Blocked, My_IPodSongs, My_FavoriteSongs, CurrentSongIndex, volume);  
		
		String opcion = "0";
		
		while(!opcion.equals("8")) {
			opcion = ShowIPod(Strscaner, Controller);
			if (opcion.equals("1")){
				
			}
			
			else if(opcion.equals("2")){
				
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
				System.exit(0);
			}
			
		}
		
		
	
	
		
	}
	
	public static String ShowIPod(Scanner _strScan, IPodController a) {
		System.out.println("**********************************");
		System.out.println("*Bienvenido al simulador de IPOD**");
		System.out.println("**********************************");
		System.out.println("Que Deseas hacer: \n"
						+ "1.Cambiar estado (Encendido/Apgado) \n"
						+ "2.Bloquear/Desbloquear \n"
						+ "3.Ir a la siguiente Cancion\n"
						+ "4.Ir a la cancion anterior\n"
						+ "5.Agregar una cancion\n"
						+ "6.Agregar la cancion actual al top 10 favoritos\n"
						+ "7.Poner una cancion de la lista de favoritos\n"
						+ "8.Salir de la simulacion");
		String Selection = _strScan.next();
		return Selection;
		
	}	
	
	
}
