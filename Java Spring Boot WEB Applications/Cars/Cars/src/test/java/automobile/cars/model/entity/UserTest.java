package automobile.cars.model.entity;

import org.junit.jupiter.api.Test;
import automobile.cars.model.enums.RoleEnum;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setId(1);
        user.setUsername("john_doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1);
        role.setRole(RoleEnum.PRIVATE_USERS);
        roles.add(role);

        user.setRoles(roles);

        Set<Long> favoriteCarIds = new HashSet<>();
        favoriteCarIds.add(123L);
        favoriteCarIds.add(456L);

        user.setFavoriteCarIds(favoriteCarIds);

        assertEquals(1, user.getId());
        assertEquals("john_doe", user.getUsername());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals(roles, user.getRoles());
        assertEquals(favoriteCarIds, user.getFavoriteCarIds());
    }
}
