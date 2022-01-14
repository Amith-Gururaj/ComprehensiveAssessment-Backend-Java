package amith.comprehensive.backend.repository;
/**
 * 
 *@author Amith G
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amith.comprehensive.backend.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> 
{

	public Doctor findByDname(String name);

	public Doctor findByDid(Long did);

}
