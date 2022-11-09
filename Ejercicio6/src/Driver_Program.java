import java.util.Scanner;

public class Driver_Program {
	
	/**
	 * Driver Program made By Rcaro Chuy 221007
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean ON = false;
		boolean Blocked = true;
		boolean playing = false;
		ICancion[] My_IPodSongs = new ICancion[50];
		ICancion[] My_FavoriteSongs = new ICancion[10];
		int CurrentSongIndex = 0;
		float volume = 0;
		
		if(My_IPodSongs[CurrentSongIndex] == null) {
			System.out.println("Es null");
		}
		
		Scanner Strscaner = new Scanner(System.in);
		
		IPodController Controller = new IPodController(ON, Blocked, My_IPodSongs, My_FavoriteSongs, CurrentSongIndex, volume);  
		
		String status = Controller.getStatus(ON, Blocked, playing, My_IPodSongs[CurrentSongIndex]); 
		
		String opcion = "0";
		
		while(!opcion.equals("15")) {
			
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
			if(opcion.equals("15")){
				System.exit(0);
			}
			
			/**
			 * Checking for the ipod to be ON
			 */
			if (ON) {
				
				/**
				 * Checking for the ipod to be unlocked
				 */
				if(opcion.equals("2")){
					Blocked = Controller.LockUnlockDevice(Blocked);
				}
				
				/**
				 * If the ipod is both on and unlocked
				 */
				if(!Blocked) {
					
					/**
					 * Volume up
					 */
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
					
					/**
					 * Volume down
					 */
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
					
					/**
					 * Play or pause a song
					 * This variables are handled in the UI as there where no specific mehtods for this variables
					 * declared on the interface
					 */
					else if(opcion.equals("5")){
						if(playing) {
							playing = false;
						}
						else {
							playing = true;
						}
					}
					
					/**
					 * Go to the next space for song in the ipod (from 0 to 49)
					 */
					else if(opcion.equals("6")){
						CurrentSongIndex = Controller.Next(CurrentSongIndex);
						System.out.println("Posicion Actual del reproductor: " + CurrentSongIndex);
					}
					
					/**
					 * Go to the previous space for song in the ipod (from 0 to 49)
					 */
					else if(opcion.equals("7")){
						CurrentSongIndex = Controller.Prev(CurrentSongIndex);
						System.out.println("Posicion Actual del reproductor: " + CurrentSongIndex);
					}
					
					/**
					 * Adding a song to the list of current songs
					 */
					else if(opcion.equals("8")){
						AddSong(Strscaner, Controller);
						My_IPodSongs = Controller.getAllSongs();
					}
					
					/**
					 * Add song to the favorite lists
					 */
					else if(opcion.equals("9")){
						ICancion _song = My_IPodSongs[CurrentSongIndex];
						try {
							Controller.addToFavorite(My_IPodSongs[CurrentSongIndex]);							
							}
								
						 catch (Exception e) {
							System.out.println("No se pudo agregar la cancion, el espacio actual esta vacio o la lista esta llena");
						}
						
					}
					
					/**
					 * Search a song for an speciic index, it can be a song from the general list or from favorites
					 */
					else if(opcion.equals("10")){
						
						System.out.println("La cancion es: \n1.De Lista General \n2.De Favoritos");
						String Selection = Strscaner.next();
						
						System.out.println("Cual es la posicion de la cancion que deseas buscar");
						int Selection2 = Strscaner.nextInt();
						
						if(Selection.equals("1")) {
						try {
							ICancion song =  Controller.selectSpecificSong(Selection2);
							System.out.println("Se reprodujo la cancion: " + song.getTitle() + " del artista " + song.getArtist() + " del album " + song.getAlbum()
												+ "\nCon un tiempo de: " + song.getDuration() + " Que se encuentra en la posicion: " + song.getID());
						} catch (Exception e) {
							System.out.println("No se encontro una cancion para la posicion solicitada");
						}
								
						}
						else if(Selection.equals("2")) {
							try {
								ICancion song =  Controller.selectSpecificFavoriteSong(Selection2);
								System.out.println("Se reprodujo la cancion: " + song.getTitle() + " del artista " + song.getArtist() + " del album " + song.getAlbum()
													+ "\nCon un tiempo de: " + song.getDuration() + "Que se encuentra en la posicion: " + song.getID());
							} catch (Exception e) {
								System.out.println("No se encontro una cancion para la posicion solicitada");
							}
						}
						
					}
					
					/**
					 * Deleteing song from main playlist
					 */
					else if(opcion.equals("11")){
						System.out.println("¿Cual es la posicion de la cancion que deseas eliminar?");
						int indexToDelete = Strscaner.nextInt();
						try {

							Controller.deleteSongFromList(indexToDelete);
						} catch (Exception e) {
							System.out.println("La posicion solicitada no es valida");
						}
					}
					
					/**
					 * Deleting songr from favorite songs
					 */
					else if(opcion.equals("12")){
						System.out.println("¿Cual es la posicion de la cancion que deseas eliminar?");
						int indexToDelete = Strscaner.nextInt();
						try {

							Controller.deleteSongFromTop10(indexToDelete);
						} catch (Exception e) {
							System.out.println("La posicion solicitada no es valida");
						}
					}
					
					/**
					 * Showing al songs from the general list
					 */
					else if(opcion.equals("13")){
						showMySongs(My_IPodSongs);
					}
					
					/**
					 * Showing al songos from favorites
					 */
					else if(opcion.equals("14")){
						showMySongs(My_FavoriteSongs);
					}
					
					else if(opcion.equals("112")){
						
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
	
	/**
	 * Display of the main menu
	 * @param _strScan Scanner for input
	 * @param Status A string that contains all the currente status of the simulator
	 * @return
	 */
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
						+ "10.Poner una cancion especifica\n"
						+ "11.Eliminar cancion de lista general\n"
						+ "12.Eliminar cancion de favoritos\n"
						+ "13.Mostrar Lista de Canciones\n"
						+ "14.Mostrar Lista de Favoritos\n"
						+ "15.Salir de la simulacion\n");
		String Selection = _strScan.next();
		return Selection;
		
	}	
	
	/**
	 * Method that asks the necessary information to create and save a new song to the Main Song List
	 * @param _strScan scanner for input
	 * @param controller logic controller to create a new objecto Cancion
	 */
	public static void AddSong(Scanner _strScan, IPodController controller) {
		
		System.out.println("¿Cual es el nombre de la cancion?");
		String songName = _strScan.next();
		
		System.out.println("¿Quien es el autor de la cancion?");
		String songArtist = _strScan.next();
		
		System.out.println("¿A que album pertenece la cancion?");
		String songAlbum = _strScan.next();
		
		System.out.println("¿Cuanto dura la cancion?");
		String songDuration = _strScan.next();
		
		try {
			controller.addSongToList(songName, songArtist, songAlbum, songDuration, 0);
		} catch (Exception e) {
			System.out.println("Error al agregar la cancino");
			e.printStackTrace();
		}
		
		return ;
		
	}
	/**
	 * Method that shosthe content of a list of songs that implement ICancion
	 * @param Mysongs
	 */
	public static void showMySongs(ICancion[] Mysongs) {
		System.out.println("Lista de Canciones: \n");
		for (int i = 0; i < Mysongs.length; i++) {
			if(Mysongs[i] != null) {
				ICancion song = Mysongs[i];
				System.out.println("Cancion: " + song.getTitle() + ", Artista " + song.getArtist() + ", Album: " + song.getAlbum()
				+ "Duracion: " + song.getDuration() + "Posicion: " + i);
			}
		}
		
	}
	
	
}
