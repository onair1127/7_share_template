package com.anseong.share.domain.model.image;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

import com.anseong.share.domain.common.model.AbstractBaseEntity;
import com.anseong.share.domain.model.store.ShareTemplateStore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class ShareTemplateImage extends AbstractBaseEntity {

     private static final long serialVersionUID = -3219458826898484713L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     @Column(name = "thumbnail")
     private String thumbnail;

     @Column(name = "title")
     private String title;

     @Column(name = "description")
     private String description;

     @OneToOne(targetEntity = ShareTemplateStore.class, fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "user_id", insertable = false, updatable = false)
     private ShareTemplateStore store;

     public ImageId getId() {
          return new ImageId(id);
     }

     public String getThumbnail() {
          return thumbnail;
     }

     public String getTitle() {
          try {
               return URLDecoder.decode(title, "utf-8");
          } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
               return null;
          }
     }

     public String getDescription() {
          try {
               return URLDecoder.decode(description.length() != 0 ? description : store.getDescription(), "utf-8");
          } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
               return null;
          }
     }

     @Override
     public boolean equals(Object o) {
          if (o == this)
               return true;
          if (!(o instanceof ShareTemplateImage)) {
               return false;
          }

          ShareTemplateImage image = (ShareTemplateImage) o;

          return id == image.id 
               && Objects.equals(thumbnail, image.thumbnail)
               && Objects.equals(title, image.title)
               && Objects.equals(description, image.description)
               && Objects.equals(store, image.store);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, thumbnail, title, description, store);
     }

     @Override
     public String toString() {
          return "ShareTemplateImage [id=" + id + ", thumbnail=" + thumbnail + ", title=" + title + ", description="
                    + description + ", store=" + store + "]";
     }
}
