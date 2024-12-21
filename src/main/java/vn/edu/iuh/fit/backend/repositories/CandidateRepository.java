package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.entities.Roles;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("select c from Candidate c " +
            "join c.experiences ex " +
            "where DATEDIFF(ex.toDate, ex.fromDate)/365 >= :year")
    public List<Candidate> findByYearExperience(@Param("year") int year);

    @Query("select c from Candidate c " +
            "join c.experiences ex " +
            "where ex.companyName like %:compName% " +
            "and ex.role = :role")
    public List<Candidate> findByExperienceWithCompanyAndRole(@Param("compName") String companyName, @Param("role") Roles roles);
}
