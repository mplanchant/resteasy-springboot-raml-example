package com.logiccache.api.resource;

import com.logiccache.domain.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;

@Component
public class AlbumsResourceImpl implements AlbumsResource {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Override
    public GetAlbumsResponse getAlbums() throws Exception {
        LOG.info("GET albums.");
        return null;
    }

    @Override
    public PostAlbumsResponse postAlbums(Album entity) throws Exception {
        LOG.info("POST albums [{}:{}:{}].", entity.getTitle(), entity.getArtist(), entity.getReleased());
        return null;
    }

    @Override
    public GetAlbumsByIdResponse getAlbumsById(@PathParam("id") Integer id) throws Exception {
        LOG.info("GET album {}.", id);
        return null;
    }
}
