package com.example.apirecycler;

public class itemList {
    private String sourceName;
    private String sourceId;
    private String authorName;
    private String newsTitle;
    private String imageUrl;

    public itemList(String sourceName, String sourceId, String authorName, String newsTitle, String imageUrl) {
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.authorName = authorName;
        this.newsTitle = newsTitle;
        this.imageUrl = imageUrl;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

