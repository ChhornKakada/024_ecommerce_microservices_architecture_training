package kh.mptc.kakada.ecommerce.user.service;

import org.keycloak.representations.idm.UserRepresentation;

public interface KeycloakUserService {

    void createKeycloakUser(UserRepresentation userRepresentation);

    UserRepresentation getKeycloakByUsername(String username);

    void updateKeycloakUser(String id, UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserById(String id);

    void deleteKeycloakUser(String id);

}
