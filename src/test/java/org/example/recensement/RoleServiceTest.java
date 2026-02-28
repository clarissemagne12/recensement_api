package org.example.recensement;


import org.example.recensement.entities.Role;
import org.example.recensement.repositories.RoleRepository;
import org.example.recensement.services.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByIdFound() {
        Role role = new Role();
        role.setLibelle("Admin");

        when(roleRepository.findById(1L)).thenReturn(Optional.of(role));

        Optional<Role> found = roleService.findById(1L);
        assertTrue(found.isPresent());
        assertEquals("Admin", found.get().getLibelle());
    }

    @Test
    void testSaveRole() {
        Role role = new Role();
        role.setLibelle("ADMIN");

        Role savedRole = new Role();
        savedRole.setId(1L); // 👈 ID simulé
        savedRole.setLibelle("ADMIN");

        when(roleRepository.save(any(Role.class))).thenReturn(savedRole);

        Role result = roleService.save(role);

        assertNotNull(result.getId());
    }

    @Test
    void testDeleteByI() {
        when(roleRepository.existsById(1L)).thenReturn(true);

        roleService.deleteById(1L);

        verify(roleRepository, times(1)).deleteById(1L);
    }

}
