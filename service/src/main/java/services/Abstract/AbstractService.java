package services.Abstract;

import java.util.List;

public abstract class AbstractService<Dto, PK> {

    public abstract Dto findById(PK o);

    public abstract List<Dto> findAll();

    public abstract void insert(Dto o);

    public abstract void update(Dto o);

    public abstract boolean  delete(PK o);

    protected abstract Dto convertToDto();
}
