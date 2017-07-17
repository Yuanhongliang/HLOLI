package com.xiaoyuan.hloli.http;

import com.xiaoyuan.hloli.bean.AdList;
import com.xiaoyuan.hloli.bean.BannerList;
import com.xiaoyuan.hloli.bean.Channel;
import com.xiaoyuan.hloli.bean.ColumnList;
import com.xiaoyuan.hloli.bean.NewsList;
import com.xiaoyuan.hloli.bean.SearchResult;
import com.xiaoyuan.hloli.constant.Constant;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by yuan on 2017/4/25.
 */
public class HttpMethod {

    private static HttpMethod instance;
    private final ApiService service1;
    private final ApiService service2;
    Retrofit retrofit1;
    Retrofit retrofit2;

    private HttpMethod() {
        retrofit1 = RetrofitBuilder.getRetrofit(Constant.BASE_URL_1);
        retrofit2 = RetrofitBuilder.getRetrofit(Constant.BASE_URL_2);
        service1 = retrofit1.create(ApiService.class);
        service2 = retrofit2.create(ApiService.class);
    }

    public static HttpMethod getInstance() {
        if (instance == null) {
            synchronized (HttpMethod.class) {
                if (instance == null) {
                    instance = new HttpMethod();
                }
            }
        }
        return instance;
    }

    /**
     * 获取新闻
     *
     * @param id
     * @param page
     * @return
     */
    public Observable<NewsList> getNews(int id, int page) {
        return service1.getNews(id, page, Constant.PLATFORM, Constant.VERSION);
    }

    /**
     * 获取轮播图
     *
     * @return
     */
    public Observable<BannerList> getBanner() {
        return service1.getBanner(Constant.PLATFORM, Constant.VERSION);
    }

    /**
     * 获取频道列表
     *
     * @return
     */
    public Observable<List<Channel>> getChannelList() {
        return service1.getChannelList(Constant.PLATFORM, Constant.VERSION);
    }

    /**
     * 获取广告数据
     *
     * @return
     */
    public Observable<AdList> getAdList() {
        return service1.getAdList(Constant.PLATFORM, Constant.VERSION);
    }

    /**
     * 搜索文章
     *
     * @param keyword
     * @param num
     * @param page
     * @return
     */
    public Observable<SearchResult> searchArticles(String keyword, int num, int page) {
        return service1.search(Constant.PLATFORM, Constant.VERSION, keyword, num, page);
    }

    /**
     * 获取专栏列表
     *
     * @param page
     * @return
     */
    public Observable<ColumnList> getColumnList(int page) {
        return service1.getColumnList(Constant.PLATFORM, Constant.VERSION, page);
    }

    public Observable<NewsList> getNewsByColumn(int page, int id) {
        return service1.getNewsByColumn(Constant.PLATFORM, Constant.VERSION, page, id);
    }


}
