package com.anseong.share;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.thymeleaf.TemplateEngine;

import com.anseong.share.web.apis.ShareApiController;

@SpringBootTest(
     classes = ShareApplication.class,
     webEnvironment = WebEnvironment.RANDOM_PORT
)
@ImportAutoConfiguration(classes = ThymeleafAutoConfiguration.class)
class ShareApplicationTests {

     @Autowired
     private ShareApiController controller;

     @Autowired
     private TemplateEngine templateEngine;

	@Test
	void test() throws Exception {
          try {
               System.out.println(templateEngine.getTemplateResolvers().size());

               ModelAndView successResult = controller.shareTemplate(104);
               ModelAndView failureResult = controller.shareTemplate(0);

               assertEquals(successResult.getStatus(), HttpStatus.OK);
               assertEquals(failureResult.getStatus(), HttpStatus.NOT_FOUND);
          } catch (Exception e) {
               e.printStackTrace();
          }
	}
}
