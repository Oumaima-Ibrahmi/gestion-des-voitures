package com.oumaima.voitures.repos;
import com.oumaima.voitures.entities.Voiture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
