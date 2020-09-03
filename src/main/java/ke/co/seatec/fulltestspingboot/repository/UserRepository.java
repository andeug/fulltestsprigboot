/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.seatec.fulltestspingboot.repository;

import java.util.List;
import java.util.Optional;
import ke.co.seatec.fulltestspingboot.entity.TUSERS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASimiyu
 */
@Repository
public interface UserRepository extends JpaRepository<TUSERS, Integer> {

    Optional<TUSERS> findByPhone(String phone);

    Optional<TUSERS> findByEmail(String email);

    List<TUSERS> findByGender(String gender);

    Optional<TUSERS> findByUsername(String username);
}
