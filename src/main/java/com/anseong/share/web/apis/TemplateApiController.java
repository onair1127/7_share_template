package com.anseong.share.web.apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.anseong.share.domain.application.services.ImageService;
import com.anseong.share.domain.model.image.ImageId;
import com.anseong.share.domain.model.image.ShareTemplateImage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateApiController {
     
     private static final Logger log = LoggerFactory.getLogger(TemplateApiController.class);
     
     private final ImageService imageService;

     public TemplateApiController(ImageService imageService) {
          this.imageService = imageService;
     }

     @GetMapping("/image/{imageId}")
     public ModelAndView test(
          @PathVariable String imageId
     ) {
          log.info("공유 템플릿 생성 ID : {}", imageId);

          ModelAndView template = new ModelAndView();
          template.setStatus(HttpStatus.OK);

          try {
               ShareTemplateImage image = imageService.findImageForShareTemplateImage(new ImageId(Long.parseLong(imageId)));

               if (image == null) {
                    template.setViewName("imageNotFound");

               } else {
                    template.setViewName("share");
                    template.addObject("image", image);
               }

               return template;

          } catch (Exception e) {
               log.warn("공유 템플릿 생성 실패 : [{} : {}]", imageId, e.getMessage());

               template.setViewName("imageNotFound");
               return template;
          }
     }
}