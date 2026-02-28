package org.example.recensement;


import org.example.recensement.entities.Chefbureau;
import org.example.recensement.repositories.ChefbureauRepository;
import org.example.recensement.services.ChefbureauService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChefbureauServiceTest {

    @Mock
    private ChefbureauRepository chefbureauRepository;

    @InjectMocks
    private ChefbureauService chefbureauService;

    // ===================== SAVE =====================
    @Test
    void testSaveChefbureau() {
        Chefbureau chefbureau = new Chefbureau();
        chefbureau.setNom("Chef Bureau Central");

        Chefbureau saved = new Chefbureau();
        saved.setId(1L);
        saved.setNom("Chef Bureau Central");

        when(chefbureauRepository.save(any(Chefbureau.class)))
                .thenReturn(saved);

        Chefbureau result = chefbureauService.save(chefbureau);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Chef Bureau Central", result.getNom());

        verify(chefbureauRepository, times(1)).save(chefbureau);
    }

    // ===================== FIND ALL =====================
    @Test
    void testFindAllChefbureaux() {
        Chefbureau c1 = new Chefbureau();
        c1.setId(1L);

        Chefbureau c2 = new Chefbureau();
        c2.setId(2L);

        when(chefbureauRepository.findAll())
                .thenReturn(List.of(c1, c2));

        List<Chefbureau> result = chefbureauService.findAll();

        assertEquals(2, result.size());
        verify(chefbureauRepository, times(1)).findAll();
    }

    // ===================== FIND BY ID =====================
    @Test
    void testFindByIdFound() {
        Chefbureau chefbureau = new Chefbureau();
        chefbureau.setId(1L);

        when(chefbureauRepository.findById(1L))
                .thenReturn(Optional.of(chefbureau));

        Optional<Chefbureau> result = chefbureauService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(chefbureauRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Chefbureau> result = chefbureauService.findById(99L);

        assertFalse(result.isPresent());
    }

    // ===================== UPDATE =====================
    @Test
    void testUpdateChefbureau() {
        Chefbureau chefbureau = new Chefbureau();
        chefbureau.setId(1L);
        chefbureau.setNom("Chef Bureau Modifié");

        when(chefbureauRepository.save(chefbureau))
                .thenReturn(chefbureau);

        Chefbureau result = chefbureauService.update(chefbureau);

        assertEquals("Chef Bureau Modifié", result.getNom());
        verify(chefbureauRepository, times(1)).save(chefbureau);
    }

    // ===================== DELETE =====================
    @Test
    void testDeleteById() {
        doNothing().when(chefbureauRepository).deleteById(1L);

        chefbureauService.deleteById(1L);

        verify(chefbureauRepository, times(1)).deleteById(1L);
    }
}

