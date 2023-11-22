package spharos.client.service.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import spharos.client.service.domain.category.ServiceCategory;
import java.util.Optional;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Long> {

    boolean existsByCategoryIdAndServiceId(Long CategoryId, Long ServiceId);
    Optional<ServiceCategory> findByServiceId(Long ServiceId);

}
