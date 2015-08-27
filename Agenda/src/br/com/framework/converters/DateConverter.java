package br.com.framework.converters;

import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DateConverter implements Converter {
	
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		
		return format.format(value);
	}
}
