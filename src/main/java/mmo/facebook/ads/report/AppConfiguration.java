/**
 * 
 */
package mmo.facebook.ads.report;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Admin
 *
 */
@Configuration
@EnableSwagger2
public class AppConfiguration {
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper()
	            .registerModule(new ParameterNamesModule())
	            .registerModule(new Jdk8Module())
	            .registerModule(new JavaTimeModule());
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	 // Ignore null values when writing json.
	    mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
	    mapper.setSerializationInclusion(Include.NON_NULL);
	    
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setDateFormat(new StdDateFormat());
	    MappingJackson2HttpMessageConverter converter = 
	        new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	}
	
	@Bean
	public ObjectMapper objectMapper() {
	    ObjectMapper mapper = new ObjectMapper()
	            .registerModule(new ParameterNamesModule())
	            .registerModule(new Jdk8Module())
	            .registerModule(new JavaTimeModule());
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	 // Ignore null values when writing json.
	    mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
	    mapper.setSerializationInclusion(Include.NON_NULL);
	    
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setDateFormat(new StdDateFormat());
	    return mapper;
	}
	
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
	    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	        @Override
	        public void customize(Connector connector) {
	            connector.setProperty("relaxedQueryChars", "|{}[]");
	        }
	    });
	    return factory;
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
