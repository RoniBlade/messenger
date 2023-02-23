package blade.messenger.service;

import blade.messenger.entity.User;

/**
 * Registration service.
 * @author zagnitko.
 */
public interface RegistrationService {

    void addUser(User user);

    Long checkIfExists(String username);
}
