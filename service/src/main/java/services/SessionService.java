package services;

import dto.SessionDto;
import dto.SessionPkDto;

import java.util.List;

public class SessionService implements IService<SessionDto, SessionPkDto> {

    public SessionDto findById(SessionPkDto key) {
        return null;
    }

    public List<SessionDto> findAll() {
        return null;
    }

    public void insert(SessionDto sessionDto) {

    }

    public void update(SessionDto sessionDto) {

    }

    public boolean delete(SessionPkDto key) {
        return false;
    }
}
