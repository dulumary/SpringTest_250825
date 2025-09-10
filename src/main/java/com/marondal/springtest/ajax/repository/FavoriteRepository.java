package com.marondal.springtest.ajax.repository;

import com.marondal.springtest.ajax.domain.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteRepository {

    public int insertFavorite(
            @Param("name") String name
            , @Param("url") String url);

    public List<Favorite> selectFavoritList();

    public int selectCountByUrl(@Param("url") String url);
}
