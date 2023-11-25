package automobile.cars.repository;
import automobile.cars.model.entity.Term;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TermsRepositoryTest {

    @Mock
    private TermsRepository termsRepository;

    @Test
    void testSaveTerm() {
        // Arrange
        Term termToSave = mock(Term.class);
        Term savedTerm = mock(Term.class);

        when(termsRepository.save(termToSave)).thenReturn(savedTerm);

        // Act
        Term resultTerm = termsRepository.save(termToSave);

        // Assert
        assertThat(resultTerm).isEqualTo(savedTerm);
    }

    @Test
    void testFindById() {
        // Arrange
        Long termId = 1L;
        Term expectedTerm = mock(Term.class);

        when(termsRepository.findById(termId)).thenReturn(Optional.of(expectedTerm));

        // Act
        Optional<Term> resultTerm = termsRepository.findById(termId);

        // Assert
        assertThat(resultTerm).isPresent().contains(expectedTerm);
    }
}
