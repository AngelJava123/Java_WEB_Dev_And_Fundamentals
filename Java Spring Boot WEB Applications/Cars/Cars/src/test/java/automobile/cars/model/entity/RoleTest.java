package automobile.cars.model.entity;

import automobile.cars.model.enums.RoleEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoleTest {

    @Test
    void testHashCodeConsistency() {
        Role role = new Role();
        role.setId(1);
        role.setRole(RoleEnum.DEALERS);

        assertEquals(role.hashCode(), role.hashCode());
    }

    @Test
    void testHashCodeInequality() {
        Role role1 = new Role();
        role1.setId(1);
        role1.setRole(RoleEnum.DEALERS);

        Role role3 = new Role();
        role3.setId(2);
        role3.setRole(RoleEnum.PRIVATE_USERS);

        assertNotEquals(role1.hashCode(), role3.hashCode());
    }
}
