package com.anseong.share.infrastructure.repository;

import jakarta.persistence.EntityManager;

import com.anseong.share.domain.model.image.ImageId;
import com.anseong.share.domain.model.image.ShareTemplateImage;
import com.anseong.share.domain.model.image.repository.ImageRepository;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateImageRepository extends HibernateSupport<ShareTemplateImage> implements ImageRepository {

     HibernateImageRepository(EntityManager entityManager) {
          super(entityManager);
     }

     @Override
     public ShareTemplateImage findImageForShareTemplateImage(ImageId imageId) {
          String sqlString = 
               "SELECT sti " + 
               "FROM ShareTemplateImage sti INNER JOIN FETCH sti.store s " + 
               "WHERE sti.id = :imageId";

          Query<ShareTemplateImage> query = getSession().createQuery(sqlString, ShareTemplateImage.class);
          query.setParameter("imageId", imageId.value());

          return query.uniqueResult();
     }
}
