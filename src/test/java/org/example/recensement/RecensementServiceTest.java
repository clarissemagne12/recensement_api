package org.example.recensement;

import org.example.recensement.entities.Recensement;
import org.example.recensement.repositories.RecensementRepository;
import org.example.recensement.services.RecensementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecensementServiceTest {

    @Mock
    private RecensementRepository recensementRepository;

    @InjectMocks
    private RecensementService recensementService;

    // ===================== SAVE =====================
    @Test
    void testSaveRecensement() {
        Recensement recensement = new Recensement();
        recensement.setDate(LocalDate.of(2024, 1, 15));

        Recensement saved = new Recensement();
        saved.setId(1L);
        saved.setDate(LocalDate.of(2024, 2, 1));

        when(recensementRepository.save(any(Recensement.class))).thenReturn(saved);

        Recensement result = recensementService.save(recensement);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(LocalDate.of(2024, 2, 1), result.getDate());

        verify(recensementRepository, times(1)).save(recensement);
    }

    // ===================== FIND ALL =====================
    @Test
    void testFindAllRecensements() {
        Recensement r1 = new Recensement();
        r1.setId(1L);
        r1.setDate(LocalDate.of(2024, 1, 1));

        Recensement r2 = new Recensement();
        r2.setId(2L);
        r2.setDate(LocalDate.of(2024, 1, 2));

        when(recensementRepository.findAll()).thenReturn(List.of(r1, r2));

        List<Recensement> result = recensementService.findAll();

        assertEquals(2, result.size());
        verify(recensementRepository, times(1)).findAll();
    }

    // ===================== FIND BY ID =====================
    @Test
    void testFindByIdFound() {
        Recensement recensement = new Recensement();
        recensement.setId(1L);
        recensement.setDate(LocalDate.of(2024, 1, 15));

        when(recensementRepository.findById(1L)).thenReturn(Optional.of(recensement));

        Optional<Recensement> result = recensementService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals(LocalDate.of(2024, 1, 15), result.get().getDate());
    }

    @Test
    void testFindByIdNotFound() {
        when(recensementRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Recensement> result = recensementService.findById(99L);

        assertFalse(result.isPresent());
    }

    // ===================== UPDATE =====================
    @Test
    void testUpdateRecensement() {
        Recensement recensement = new Recensement();
        recensement.setId(1L);
        recensement.setDate(LocalDate.of(2024, 1, 15));

        Recensement updated = new Recensement();
        updated.setId(1L);
        updated.setDate(LocalDate.of(2024, 2, 1));

        when(recensementRepository.save(recensement)).thenReturn(updated);

        Recensement result = recensementService.update(recensement);

        assertEquals(LocalDate.of(2024, 2, 1), result.getDate());
        verify(recensementRepository, times(1)).save(recensement);
    }

    // ===================== DELETE =====================
    @Test
    void testDeleteById() {
        doNothing().when(recensementRepository).deleteById(1L);

        recensementService.deleteById(1L);

        verify(recensementRepository, times(1)).deleteById(1L);
    }
}