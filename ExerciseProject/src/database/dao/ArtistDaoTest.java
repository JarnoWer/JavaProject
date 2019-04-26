package database.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import model.Artist;

public class ArtistDaoTest {

    @Test
    public void artistWithId50IsMetallica() {
        ArtistDao dao = new ArtistDao();
        Artist artist = dao.getArtist(50);

        assertEquals("Metallica", artist.getName());
    }

    @Test
    public void getArtistWithUnknownIdReturnsNull() {
        ArtistDao dao = new ArtistDao();
        Artist artist = dao.getArtist(-100);

        assertEquals(null, artist);
    }

    @Test
    public void getAllArtistsReturnsArtistsWithCorrectNames() {
        ArtistDao dao = new ArtistDao();
        List<Artist> allArtists = dao.getAllArtists();

        assertEquals("A Cor Do Som", allArtists.get(0).getName());
        assertEquals("Zeca Pagodinho", allArtists.get(allArtists.size() - 1).getName());
    }
}
