package automobile.cars.repository;

import automobile.cars.model.entity.Inquiry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InquiryRepositoryTest {

    @Mock
    private InquiryRepository inquiryRepository;

    @Test
    void testSaveInquiry() {
        // Arrange
        Inquiry inquiryToSave = mock(Inquiry.class);
        Inquiry savedInquiry = mock(Inquiry.class);

        when(inquiryRepository.save(inquiryToSave)).thenReturn(savedInquiry);

        // Act
        Inquiry resultInquiry = inquiryRepository.save(inquiryToSave);

        // Assert
        assertThat(resultInquiry).isEqualTo(savedInquiry);
    }

    @Test
    void testFindById() {
        // Arrange
        Long inquiryId = 1L;
        Inquiry expectedInquiry = mock(Inquiry.class);

        when(inquiryRepository.findById(inquiryId)).thenReturn(Optional.of(expectedInquiry));

        // Act
        Optional<Inquiry> resultInquiry = inquiryRepository.findById(inquiryId);

        // Assert
        assertThat(resultInquiry).isPresent().contains(expectedInquiry);
    }
}
