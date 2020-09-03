package ke.co.seatec.fulltestspingboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Bean that configures Swagger API documentation.
     *
     * @return base package of the API to be documented
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ke.co.seatec.fulltestspingboot"))
                .paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder()
                .title("Full Test Sping Boot REST API")
                .description("Basic API Tests by Andrew Eugine Simiyu")
                .license("Seatec© Copyright 2020")
                .licenseUrl("https://seatec.co.ke")
                .version("1.0.0")
                .build();

    }
}
