package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ArtistDao artistDao = new ArtistDao();

    private AlbumDao albumDao = new AlbumDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Selvitä mitä artistia halutaan näyttää
        String idParameter = request.getParameter("id");
        long id = Long.parseLong(idParameter);

        // 2. Lataa artisti tietokannasta
        Artist artist = artistDao.getArtist(id);

        // 3. (lataa artistin albumit tietokannasta)
        List<Album> albums = albumDao.getAlbumsByArtist(artist);

        // 4. Tulosta artisti (ja albumit) vastaukseen
        response.getWriter().println(artist.getName());

        response.getWriter().println();

        for (Album album : albums) {
            response.getWriter().println(album.getTitle());
        }
    }
}
