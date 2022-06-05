package com.raghu.mbs.daos;

import com.raghu.mbs.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageDao extends JpaRepository<Language,Integer> {
    public Optional<Language> findByLanguageName(String languageName);
}
