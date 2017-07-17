package com.xiaoyuan.hloli.bean;

import java.io.Serializable;

/**
 * 频道
 * Created by yuan on 2017/5/2.
 */
public class Channel implements Serializable{

    /**
     * id : 12
     * chnl_type :
     * showhot : 0
     * specil : 0
     * is_entry : 0
     * name : 最新
     * img :
     * subtitle :
     * shownew : 0
     * tag_custom :
     * intent :
     * bgcolor :
     * url :
     */
    private String id;
    private String chnl_type;
    private String showhot;
    private String specil;
    private String is_entry;
    private String name;
    private String img;
    private String subtitle;
    private String shownew;
    private String tag_custom;
    private String intent;
    private String bgcolor;
    private String url;

    public void setId(String id) {
        this.id = id;
    }

    public void setChnl_type(String chnl_type) {
        this.chnl_type = chnl_type;
    }

    public void setShowhot(String showhot) {
        this.showhot = showhot;
    }

    public void setSpecil(String specil) {
        this.specil = specil;
    }

    public void setIs_entry(String is_entry) {
        this.is_entry = is_entry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setShownew(String shownew) {
        this.shownew = shownew;
    }

    public void setTag_custom(String tag_custom) {
        this.tag_custom = tag_custom;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getChnl_type() {
        return chnl_type;
    }

    public String getShowhot() {
        return showhot;
    }

    public String getSpecil() {
        return specil;
    }

    public String getIs_entry() {
        return is_entry;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getShownew() {
        return shownew;
    }

    public String getTag_custom() {
        return tag_custom;
    }

    public String getIntent() {
        return intent;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public String getUrl() {
        return url;
    }
}
