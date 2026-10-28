package kh.mptc.kakada.ecommerce.user.service.impl;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import kh.mptc.kakada.ecommerce.user.config.KeycloakAdminClientConfig;
import kh.mptc.kakada.ecommerce.user.exception.KeycloakException;
import kh.mptc.kakada.ecommerce.user.service.KeycloakUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakUserServiceImpl implements KeycloakUserService {

    private final Keycloak keycloak;
    private final ObjectMapper objectMapper;


    @Override
    public void createKeycloakUser(UserRepresentation userRepresentation) {

        try (Response response = this.keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .create(userRepresentation)
        ) {
            if (response.getStatus() != HttpStatus.CREATED.value()) {
                String errorBody = response.readEntity(String.class);

                String errorMessage = objectMapper.readTree(errorBody)
                        .path("errorMessage")
                        .asString("Failed to create user in Keycloak");

                throw new KeycloakException(
                        HttpStatus.valueOf(response.getStatus()),
                        errorMessage
                );
            }
        }
    }

    @Override
    public UserRepresentation getKeycloakByUsername(String username) {
        return  keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .search(username, true)
                .stream()
                .findFirst()
                .orElseThrow(() -> new KeycloakException(
                        HttpStatus.NOT_FOUND,
                        "User in Keycloak not found"
                ));
    }

    @Override
    public void updateKeycloakUser(String id, UserRepresentation userRepresentation) {
        try {
            keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                    .users()
                    .get(id)
                    .update(userRepresentation);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void deleteKeycloakUser(String id) {
        try {
            keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                    .users()
                    .get(id)
                    .remove();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public UserRepresentation getKeycloakUserById(String id) {
        try {
            return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                    .users()
                    .get(id)
                    .toRepresentation();
        } catch (NotFoundException e) {
            throw new KeycloakException(
                    HttpStatus.NOT_FOUND,
                    "User in Keycloak not found"
            );
        }
    }
}
