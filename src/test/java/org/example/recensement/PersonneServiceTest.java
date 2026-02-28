package org.example.recensement;


import org.example.recensement.entities.Personne;
import org.example.recensement.repositories.PersonneRepository;
import org.example.recensement.services.PersonneService;
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
class PersonneServiceTest {

    @Mock
    private PersonneRepository personneRepository;

    @InjectMocks
    private PersonneService personneService;

    // ===================== SAVE =====================
    @Test
    void testSavePersonne() {
        Personne personne = new Personne();
        personne.setNom("Ngono");

        Personne saved = new Personne();
        saved.setId(1L);
        saved.setNom("Ngono");

        when(personneRepository.save(any(Personne.class)))
                .thenReturn(saved);

        Personne result = personneService.save(personne);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ngono", result.getNom());

        verify(personneRepository, times(1)).save(personne);
    }

    // ===================== FIND ALL =====================
    @Test
    void testFindAllPersonnes() {
        Personne p1 = new Personne();
        p1.setId(1L);

        Personne p2 = new Personne();
        p2.setId(2L);

        when(personneRepository.findAll())
                .thenReturn(List.of(p1, p2));

        List<Personne> result = personneService.findAll();

        assertEquals(2, result.size());
        verify(personneRepository, times(1)).findAll();
    }

    // ===================== FIND BY ID =====================
    @Test
    void testFindByIdFound() {
        Personne personne = new Personne();
        personne.setId(1L);

        when(personneRepository.findById(1L))
                .thenReturn(Optional.of(personne));

        Optional<Personne> result = personneService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(personneRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Personne> result = personneService.findById(99L);

        assertFalse(result.isPresent());
    }

    // ===================== UPDATE =====================
    @Test
    void testUpdatePersonne() {
        Personne personne = new Personne();
        personne.setId(1L);
        personne.setNom("Mbarga");

        when(personneRepository.save(personne))
                .thenReturn(personne);

        Personne result = personneService.update(personne);

        assertEquals("Mbarga", result.getNom());
        verify(personneRepository, times(1)).save(personne);
    }

    // ===================== DELETE =====================
    @Test
    void testDeleteById() {
        doNothing().when(personneRepository).deleteById(1L);

        personneService.deleteById(1L);

        verify(personneRepository, times(1)).deleteById(1L);
    }
}