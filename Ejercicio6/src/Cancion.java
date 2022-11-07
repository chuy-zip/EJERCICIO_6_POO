
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getArtist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAlbum(String _album) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAlbum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDuration(String _duration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setID(int _id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
