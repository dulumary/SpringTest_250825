package com.marondal.springtest.ajax.service;

import com.marondal.springtest.ajax.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public int createFavorite(String name, String url) {

        int count = favoriteRepository.insertFavorite(name, url);

        return count;
    }
}
