package fiap.com.br.SofiaBag.repository;

import fiap.com.br.SofiaBag.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
