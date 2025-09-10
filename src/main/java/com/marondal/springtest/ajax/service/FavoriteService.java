package com.marondal.springtest.ajax.service;

import com.marondal.springtest.ajax.domain.Favorite;
import com.marondal.springtest.ajax.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public int createFavorite(String name, String url) {

        int count = favoriteRepository.insertFavorite(name, url);

        return count;
    }

    public List<Favorite>  getFavoriteList() {
        List<Favorite> favoriteList = favoriteRepository.selectFavoritList();

        return favoriteList;
    }

    public boolean isDuplicateUrl(String url) {
        int count = favoriteRepository.selectCountByUrl(url);

        return count > 0;
    }
}
