package io.project.app.covidbot.repositories;

import io.project.app.covidbot.domain.Account;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author lilit
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByChatId(Long chatId);

    Optional<Account> findByFirstname(String firstname);
}
