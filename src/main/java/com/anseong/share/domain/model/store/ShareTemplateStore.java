package com.anseong.share.domain.model.store;

import com.anseong.share.domain.common.model.AbstractBaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "store")
public class ShareTemplateStore extends AbstractBaseEntity {

     private static final long serialVersionUID = -4662154908831612827L;

     @Id
     @Column(name = "user_id")
     private long userId;

     @Column(name = "store_description")
     private String description;
     
     public long getUserId() {
          return userId;
     }

     public String getDescription() {
          return description;
     }

     @Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + (int) (userId ^ (userId >>> 32));
          result = prime * result + ((description == null) ? 0 : description.hashCode());
          return result;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          ShareTemplateStore other = (ShareTemplateStore) obj;
          if (userId != other.userId)
               return false;
          if (description == null) {
               if (other.description != null)
                    return false;
          } else if (!description.equals(other.description))
               return false;
          return true;
     }

     @Override
     public String toString() {
          return "ShareTemplateStore [userId=" + userId + ", description=" + description + "]";
     }
}
