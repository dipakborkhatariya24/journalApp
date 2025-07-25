package com.dipakinfotech.journalApp.Repository;

import com.dipakinfotech.journalApp.entity.ConfigJournalAppEntity;
import com.dipakinfotech.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
