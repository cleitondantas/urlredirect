package br.com.rocketdevelopment.urlredirect.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortenerRepository extends JpaRepository<ShortnerEntity, String> {

    Optional<ShortnerEntity> findByShorten(String shorten);
}
