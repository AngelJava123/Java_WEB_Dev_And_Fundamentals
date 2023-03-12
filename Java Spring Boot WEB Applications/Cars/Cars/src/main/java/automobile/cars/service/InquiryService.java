package automobile.cars.service;

import automobile.cars.model.dto.InquiryDTO;
import automobile.cars.model.entity.Inquiry;
import automobile.cars.model.entity.User;
import automobile.cars.repository.InquiryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final ModelMapper modelMapper;

    public InquiryService(InquiryRepository inquiryRepository, ModelMapper modelMapper) {
        this.inquiryRepository = inquiryRepository;
        this.modelMapper = modelMapper;
    }

    public boolean send(InquiryDTO inquiryDTO) {

        Inquiry inquiry = modelMapper.map(inquiryDTO, Inquiry.class);
        this.inquiryRepository.save(inquiry);

        return true;
    }
}
