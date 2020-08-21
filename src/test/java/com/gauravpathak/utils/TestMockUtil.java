package com.gauravpathak.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMockUtil {

	public <T> T getMockResponseClass(final String fileName, final Class<T> actualClass) {

		T returnClass = null;
		try {
			String jsonStringMockResponse = new String(
					Files.readAllBytes(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI())));
			returnClass = getObjectMapper().readValue(jsonStringMockResponse, actualClass);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnClass;
	}

	private ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

}
