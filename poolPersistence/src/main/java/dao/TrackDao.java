package dao;

import Entities.Track;

public class TrackDao extends GenericDaoImpl<Track, Integer> {
    public TrackDao() {
        super(Track.class);
    }
}
