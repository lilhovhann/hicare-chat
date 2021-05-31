package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Address;
import io.project.app.addressbook.dto.AddressDTO;
import io.project.app.addressbook.repositories.AddressRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> createAddress(AddressDTO addressDTO) {
        log.info("AddressService: creating address");
        addressDTO.setContactId(System.currentTimeMillis());
        Address convertedData = convertDtotoEntity(addressDTO);

        Optional<Address> findAddressByPhoneNumber = addressRepository.findByPhoneNumber(convertedData.getPhoneNumber());

        if (findAddressByPhoneNumber.isPresent()) {
            log.error("address with that phone number already exists");
            return Optional.empty();
        }
        final Address savedAddress = addressRepository.save(convertedData);

        return Optional.ofNullable(savedAddress);
    }

    public Optional<Address> updateEmail(Long contactId, String email) {
        Optional<Address> updatedEmail = addressRepository.findByContactId(contactId);
        if (!updatedEmail.isPresent()) {
            log.error("Contact with contact id " + contactId + " not found");
            return Optional.empty();
        }
        Address existingAddress = updatedEmail.get();
        existingAddress.setEmail(email);
        Address updatedEmailAddress = addressRepository.save(existingAddress);
        return Optional.of(updatedEmailAddress);
    }

    public Optional<Address> updateZoom(Long contactId, String zoomId) {
        Optional<Address> updatedZoom = addressRepository.findByContactId(contactId);
        if (!updatedZoom.isPresent()) {
            log.error("Contact with contact id " + contactId + " not found");
            return Optional.empty();
        }
        Address existingAddress = updatedZoom.get();
        existingAddress.setZoomId(zoomId);
        Address updatedEmailAddress = addressRepository.save(existingAddress);
        return Optional.of(updatedEmailAddress);
    }

    public Optional<Address> updateGender(Long contactId, String gender) {
        Optional<Address> updatedEmail = addressRepository.findByContactId(contactId);
        if (!updatedEmail.isPresent()) {
            log.error("Contact with contact id " + contactId + " not found");
            return Optional.empty();
        }
        Address existingAddress = updatedEmail.get();
        existingAddress.setZoomId(gender);
        Address updatedEmailAddress = addressRepository.save(existingAddress);
        return Optional.of(updatedEmailAddress);
    }

    public Optional<Address> updateProfession(Long contactId, String profession) {
        Optional<Address> updatedEmail = addressRepository.findByContactId(contactId);
        if (!updatedEmail.isPresent()) {
            log.error("Contact with contact id " + contactId + " not found");
            return Optional.empty();
        }
        Address existingAddress = updatedEmail.get();
        existingAddress.setZoomId(profession);
        Address updatedEmailAddress = addressRepository.save(existingAddress);
        return Optional.of(updatedEmailAddress);
    }

    public String delete(Long contactId) {
        Optional<Address> updatedEmail = addressRepository.findByContactId(contactId);
        if (!updatedEmail.isPresent()) {
            log.error("Contact with contact id " + contactId + " not found");
            return "Contact not found";
        }
        Address existingAddress = updatedEmail.get();
        addressRepository.deleteByContactId(existingAddress.getContactId());

        return "deleted successfully";
    }

    public Optional<Address> findByName(String contactName) {
        Optional<Address> foundContact = addressRepository.findByContactName(contactName);
        if (!foundContact.isPresent()) {
            log.error("Contact with contact name " + contactName + " not found");
            return Optional.empty();
        }

        return foundContact;
    }

    public Optional<List<Address>> findByGender(String gender) {
        Optional<List<Address>>foundContact = addressRepository.findByGender(gender);
        if (!foundContact.isPresent()) {
            log.error("Contact with gender" + gender + " not found");
            return Optional.empty();
        }

        return foundContact;
    }

    public static AddressDTO convertEntityToDto(Address address) {
        AddressDTO addressDTOResponse = new AddressDTO();
        try {
            BeanUtils.copyProperties(address, addressDTOResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating AddressDTO response from Address", e);
        }
        return addressDTOResponse;
    }

    public static Address convertDtotoEntity(AddressDTO addressDTO) {
        Address addressResponse = new Address();
        try {
            BeanUtils.copyProperties(addressDTO, addressResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating Address from AddressDTO", e);
        }
        return addressResponse;
    }
}
