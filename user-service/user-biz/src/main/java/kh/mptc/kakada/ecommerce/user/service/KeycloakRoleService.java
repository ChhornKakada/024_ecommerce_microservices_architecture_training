package kh.mptc.kakada.ecommerce.user.service;

import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import java.util.List;

public interface KeycloakRoleService {

    void assignRoles(String userId, List<RoleRepresentation> roleRepresentationList);

    List<UserRepresentation> getUsersByRoleName(String roleName, Integer page, Integer limit);

    RoleRepresentation getKeycloakRoleByName(String roleName);

}
