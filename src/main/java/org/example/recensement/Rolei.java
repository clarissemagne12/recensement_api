package org.example.recensement;

import org.example.recensement.entities.Role;
import java.util.List;
import java.util.Optional;

public interface Rolei {

    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);
<<<<<<< HEAD



}
=======
}
>>>>>>> d6aa50cdfb76f4a5a289f40c6dc200d12f99d362
