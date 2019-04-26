package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ChinookDatabase;
import model.Album;
import model.Artist;

public class AlbumDao {
    private ChinookDatabase db = new ChinookDatabase();

    public List<Album> getAlbumsByArtist(Artist artist) {
        Connection conn = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;

        List<Album> albums = new ArrayList<>();

        try {
            statement = conn.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
            statement.setLong(1, artist.getId());

            results = statement.executeQuery();

            while (results.next()) {
                long id = results.getLong("AlbumId");
                String title = results.getString("Title");

                albums.add(new Album(id, title));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, conn);
        }

        return albums;
    }
}
