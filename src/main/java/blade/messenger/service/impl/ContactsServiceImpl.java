package blade.messenger.service.impl;

import java.util.ArrayList;
import java.util.List;

import blade.messenger.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blade.messenger.dto.ContactDTO;
import blade.messenger.entity.Contact;
import blade.messenger.service.ContactsService;

/**
 * Contacts service implementation.
 * @author zagnitko.
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsRepository repository;

    @Override
    public List<ContactDTO> getUserContactsSelect2(String username) {
        List<ContactDTO> retList = new ArrayList<>();
        for (Contact contact : repository.getUserContacts(username)) {
            retList.add(new ContactDTO(contact.getSlave(), contact.getSlave()));
        }
        return retList;
    }

    @Override
    public void addUserToContacts(String username, String userToAdd) {
        repository.save(new Contact(null, username, userToAdd));
    }

    @Override
    public void deleteContactByUser(String username, String userToDelete) {
        repository.deleteContactByUser(username, userToDelete);
    }
}
