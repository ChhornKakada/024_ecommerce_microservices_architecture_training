package kh.mptc.kakada.ecommerce.user.service.impl;

import jakarta.ws.rs.NotFoundException;
import kh.mptc.kakada.ecommerce.user.exception.KeycloakException;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import kh.mptc.kakada.ecommerce.user.config.KeycloakAdminClientConfig;
import kh.mptc.kakada.ecommerce.user.service.KeycloakRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakRoleServiceImpl implements KeycloakRoleService {

    private final Keycloak keycloak;

    @Override
    public void assignRoles(String userId, List<RoleRepresentation> roleRepresentationList) {

        keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .get(userId)
                .roles()
                .realmLevel()
                .add(roleRepresentationList);
    }


    @Override
    public List<UserRepresentation> getUsersByRoleName(String roleName, Integer page, Integer limit) {
        if (page == null || page < 0 || limit == null || limit < 1) {
            throw new KeycloakException(
                    HttpStatus.BAD_REQUEST,
                    "page must be >= 0 and limit must be >= 1"
            );
        }
        long offset = (long) page * limit;
        if (offset > Integer.MAX_VALUE) {
            throw new KeycloakException(
                    HttpStatus.BAD_REQUEST,
                    "Requested page is too large"
            );
        }

        // validate whether the role exist
        this.getKeycloakRoleByName(roleName);
        // get user from roleName
        return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .roles()
                .get(roleName)
                .getUserMembers((int) offset, limit);
    }

    public RoleRepresentation getKeycloakRoleByName(String roleName) {
        try {
            return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                    .roles()
                    .get(roleName)
                    .toRepresentation();
        } catch (NotFoundException e) {
            throw new KeycloakException(
                    HttpStatus.NOT_FOUND,
                    "Role not found: " + roleName
            );
        }

    }

}
