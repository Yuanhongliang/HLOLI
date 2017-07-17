package com.xiaoyuan.hloli.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 广告
 * Created by yuan on 2017/5/2.
 */
public class AdList implements Serializable {

    /**
     * list : [{"summary":"天神之视，扫清邪祟！","is_act":"1","title":"神拳 李青皮肤售卖","article_id":"30576","jump_url":"http://lol.qq.com/act/a20170407leesin/index.html","image_url":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/191918302052821.jpg","is_hide":"1","is_word":"0","update_date":"2017-04-19 19:19:51","need_hide":"1","ad_intent":"http://lol.qq.com/act/a20170407leesin/index.html","is_share":"1"}]
     * this_page_num : 1
     */
    private List<ListEntity> list;
    private String this_page_num;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public void setThis_page_num(String this_page_num) {
        this.this_page_num = this_page_num;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public String getThis_page_num() {
        return this_page_num;
    }

    public class ListEntity {
        /**
         * summary : 天神之视，扫清邪祟！
         * is_act : 1
         * title : 神拳 李青皮肤售卖
         * article_id : 30576
         * jump_url : http://lol.qq.com/act/a20170407leesin/index.html
         * image_url : http://ossweb-img.qq.com/upload/qqtalk/news/201704/191918302052821.jpg
         * is_hide : 1
         * is_word : 0
         * update_date : 2017-04-19 19:19:51
         * need_hide : 1
         * ad_intent : http://lol.qq.com/act/a20170407leesin/index.html
         * is_share : 1
         */
        private String summary;
        private String is_act;
        private String title;
        private String article_id;
        private String jump_url;
        private String image_url;
        private String is_hide;
        private String is_word;
        private String update_date;
        private String need_hide;
        private String ad_intent;
        private String is_share;

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setIs_act(String is_act) {
            this.is_act = is_act;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public void setJump_url(String jump_url) {
            this.jump_url = jump_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public void setIs_hide(String is_hide) {
            this.is_hide = is_hide;
        }

        public void setIs_word(String is_word) {
            this.is_word = is_word;
        }

        public void setUpdate_date(String update_date) {
            this.update_date = update_date;
        }

        public void setNeed_hide(String need_hide) {
            this.need_hide = need_hide;
        }

        public void setAd_intent(String ad_intent) {
            this.ad_intent = ad_intent;
        }

        public void setIs_share(String is_share) {
            this.is_share = is_share;
        }

        public String getSummary() {
            return summary;
        }

        public String getIs_act() {
            return is_act;
        }

        public String getTitle() {
            return title;
        }

        public String getArticle_id() {
            return article_id;
        }

        public String getJump_url() {
            return jump_url;
        }

        public String getImage_url() {
            return image_url;
        }

        public String getIs_hide() {
            return is_hide;
        }

        public String getIs_word() {
            return is_word;
        }

        public String getUpdate_date() {
            return update_date;
        }

        public String getNeed_hide() {
            return need_hide;
        }

        public String getAd_intent() {
            return ad_intent;
        }

        public String getIs_share() {
            return is_share;
        }
    }
}
