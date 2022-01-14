package amith.comprehensive.backend.repository;
/**
 * 
 *@author Amith G
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amith.comprehensive.backend.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>
{
	Patient findByPid(Long id);	
}
