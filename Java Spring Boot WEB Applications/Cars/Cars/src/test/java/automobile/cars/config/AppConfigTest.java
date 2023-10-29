package automobile.cars.config;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppConfigTest {

    @Test
    public void testPersonMapping() {
        ModelMapper modelMapper = new ModelMapper();

        // Create a sample Person instance
        Person source = new Person("John", "Doe", 30);

        // Map the Person to a PersonDTO
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PersonDTO destination = modelMapper.map(source, PersonDTO.class);

        // Assert that the destination object is not null
        assertNotNull(destination);

        // Now you should have a non-null fullName in the destination
        assertNotNull(destination.getFirstName());
        assertNotNull(destination.getLastName());

        // Add assertions to test the mapping
        assertEquals(destination.getFirstName(), "John");
        assertEquals(destination.getLastName(), "Doe");
        assertEquals(destination.getAge(), 30);
    }


    @Test
    public void testModelMapping() {
        ModelMapper modelMapper = new ModelMapper();

        // Create a sample SourceClass instance
        SourceClass source = new SourceClass();
        source.setName("John Doe");
        source.setAge(30);

        // Map the SourceClass to a DestinationClass
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        DestinationClass destination = modelMapper.map(source, DestinationClass.class);

        // Assert that the destination object is not null
        assertNotNull(destination);

        // Add assertions to test the mapping
        assertEquals(destination.getName(), "John Doe");
        assertEquals(destination.getAge(), 30);
    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

class PersonDTO {
    private String firstName;
    private String lastName;
    private int age;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class SourceClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class DestinationClass {
    private String name;
    private int age;

    public DestinationClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
