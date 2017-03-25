package Entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class SessionPK implements Serializable {
    private Timestamp sessionTime;
    private int trackId;
}
