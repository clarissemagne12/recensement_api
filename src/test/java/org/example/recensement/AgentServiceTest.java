package org.example.recensement;


import org.example.recensement.entities.Agent;
import org.example.recensement.repositories.AgentRepository;
import org.example.recensement.services.AgentService;
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
class AgentServiceTest {

    @Mock
    private AgentRepository agentRepository;

    @InjectMocks
    private AgentService agentService;

    // ===================== SAVE =====================
    @Test
    void testSaveAgent() {
        Agent agent = new Agent();
        agent.setNom("Dupont");

        Agent savedAgent = new Agent();
        savedAgent.setId(1L);
        savedAgent.setNom("Dupont");

        when(agentRepository.save(any(Agent.class)))
                .thenReturn(savedAgent);

        Agent result = agentService.save(agent);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Dupont", result.getNom());

        verify(agentRepository, times(1)).save(agent);
    }

    // ===================== FIND ALL =====================
    @Test
    void testFindAll() {
        Agent a1 = new Agent();
        a1.setId(1L);

        Agent a2 = new Agent();
        a2.setId(2L);

        when(agentRepository.findAll())
                .thenReturn(List.of(a1, a2));

        List<Agent> result = agentService.findAll();

        assertEquals(2, result.size());
        verify(agentRepository, times(1)).findAll();
    }

    // ===================== FIND BY ID =====================
    @Test
    void testFindByIdFound() {
        Agent agent = new Agent();
        agent.setId(1L);

        when(agentRepository.findById(1L))
                .thenReturn(Optional.of(agent));

        Optional<Agent> result = agentService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindByIdNotFound() {
        when(agentRepository.findById(99L))
                .thenReturn(Optional.empty());

        Optional<Agent> result = agentService.findById(99L);

        assertFalse(result.isPresent());
    }

    // ===================== UPDATE =====================
    @Test
    void testUpdateAgent() {
        Agent agent = new Agent();
        agent.setId(1L);
        agent.setNom("Martin");

        when(agentRepository.save(agent))
                .thenReturn(agent);

        Agent result = agentService.update(agent);

        assertEquals("Martin", result.getNom());
        verify(agentRepository, times(1)).save(agent);
    }

    // ===================== DELETE =====================
    @Test
    void testDeleteById() {
        doNothing().when(agentRepository).deleteById(1L);

        agentService.deleteById(1L);

        verify(agentRepository, times(1)).deleteById(1L);
    }
}