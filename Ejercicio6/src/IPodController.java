
public class IPodController implements IIpod_simulator{
	private boolean ON;
	private boolean Blocked;
	private ICancion[] My_Songs;
	
	
	public IPodController() {
		
	}

	@Override
	public boolean SwitchONOFF(boolean actual_state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean LockUnlockDevice(boolean actual_locked_state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float setVolume(float volume) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Prev(int actual_index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Next(int actual_index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActualIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setActualIndex(int actual_index) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToFavorite(ICancion _song) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ICancion selectSpecificSong(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICancion selectSpecificFavoriteSong(int index) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICancion[] getAllSongs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidIndex(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSongFromList(int index) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSongFromTop10(int index) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
