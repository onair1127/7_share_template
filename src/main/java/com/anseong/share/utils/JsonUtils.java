package com.anseong.share.utils;

import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
     private static final ObjectMapper mapper = new ObjectMapper();

     private JsonUtils() {

     }

     public static String toJson(Object object) {
          try {
               return mapper.writeValueAsString(object);
          } catch (JsonProcessingException e) {
               log.error("객체를 Json으로 write 하는데 실패.", e);
               return null;
          }
     }

     public static <T> T toObject(String json, Class<T> clazz) {
          try {
               return mapper.readValue(json, clazz);
          } catch (IOException e) {
               log.error("Json `" + json + "`을 객체 `" + clazz.getName() + "`로 읽어오는데 실패", e);
               return null;
          }
     }

     public static void write(Writer writer, Object value) throws IOException {
          mapper.writeValue(writer, value);
     }
}
