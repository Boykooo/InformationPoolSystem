package dao;

import Entities.Track;

import javax.ejb.Stateless;

@Stateless
public class TrackDao extends GenericDaoImpl<Track, Integer> {
    public TrackDao() {
        super(Track.class);
    }
}
