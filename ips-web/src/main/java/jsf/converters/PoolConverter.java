package jsf.converters;

import dto.PoolDto;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("poolConverter")
public class PoolConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        PoolDto poolDto = new PoolDto();
        poolDto.setName(value);
        return poolDto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        PoolDto poolDto = (PoolDto) value;
        return poolDto.getName();
    }
}
