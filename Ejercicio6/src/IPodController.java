
public class IPodController implements IIpod_simulator{
	private boolean ON;
	private boolean Blocked;
	private ICancion[] My_IPodSongs;
	private ICancion[] My_FavoriteSongs;
	private int CurrentSongIndex;
	private float Volume;
	
	
	public IPodController(boolean on, boolean bloqued, ICancion[] allSongs, ICancion[] FavSongs, int currentSong, float _volume) {
		ON = on;
		Blocked = bloqued;
		My_IPodSongs = allSongs;
		My_FavoriteSongs = FavSongs;
		CurrentSongIndex = currentSong;
		Volume = _volume;	
	}

	@Override
	public boolean SwitchONOFF(boolean actual_state) {
		
		if(actual_state) {
			ON = false;
			return ON; 
		}
		
		else if(actual_state == false) {
			//System.out.println(actual_state);
			ON = true;
			return ON; 
		}
		
		
		return false;
	}

	
	@Override
	public boolean LockUnlockDevice(boolean actual_locked_state) {
		if(actual_locked_state) {
			Blocked = false;
			return Blocked;
		}
		return true;
	}

	@Override
	public float getVolume() {
		return Volume;
	}

	@Override
	public float setVolume(float volume) {
		Volume = volume; 
		return Volume;
	}

	@Override
	public int Prev(int actual_index) {
		if(actual_index - 1 < 0) {
			return 49;
		}
		
		return actual_index - 1;
	}

	@Override
	public int Next(int actual_index) {
		if(actual_index + 1 > 49) {
			return 0;
		}
		
		return actual_index + 1;
	}
	
	@Override
	public int getActualIndex() {
		return CurrentSongIndex;
	}

	@Override
	public void setActualIndex(int actual_index) throws Exception {
		try {
			
			if(actual_index < 49) {
				CurrentSongIndex = actual_index;
			}
			
		} catch (Exception e) {
			System.out.println("El indice elegido esta fuera del rango posible de las canciones");
		}
		
	}

	@Override
	public void addToFavorite(ICancion _song) throws Exception {
		
		try {
			for(int i = 0; i < My_FavoriteSongs.length; i++) {
				
				if(My_FavoriteSongs[i] == null && _song != null) {
					My_FavoriteSongs[i] = _song;
					System.out.println("Cancion Agregada a favoritos");
					return;
				}
				
			}
			
			System.out.println("No se pudo agregar la cancion, el espacio actual esta vacio o la lista esta llena");
			
		} catch (Exception e) {
			System.out.println("La lista de favoritos ya esta llena");
		}
		
	}

	@Override
	public ICancion selectSpecificSong(int index) throws Exception {
		try {
			return My_IPodSongs[index];
			
		} catch (Exception e) {
			System.out.println("No se encontro una cancion en el indice solicitado");
		}
		
		return null;
	}

	@Override
	public ICancion selectSpecificFavoriteSong(int index) throws Exception {
		try {
			return My_FavoriteSongs[index];
			
		} catch (Exception e) {
			System.out.println("No se encontro una cancion en el indice solicitado");
		}
		
		return null;
	}

	@Override
	public ICancion[] getAllSongs() {
		
		return My_IPodSongs;
	}

	@Override
	public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong) {
		String on = "", locked = "", playing = "";
		String song = "";
		
		if(_isON) {
			on = "Encendido";
			
		}
		if(!_isON){
			on = "Apagado";
		}
		
		if(_isLocked) {
			locked = "Bloqueado";
		}
		
		if(!_isLocked) {
			locked = "Desbloqueado";
		}
		
		if(_isPlaying) {
			playing = "Reproduciendo";
		}
		
		if(!_isPlaying) {
			playing = "Reproduccion en pausa";
		}
		
		try {
			song = " Cancion: " + _actualSong.getTitle() +
					" Artist: " + _actualSong.getArtist() +
					" Album: " + _actualSong.getAlbum() +
					" Duracion: " + _actualSong.getDuration(); 
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String status = "El IPod esta en estado de: " + on + " y "+ locked + ". " + playing + song;
		return status;
	}

	@Override
	public boolean isValidIndex(int index) {
		if(index >= 0 && index <= 10) {
			return true;
		}
		return false;
	}

	@Override
	public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id)
			throws Exception {
		try {
			for(int i = 0; i < My_IPodSongs.length; i++) {
				
				if(My_IPodSongs[i] == null) {
					My_IPodSongs[i] = new Cancion(_titulo, _artista, _album, _duracion, i);
					break;
				}
			}
			System.out.println("Agregado");
			
		} catch (Exception e) {
			System.out.println("No hay espacio disponible para agregar mas canciones a la lista");
		}
		
	}

	@Override
	public void deleteSongFromList(int index) throws Exception {
		try {
			My_IPodSongs[index] = null;
			System.out.println("Se a borrado la informacion en la posicion: " + index);
		} catch (Exception e) {
			System.out.println("Indice fuera de rango");
		}
		
		
	}

	@Override
	public void deleteSongFromTop10(int index) throws Exception {
		try {
			My_FavoriteSongs[index] = null;
			System.out.println("Se a borrado la informacion en la posicion: " + index);
		} catch (Exception e) {
			System.out.println("Indice fuera de rango");
		}
		
	}

}
