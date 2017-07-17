package com.xiaoyuan.hloli.http;

import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.bean.SearchResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 数据请求
 * Created by yuan on 2017/4/25.
 */
public interface ApiService {

    @GET("/php_cgi/news/php/varcache_getnews.php")
    Observable<NewsList> getNews(@Query("id") int id, @Query("page") int page, @Query("plat") String platform, @Query("version") int version);

    @GET("/static/pages/news/phone/c13_list_1.shtml")
    Observable<BannerList> getBanner(@Query("plat") String platform, @Query("version") int version);

    @GET("/php_cgi/news/php/varcache_channel.php")
    Observable<List<Channel>> getChannelList(@Query("plat") String platform, @Query("version") int version);

    @GET("/php_cgi/news/php/varcache_ad.php")
    Observable<AdList> getAdList(@Query("plat") String platform, @Query("version") int version);

    @GET("/php_cgi/lol_mobile/iso/php/search_articles.php")
    Observable<SearchResult> search(@Query("plat") String platform, @Query("version") int version, @Query("keyword") String keyword, @Query("num") int num, @Query("page") int page);

    @GET("/lua/lol_news/columnlist")
    Observable<ColumnList> getColumnList(@Query("plat") String platform, @Query("version") int version, @Query("page") int page);

    @GET("/php_cgi/news/php/varcache_getcols.php")
    Observable<NewsList> getNewsByColumn(@Query("plat") String platform, @Query("version") int version, @Query("page") int page, @Query("cid") int id);
}
