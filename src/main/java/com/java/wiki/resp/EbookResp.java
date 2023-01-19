package com.java.wiki.resp;

public class EbookResp {

    private Long id;

    private String name;

    private Long category1Id;

    private Long category2Id;

    private String descprition;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public String getDescprition() {
        return descprition;
    }

    public void setDescprition(String descprition) {
        this.descprition = descprition;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "EbookResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", descprition='" + descprition + '\'' +
                ", cover='" + cover + '\'' +
                ", docCount=" + docCount +
                ", viewCount=" + viewCount +
                ", voteCount=" + voteCount +
                '}';
    }
}
