package br.dev.rx.forumhub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.description}")
    private String appDescription;

    @Value("${spring.application.contact.name}")
    private String contactName;

    @Value("${spring.application.contact.email}")
    private String contactEmail;

    @Value("${spring.application.license.name}")
    private String licenseName;

    @Value("${spring.application.license.url}")
    private String licenseUrl;

    @Value("${spring.application.version}")
    private String appVersion;

    @Value("${api.security.token.prefix}")
    private String securityScheme;

    @Value("${api.security.token.type}")
    private String bearerFormat;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(securityScheme.toLowerCase())
                                        .bearerFormat(bearerFormat)))
                        .info(new Info()
                                .title(appName)
                                .description(appDescription)
                                .version(appVersion)
                                .contact(new Contact()
                                        .name(contactName)
                                        .email(contactEmail))
                                .license(new License()
                                        .name(licenseName)
                                        .url(licenseUrl)));
    }
}
