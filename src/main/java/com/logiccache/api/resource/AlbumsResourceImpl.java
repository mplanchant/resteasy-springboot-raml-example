package com.logiccache.api.resource;

import com.logiccache.domain.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class AlbumsResourceImpl implements AlbumsResource {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private Album blondeOnBlonde = new Album().withArtist("Bob Dylan").withReleased("1966").withTitle("Blonde on Blonde").withId(1);
    private Album harvest = new Album().withArtist("Neil Young").withReleased("1972").withTitle("Harvest").withId(2);
    private Album paris1919 = new Album().withArtist("John Cale").withReleased("1973").withTitle("Paris 1919").withId(3);

    @Override
    public GetAlbumsResponse getAlbums() throws Exception {
        List<Album> albumList = Arrays.asList(blondeOnBlonde, harvest, paris1919);
        return GetAlbumsResponse.withJsonOK(outputStream -> new ObjectOutputStream(outputStream).writeObject(albumList));
    }

    @Override
    public PostAlbumsResponse postAlbums(Album entity) throws Exception {
        LOG.info("POST albums [{}:{}:{}].", entity.getTitle(), entity.getArtist(), entity.getReleased());
        return PostAlbumsResponse.withCreated();
    }

    @Override
    public GetAlbumsByIdResponse getAlbumsById(@PathParam("id") Integer id) throws Exception {
        LOG.info("GET album {}.", id);
        return GetAlbumsByIdResponse.withJsonOK(blondeOnBlonde);
    }
}
