package tw.danielchiang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.danielchiang.domain.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
