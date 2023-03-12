package automobile.cars.service;

import automobile.cars.model.entity.Contact;
import automobile.cars.repository.ContactRepository;
import automobile.cars.view.ContactViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactService(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    public ContactViewModel getContactInfo() {
        Optional<Contact> contact = contactRepository.findById(1L);

        return modelMapper.map(contact, ContactViewModel.class);
    }
}
