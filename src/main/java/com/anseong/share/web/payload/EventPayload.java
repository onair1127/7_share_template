package com.anseong.share.web.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventPayload {

     public String path;

     public String body;
     
     public void setPath(String path) {
          this.path = path;
     }

     public void setBody(String body) {
          this.body = body;
     }

     public String getPath() {
          return path;
     }

     public String getBody() {
          return body;
     }

     @Override
     public String toString() {
          return "EventPayload [path=" + path + ", body=" + body + "]";
     }
}
