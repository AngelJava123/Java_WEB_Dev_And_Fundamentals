package automobile.cars.service;

import automobile.cars.model.entity.Term;
import automobile.cars.repository.TermsRepository;
import automobile.cars.view.TermsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TermService {

    private final TermsRepository termsRepository;
    private final ModelMapper modelMapper;

    public TermService(TermsRepository termsRepository, ModelMapper modelMapper) {
        this.termsRepository = termsRepository;
        this.modelMapper = modelMapper;
    }

    public TermsViewModel getTermsInfo() {
        Optional<Term> terms = termsRepository.findById(1L);

        return modelMapper.map(terms, TermsViewModel.class);
    }

}
