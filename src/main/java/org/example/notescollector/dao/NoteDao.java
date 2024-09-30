package org.example.notescollector.dao;

import org.example.notescollector.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao  extends JpaRepository<NoteEntity, String> {
}
