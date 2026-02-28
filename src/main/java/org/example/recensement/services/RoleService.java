package org.example.recensement.services;

import jakarta.transaction.Transactional;
import org.example.recensement.Rolei;
import org.example.recensement.entities.Role;
import org.example.recensement.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService implements Rolei {

    private static final Logger logger =
            LoggerFactory.getLogger(RoleService.class);

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        logger.info("Service : récupération de tous les rôles");
        List<Role> roles = roleRepository.findAll();
        logger.debug("Nombre de rôles récupérés : {}", roles.size());
        return roles;
    }

    @Override
    public Optional<Role> findById(Long id) {
        logger.info("Service : recherche du rôle id={}", id);
        return roleRepository.findById(id)
                .map(role -> {
                    logger.debug("Rôle trouvé id={}", id);
                    return role;
                })
                .or(() -> {
                    logger.warn("Rôle non trouvé id={}", id);
                    return Optional.empty();
                });
    }

    @Override
    public Role save(Role role) {
        logger.info("Service : création d’un rôle");
        Role saved = roleRepository.save(role);
        logger.info("Rôle créé id={}", saved.getId());
        return saved;
    }

    @Override
    public Role update(Role role) {
        logger.info("Service : mise à jour du rôle id={}", role.getId());
        Role updated = roleRepository.save(role);
        logger.info("Rôle mis à jour id={}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Service : suppression du rôle id={}", id);
        roleRepository.deleteById(id);
        logger.info("Rôle supprimé id={}", id);
    }
}