package com.xiaoyuan.hloli.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuan on 2017/5/9.
 */
public class ColumnList {
    /**
     * hasnext : 1
     * unbook_list : [{"author":"官方赛事中心","col_id":"25","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201701/191256349854916.jpg","col_weight":"1","last_update":"2017-05-08 14:00:47","is_new":"0","last_news_title":"给我平野绫一个面子，别黑我了","col_des":"官方赛事综合节目天下英雄，赛场故事，高亮瞬间一网打尽！\r\n","book_num":"0","is_hot":"0","is_book":"0","col_title":"天下英雄"},{"author":"大咖","col_id":"11","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/201424288784675.png","col_weight":"1","last_update":"2017-05-08 12:12:58","is_new":"0","last_news_title":"峡谷烈焰-史上最远1000码勾","col_des":"热门英雄的精彩操作，就像峡谷里一团热烈的火焰，带来震撼的视觉冲击。","book_num":"0","is_hot":"0","is_book":"0","col_title":"峡谷烈焰"},{"author":"兔玩","col_id":"33","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/14173324602828.jpg","col_weight":"1","last_update":"2017-05-08 10:34:42","is_new":"0","last_news_title":"每日撸报：55开遭瞎子极限反杀","col_des":"挑选前夜主播直播搞笑片段，通过精心剪辑为大家奉上轻松搞笑的主播集锦。\r\n","book_num":"0","is_hot":"0","is_book":"0","col_title":"每日撸报"},{"author":"掌上英雄联盟","col_id":"6","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/161408033153141.png","col_weight":"1","last_update":"2017-05-07 16:10:17","is_new":"0","last_news_title":"掌盟大神团：中单法典流吸血鬼","col_des":"由掌盟认证大师、王者组玩家撰写的英雄攻略心得，排位上分这里走！","book_num":"0","is_hot":"0","is_book":"0","col_title":"掌盟大神团"},{"author":"掌盟@搬砖哥","col_id":"5","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/161353557212467.jpg","col_weight":"1","last_update":"2017-05-07 16:09:49","is_new":"0","last_news_title":"每日一笑：好人平安","col_des":"这里有关于英雄联盟最原生态的段子与笑话，还不占位抢沙发吗？ ","book_num":"0","is_hot":"0","is_book":"0","col_title":"每日一笑"},{"author":"17173","col_id":"17","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/201432344623138.png","col_weight":"1","last_update":"2017-05-07 15:38:50","is_new":"0","last_news_title":"主播炸了：小马教你剑圣五杀","col_des":"由聚印象出品的一档游戏主播搞笑类的视频栏目，精选各大知名主播在直播过程中发生一些的精彩和搞笑的素材，通过音效和背景音乐包装配合，把游戏内容包装的更加有趣。 ","book_num":"0","is_hot":"0","is_book":"0","col_title":"主播炸了"},{"author":"LOL大咖","col_id":"31","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/141729454306796.jpg","col_weight":"1","last_update":"2017-05-07 14:13:41","is_new":"0","last_news_title":"TOP10：见识科学的走位","col_des":"玩家投稿，国服民间大神顶尖秀场；从青铜到王者，你上你也行，就怕你不秀。","book_num":"0","is_hot":"0","is_book":"0","col_title":"起小点TOP10"},{"author":"15W","col_id":"8","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/191641238741136.jpg","col_weight":"1","last_update":"2017-05-07 09:49:53","is_new":"0","last_news_title":"主播疯神榜：马飞我玩不下去了","col_des":"由15W全新打造的LOL主播集锦趣味节目，节目除了大家喜闻乐见的搞笑素材\r\n外，每周还搜罗疯神两个不同方向的排行榜，让你一次过足瘾。","book_num":"0","is_hot":"0","is_book":"0","col_title":"主播疯神榜"},{"author":"徐老师","col_id":"7","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/191614298972612.jpg","col_weight":"1","last_update":"2017-05-06 15:59:05","is_new":"0","last_news_title":"徐老师来巡山：霞洛五杀单身犬","col_des":"徐老师出品的搞笑系列巨作，保留一贯独特风格，每周精选搞笑镜头，加上独一无二的配音与制作，让你笑出八块腹肌根本停不下来。","book_num":"0","is_hot":"0","is_book":"0","col_title":"徐老师来巡山"},{"author":"伐木累","col_id":"21","logo":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/201601254528132.png","col_weight":"1","last_update":"2017-05-06 14:12:16","is_new":"0","last_news_title":"左雾突发诗瘾 疑似透露马丁转会","col_des":"LOL名人互动问答，带给玩家电竞明星赛场点评和电竞圈的奇闻趣事。","book_num":"0","is_hot":"0","is_book":"0","col_title":"语音问答秀"}]
     * book_list : []
     * code : 0
     * msg : ok
     * recommend_list : []
     */
    private String hasnext;
    private String code;
    private String message;
    private List<ListEntity> unbook_list;
    private List<ListEntity> book_list;
    private List<ListEntity> recommend_list;

    public List<ListEntity> getBook_list() {
        return book_list;
    }

    public void setBook_list(List<ListEntity> book_list) {
        this.book_list = book_list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHasnext() {
        return hasnext;
    }

    public void setHasnext(String hasnext) {
        this.hasnext = hasnext;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ListEntity> getRecommend_list() {
        return recommend_list;
    }

    public void setRecommend_list(List<ListEntity> recommend_list) {
        this.recommend_list = recommend_list;
    }

    public List<ListEntity> getUnbook_list() {
        return unbook_list;
    }

    public void setUnbook_list(List<ListEntity> unbook_list) {
        this.unbook_list = unbook_list;
    }

    public class ListEntity implements Serializable {
        private String is_hot;
        private String col_weight;
        private String last_news_title;
        private String col_title;
        private String col_des;
        private String is_book;
        private String book_num;
        private String is_new;
        private String last_update;
        private String logo;
        private String col_id;
        private String author;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getBook_num() {
            return book_num;
        }

        public void setBook_num(String book_num) {
            this.book_num = book_num;
        }

        public String getCol_des() {
            return col_des;
        }

        public void setCol_des(String col_des) {
            this.col_des = col_des;
        }

        public String getCol_id() {
            return col_id;
        }

        public void setCol_id(String col_id) {
            this.col_id = col_id;
        }

        public String getCol_title() {
            return col_title;
        }

        public void setCol_title(String col_title) {
            this.col_title = col_title;
        }

        public String getCol_weight() {
            return col_weight;
        }

        public void setCol_weight(String col_weight) {
            this.col_weight = col_weight;
        }

        public String getIs_book() {
            return is_book;
        }

        public void setIs_book(String is_book) {
            this.is_book = is_book;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public String getLast_news_title() {
            return last_news_title;
        }

        public void setLast_news_title(String last_news_title) {
            this.last_news_title = last_news_title;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }


}
