package blade.messenger.service.impl;

import blade.messenger.repository.RegistrationRepository;
import blade.messenger.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blade.messenger.entity.User;
import blade.messenger.entity.UserRole;
import blade.messenger.service.RegistrationService;

/**
 * Registration service implementation.
 * @author zagnitko.
 */
@Service
@Primary
@Transactional("transactionManager")
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository repository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void addUser(User user) {
        repository.save(user);
        userRolesRepository.save(new UserRole(null, user.getUsername(), "ROLE_USER"));
    }

    @Override
    public Long checkIfExists (String username) {
        return repository.checkIfExists(username);
    }
}
