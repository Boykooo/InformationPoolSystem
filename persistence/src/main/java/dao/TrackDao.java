package dao;

import Entities.Track;

import javax.persistence.EntityManager;

public class TrackDao extends GenericDaoImpl<Track, Integer> {
    public TrackDao(EntityManager manager) {
        super(manager, Track.class);
    }
}
