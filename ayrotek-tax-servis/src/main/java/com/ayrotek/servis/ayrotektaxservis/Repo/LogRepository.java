package com.ayrotek.servis.ayrotektaxservis.Repo;

import com.ayrotek.servis.ayrotektaxservis.domain.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends MongoRepository<Log, Long> {


}
