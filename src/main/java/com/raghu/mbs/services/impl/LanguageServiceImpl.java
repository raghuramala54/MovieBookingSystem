package com.raghu.mbs.services.impl;

import com.raghu.mbs.daos.LanguageDao;
import com.raghu.mbs.entities.Language;
import com.raghu.mbs.exceptions.LanguageDetailsNotFoundException;
import com.raghu.mbs.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageDao languageDao;

    @Override
    public Language acceptLanguageDetails(Language language) {
        return languageDao.save(language);
    }

    @Override
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException {
        return languageDao.findById(id)
                .orElseThrow(
                        () -> new LanguageDetailsNotFoundException("Language not found by id: " + id)
                );
    }

    @Override
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException {
        return languageDao.findByLanguageName(languageName)
                .orElseThrow(
                        () -> new LanguageDetailsNotFoundException("Language not found by languageName: " + languageName)
                );
    }

    @Override
    public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException {
        Language language = getLanguageDetails(id);
        languageDao.delete(language);
        return true;
    }

    @Override
    public List<Language> getAllLanguageDetails() {
        return languageDao.findAll();
    }
}
