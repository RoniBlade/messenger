package blade.messenger.service;

/**
 * UserRoles service.
 * @author zagnitko.
 */
public interface UserRolesService {

    void makeUserAdmin(String userToMakeAdmin);

    void revertAdminForUser(String userToRevertAdmin, String role);
}
