package mmo.facebook.ads.report.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<Set<String>, String> {



	@Override
	public String convertToDatabaseColumn(Set<String> attribute) {
		// Java 8
	    return String.join(",", attribute); 
	}

	@Override
	public Set<String> convertToEntityAttribute(String dbData) {
		return Arrays.asList(dbData.split(",")).stream().collect(Collectors.toSet());
	}

	}
