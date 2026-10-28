package kh.mptc.kakada.ecommerce.user.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminClientConfig {

    public final static String REALM_NAME = "ecommerce";

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:9090")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("ecommerce-admin-client")
                .clientSecret("SPhkrlZbDmEWJH4dyojWEzlElI1Zz0XguaG321W1Da4YnvjxPFGMhddsiE8MhtGCq9kHxTTkF4cQE5l1lDAKA9")
                .realm(REALM_NAME)
                .build();
    }

}
