package dsq.jpa;

import dsq.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aa on 2019/7/14.
 */
public interface LoggerJPA extends JpaRepository<LoggerEntity, Long> {
}
