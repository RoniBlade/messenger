package blade.messenger.service.impl;

import java.util.ArrayList;
import java.util.List;

import blade.messenger.repository.UserRolesRepository;
import blade.messenger.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blade.messenger.dto.UserDTO;
import blade.messenger.entity.User;
import blade.messenger.entity.UserRole;
import blade.messenger.service.UserService;

/**
 * Users service implementation.
 * @author zagnitko.
 */
@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    public void changeUsersPassword(String username, String password) {
        repository.changeUsersPassword(username, password);
    }

    public List<UserDTO> getAllUsersForSelect2() {
        List<User> userList = repository.findAll();
        List<UserDTO> retList = new ArrayList<>();
        for (User user : userList) {
            retList.add(new UserDTO(user.getUsername() + ", " + user.getName(), user.getUsername()));
        }
        return retList;
    }

    public List<UserDTO> getAllUsersForSelect2WithRoles() {
        List<User> userList = repository.findAll();
        List<UserDTO> retList = new ArrayList<>();
        for (User user : userList) {
            StringBuilder userRoles = new StringBuilder();
            for (UserRole userRole : userRolesRepository.getUserRoleByUsername(user.getUsername())) {
                userRoles.append(userRole.getRole()).append("; ");
            }
            retList.add(new UserDTO(user.getUsername() + "; " + user.getName() + "; " + userRoles,
                    user.getUsername()));
        }
        return retList;
    }

    public void deleteUser(String userToDelete) {
        userRolesRepository.deleteUserRolesByUsername(userToDelete);
        repository.deleteUser(userToDelete);
    }
}
