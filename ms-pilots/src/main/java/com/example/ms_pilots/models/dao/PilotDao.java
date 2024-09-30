package com.example.ms_pilots.models.dao;

import com.example.ms_commons.models.entity.Pilot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotDao extends CrudRepository<Pilot, Long> {

}
