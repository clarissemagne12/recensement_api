package org.example.recensement;


import org.example.recensement.entities.Rapport;
import org.example.recensement.repositories.RapportRepository;
import org.example.recensement.services.RapportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RapportServiceTest {

    @Mock
    private RapportRepository rapportRepository;

    @InjectMocks
    private RapportService rapportService;

    // ===================== SAVE =====================

    @Test
    void testSaveRapport() {
        Rapport rapport = new Rapport();
        rapport.setDate(LocalDate.of(2024, 1, 15));

        Rapport saved = new Rapport();
        saved.setId(1L);
        saved.setDate(LocalDate.of(2024, 2, 1));

        when(rapportRepository.save(any(Rapport.class)))
                .thenReturn(saved);

        Rapport result = rapportService.save(rapport);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(LocalDate.of(2024, 2, 1), result.getDate());

        verify(rapportRepository, times(1)).save(rapport);
    }

    // ===================== FIND ALL =====================
    @Test
    void testFindAllRapports() {
        Rapport r1 = new Rapport();
        r1.setId(1L);

        Rapport r2 = new Rapport();
        r2.setId(2L);

        when(rapportRepository.findAll())
                .thenReturn(List.of(r1, r2));

        List<Rapport> result = rapportService.findAll();

        assertEquals(2, result.size());
        verify(rapportRepository, times(1)).findAll();
    }

    // ===================== FIND BY ID =====================
    @Test
    void testFindByIdFound() {
        Rapport rapport = new Rapport();
        rapport.setId(1L);

        when(rapportRepository.findById(1L))
                .thenReturn(Optional.of(rapport));

        Optional<Rapport> result = rapportService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(rapportRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Rapport> result = rapportService.findById(99L);

        assertFalse(result.isPresent());
    }

    // ===================== UPDATE =====================
    @Test
    void testUpdateRapport() {
        Rapport rapport = new Rapport();
        rapport.setId(1L);
        rapport.setDate(LocalDate.of(2024, 3, 10)); // ✅ LocalDate

        when(rapportRepository.save(rapport))
                .thenReturn(rapport);

        Rapport result = rapportService.update(rapport);

        assertEquals(LocalDate.of(2024, 3, 10), result.getDate());
        verify(rapportRepository, times(1)).save(rapport);
    }

    // ===================== DELETE =====================
    @Test
    void testDeleteById() {
        doNothing().when(rapportRepository).deleteById(1L);

        rapportService.deleteById(1L);

        verify(rapportRepository, times(1)).deleteById(1L);
    }
}