package com.anseong.share.domain.common.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractBaseId implements Serializable {

     private static final long serialVersionUID = 1L;

     private long id;

     public AbstractBaseId(long id) {
          this.id = id;
     }

     public long value() {
          return id;
     }

     public boolean isValid() {
          return id >= 0;
     }

     @Override
     public boolean equals(Object o) {
          if (o == this)
               return true;
          if (!(o instanceof AbstractBaseId)) {
               return false;
          }
          AbstractBaseId abstractBaseId = (AbstractBaseId) o;
          return id == abstractBaseId.id;
     }

     @Override
     public int hashCode() {
          return Objects.hashCode(id);
     }
}
