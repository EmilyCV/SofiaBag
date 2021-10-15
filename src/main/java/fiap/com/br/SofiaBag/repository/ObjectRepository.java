package fiap.com.br.SofiaBag.repository;

import fiap.com.br.SofiaBag.entity.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ObjectRepository extends JpaRepository<Object, String> {
    List<Object> findObjectByUserId(String id);
    Optional<Object> findObjectByUserIdAndCdRfid(String userId, String objectId);
}
