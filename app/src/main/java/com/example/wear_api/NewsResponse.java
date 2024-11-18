package com.example.wear_api;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsResponse {
    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;

    @SerializedName("result")
    public Result result;

    public static class Result {
        @SerializedName("curpage")
        public int curpage;

        @SerializedName("allnum")
        public int allnum;

        @SerializedName("newslist")
        public List<NewsItem> newslist;
    }

    public static class NewsItem {
        @SerializedName("id")
        public String id;

        @SerializedName("ctime")
        public String ctime;

        @SerializedName("title")
        public String title;

        @SerializedName("description")
        public String description;

        @SerializedName("source")
        public String source;

        @SerializedName("picUrl")
        public String picUrl;

        @SerializedName("url")
        public String url;
    }
}
