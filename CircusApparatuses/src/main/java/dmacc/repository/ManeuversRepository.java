package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import dmacc.beans.Maneuver;

//@Repository
public interface ManeuversRepository extends JpaRepository<Maneuver, Long>
{

}
