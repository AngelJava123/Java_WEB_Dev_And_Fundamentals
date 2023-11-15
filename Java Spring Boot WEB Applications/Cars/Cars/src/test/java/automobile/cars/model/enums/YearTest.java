package automobile.cars.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class YearTest {

    @Test
    void testEnumValuesNotNull() {
        // Assert
        for (Year year : Year.values()) {
            assertNotNull(year, "Enum value should not be null");
        }
    }

    @Test
    void testEnumValues() {
        // Arrange
        Year[] expectedYears = {
                Year.YEAR_1998,
                Year.YEAR_1999,
                Year.YEAR_2000,
                Year.YEAR_2001,
                Year.YEAR_2002,
                Year.YEAR_2003,
                Year.YEAR_2004,
                Year.YEAR_2005,
                Year.YEAR_2006,
                Year.YEAR_2007,
                Year.YEAR_2008,
                Year.YEAR_2009,
                Year.YEAR_2010,
                Year.YEAR_2011,
                Year.YEAR_2012,
                Year.YEAR_2013,
                Year.YEAR_2014,
                Year.YEAR_2015,
                Year.YEAR_2016,
                Year.YEAR_2017,
                Year.YEAR_2018,
                Year.YEAR_2019,
                Year.YEAR_2020,
                Year.YEAR_2021,
                Year.YEAR_2022,
                Year.YEAR_2023
        };

        // Act & Assert
        assertEquals(expectedYears.length, Year.values().length, "Enum size should match");

        for (int i = 0; i < expectedYears.length; i++) {
            assertEquals(expectedYears[i], Year.values()[i], "Enum values should match");
        }
    }
}
