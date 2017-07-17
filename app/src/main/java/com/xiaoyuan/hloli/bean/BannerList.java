package com.xiaoyuan.hloli.bean;

import java.util.List;

/**
 * Created by yuan on 2017/4/26.
 */
public class BannerList {

    /**
     * next :
     * list : [{"summary":"涓鸿嚜宸卞枩鐖辩殑鎴橀槦鍔犳补鍔╁▉锛岃耽鐨偆Q甯佸ぇ绀笺\u20ac�","is_subject":"0","score":"3","targetid":"1895488137","article_url":"http://lpl.qq.com/es/m/act/a20170413springfinals/index.html","channel_id":"<2>:<12>,<2>:<13>,<2>:<303>,<2>:<303>:<305>,<2>:<3>,<2>:<73>","is_report":"True","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/25144308286976_282.jpg","is_direct":"True","is_new":"0","is_act":"0","article_id":"30762","title":"鍔╁▉LPL4.29鎬诲喅璧�","content_id":"30762","image_with_btn":"False","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/25144308286976_480.jpg","is_top":"False","is_hot":"0","insert_date":"2017-04-25 14:43:08","image_spec":"1","publication_date":"2017-04-25 14:38:52","channel_desc":"鎺ㄨ崘"},{"summary":"鍙屽瓙鑻遍泟闇炰笌娲涜嫳闆勭毊鑲ら攢鍞\u20ac�","is_subject":"0","score":"3","targetid":"1895277749","article_url":"http://lol.qq.com/m/act/a20170421luoxia/","channel_id":"<2>:<12>,<2>:<13>,<2>:<23>,<2>:<3>","is_report":"True","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/251205376017318_282.jpg","is_direct":"True","is_new":"0","is_act":"0","article_id":"30759","title":"骞荤繋 娲� & 閫嗙窘 闇�","content_id":"30759","image_with_btn":"False","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/251205376017318_480.jpg","is_top":"False","is_hot":"0","insert_date":"2017-04-25 12:05:37","image_spec":"1","publication_date":"2017-04-25 12:35:58","channel_desc":"鎺ㄨ崘"},{"summary":"鍙岀敓鑻遍泟闇炰笌娲涗笂绾匡紝涔岃开灏斿墤榄斿姞寮恒\u20ac�","is_subject":"0","score":"3","targetid":"1893741514","article_url":"http://lol.qq.com/m/act/a20150123news/?id=20170424&comment=1893741514&aritcleid=30731","channel_id":"<2>:<12>,<2>:<13>,<2>:<3>","is_report":"True","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/241827580433149_282.jpg","is_direct":"True","is_new":"0","is_act":"0","article_id":"30731","title":"25鏃ヤ笂鍗�7鐐�30鍒嗙増鏈洿鏂板叕鍛�","content_id":"30731","image_with_btn":"False","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/241827580433149_480.jpg","is_top":"False","is_hot":"0","insert_date":"2017-04-24 17:22:43","image_spec":"1","publication_date":"2017-04-25 09:21:12","channel_desc":"鎺ㄨ崘"},{"summary":"","is_subject":"0","score":"3","targetid":"1894687560","article_url":"http://lpl.qq.com/es/m/act/a20170424msi/","channel_id":"<2>:<13>","is_report":"True","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/250127432149930_282.jpg","is_direct":"True","is_new":"0","is_act":"0","article_id":"30750","title":"鍞嫳闆� 鏁㈢О闆勶紒","content_id":"30750","image_with_btn":"False","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/250127432149930_480.jpg","is_top":"False","is_hot":"0","insert_date":"2017-04-25 01:27:43","image_spec":"1","publication_date":"2017-04-25 01:26:35","channel_desc":"鎺ㄨ崘"},{"summary":"鏄椂鍊欏洖澶存瑙嗚繃鍘荤殑6涓湀骞朵负鏈潵鍋氬ソ鍑嗗浜嗐\u20ac�","is_subject":"0","score":"3","targetid":"1890772551","article_url":"http://lol.qq.com/act/a20170420midseason/index.htm","channel_id":"<2>:<13>,<2>:<342>,<2>:<342>:<343>,<2>:<342>:<344>,<2>:<342>:<345>","is_report":"True","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/222134576178785_282.jpg","is_direct":"True","is_new":"0","is_act":"0","article_id":"30682","title":"瀛ｄ腑鐗堟湰鏇存柊鎻","content_id":"30682","image_with_btn":"False","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201704/222134576178785_480.jpg","is_top":"False","is_hot":"0","insert_date":"2017-04-22 21:34:57","image_spec":"1","publication_date":"2017-04-22 21:33:26","channel_desc":"鎺ㄨ崘"}]
     * this_page_num : 5
     */
    private String next;
    private List<ListEntity> list;
    private String this_page_num;

    public void setNext(String next) {
        this.next = next;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public void setThis_page_num(String this_page_num) {
        this.this_page_num = this_page_num;
    }

    public String getNext() {
        return next;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public String getThis_page_num() {
        return this_page_num;
    }

    public static class ListEntity {

        @Override
        public String toString() {
            return "ListEntity{" +
                    "summary='" + summary + '\'' +
                    ", is_subject='" + is_subject + '\'' +
                    ", score='" + score + '\'' +
                    ", targetid='" + targetid + '\'' +
                    ", article_url='" + article_url + '\'' +
                    ", channel_id='" + channel_id + '\'' +
                    ", is_report='" + is_report + '\'' +
                    ", image_url_small='" + image_url_small + '\'' +
                    ", is_direct='" + is_direct + '\'' +
                    ", is_new='" + is_new + '\'' +
                    ", is_act='" + is_act + '\'' +
                    ", article_id='" + article_id + '\'' +
                    ", title='" + title + '\'' +
                    ", content_id='" + content_id + '\'' +
                    ", image_with_btn='" + image_with_btn + '\'' +
                    ", image_url_big='" + image_url_big + '\'' +
                    ", is_top='" + is_top + '\'' +
                    ", is_hot='" + is_hot + '\'' +
                    ", insert_date='" + insert_date + '\'' +
                    ", image_spec='" + image_spec + '\'' +
                    ", publication_date='" + publication_date + '\'' +
                    ", channel_desc='" + channel_desc + '\'' +
                    '}';
        }

        /**
         * summary : 涓鸿嚜宸卞枩鐖辩殑鎴橀槦鍔犳补鍔╁▉锛岃耽鐨偆Q甯佸ぇ绀笺€�
         * is_subject : 0
         * score : 3
         * targetid : 1895488137
         * article_url : http://lpl.qq.com/es/m/act/a20170413springfinals/index.html
         * channel_id : <2>:<12>,<2>:<13>,<2>:<303>,<2>:<303>:<305>,<2>:<3>,<2>:<73>
         * is_report : True
         * image_url_small : http://ossweb-img.qq.com/upload/qqtalk/news/201704/25144308286976_282.jpg
         * is_direct : True
         * is_new : 0
         * is_act : 0
         * article_id : 30762
         * title : 鍔╁▉LPL4.29鎬诲喅璧�
         * content_id : 30762
         * image_with_btn : False
         * image_url_big : http://ossweb-img.qq.com/upload/qqtalk/news/201704/25144308286976_480.jpg
         * is_top : False
         * is_hot : 0
         * insert_date : 2017-04-25 14:43:08
         * image_spec : 1
         * publication_date : 2017-04-25 14:38:52
         * channel_desc : 鎺ㄨ崘
         */
        private String summary;
        private String is_subject;
        private String score;
        private String targetid;
        private String article_url;
        private String channel_id;
        private String is_report;
        private String image_url_small;
        private String is_direct;
        private String is_new;
        private String is_act;
        private String article_id;
        private String title;
        private String content_id;
        private String image_with_btn;
        private String image_url_big;
        private String is_top;
        private String is_hot;
        private String insert_date;
        private String image_spec;
        private String publication_date;
        private String channel_desc;

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setIs_subject(String is_subject) {
            this.is_subject = is_subject;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setTargetid(String targetid) {
            this.targetid = targetid;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public void setIs_report(String is_report) {
            this.is_report = is_report;
        }

        public void setImage_url_small(String image_url_small) {
            this.image_url_small = image_url_small;
        }

        public void setIs_direct(String is_direct) {
            this.is_direct = is_direct;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public void setIs_act(String is_act) {
            this.is_act = is_act;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public void setImage_with_btn(String image_with_btn) {
            this.image_with_btn = image_with_btn;
        }

        public void setImage_url_big(String image_url_big) {
            this.image_url_big = image_url_big;
        }

        public void setIs_top(String is_top) {
            this.is_top = is_top;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public void setInsert_date(String insert_date) {
            this.insert_date = insert_date;
        }

        public void setImage_spec(String image_spec) {
            this.image_spec = image_spec;
        }

        public void setPublication_date(String publication_date) {
            this.publication_date = publication_date;
        }

        public void setChannel_desc(String channel_desc) {
            this.channel_desc = channel_desc;
        }

        public String getSummary() {
            return summary;
        }

        public String getIs_subject() {
            return is_subject;
        }

        public String getScore() {
            return score;
        }

        public String getTargetid() {
            return targetid;
        }

        public String getArticle_url() {
            return article_url;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public String getIs_report() {
            return is_report;
        }

        public String getImage_url_small() {
            return image_url_small;
        }

        public String getIs_direct() {
            return is_direct;
        }

        public String getIs_new() {
            return is_new;
        }

        public String getIs_act() {
            return is_act;
        }

        public String getArticle_id() {
            return article_id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent_id() {
            return content_id;
        }

        public String getImage_with_btn() {
            return image_with_btn;
        }

        public String getImage_url_big() {
            return image_url_big;
        }

        public String getIs_top() {
            return is_top;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public String getInsert_date() {
            return insert_date;
        }

        public String getImage_spec() {
            return image_spec;
        }

        public String getPublication_date() {
            return publication_date;
        }

        public String getChannel_desc() {
            return channel_desc;
        }
    }
}
