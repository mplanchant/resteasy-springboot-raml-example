package com.logiccache.api.resource;

import com.logicache.api.domain.Album;
import com.logicache.api.domain.AlbumImpl;
import com.logicache.api.resources.Music;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.PathParam;
import java.util.Arrays;
import java.util.List;

@Component
public class AlbumsImpl implements Music {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private Album blondeOnBlonde;
    private Album harvest;
    private Album paris1919;
    private List<Album> musicCollection;

    @PostConstruct
    private void initialiseData() {
        blondeOnBlonde = new AlbumImpl();
        blondeOnBlonde.setTitle("Blonde on Blonde");
        blondeOnBlonde.setArtist("Bob Dylan");
        blondeOnBlonde.setReleased("1966");

        harvest = new AlbumImpl();
        harvest.setTitle("Neil Young");
        harvest.setArtist("Harvest");
        harvest.setReleased("1972");

        paris1919 = new AlbumImpl();
        paris1919.setArtist("John Cale");
        paris1919.setTitle("Paris 1919");
        paris1919.setReleased("1973");

        musicCollection = Arrays.asList(blondeOnBlonde, harvest, paris1919);
    }

    @Override
    public Music.GetMusicResponse getMusic() {
        return Music.GetMusicResponse.respond200WithApplicationJson(musicCollection);
    }

    @Override
    public Music.PostMusicResponse postMusic(Album entity) {
        LOG.info("{} by {} released in {}.", entity.getTitle(), entity.getArtist(), entity.getReleased());
        return Music.PostMusicResponse.respond201();
    }

    @Override
    public Music.GetMusicByIdResponse getMusicById(@PathParam("id") int id) {
        return Music.GetMusicByIdResponse.respond200WithApplicationJson(blondeOnBlonde);
    }
}
