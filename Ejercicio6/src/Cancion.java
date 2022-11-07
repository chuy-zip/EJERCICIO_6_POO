
public class Cancion implements ICancion{
	
	private String Title;
	private String Artist;
	private String Album;
	private String Duration;
	private int ID;
	
	public Cancion(String _Title, String _Artist, String _Album, String _Duration, int _ID) {
		Title = _Title;
		Artist = _Artist;
		Album = _Album;
		Duration = _Duration;
		ID = _ID;
	}

	@Override
	public void setTitle(String _title) {
		Title = _title;
		
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setArtist(String _artist) {
		Artist = _artist;
		
	}

	@Override
	public String getArtist() {
		return Artist;
	}

	@Override
	public void setAlbum(String _album) {
		Album = _album;		
	}

	@Override
	public String getAlbum() {
		return Album;
	}

	@Override
	public void setDuration(String _duration) {
		Duration = _duration;
	}

	@Override
	public String getDuration() {
		return Duration;
	}

	@Override
	public void setID(int _id) {
		ID = _id;
		
	}

	@Override
	public int getID() {
		return ID;
	}

}
