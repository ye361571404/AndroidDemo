package com.hua.demos.dependencies.retrofit;

import java.util.List;

public class Movie {


    /**
     * resultcode : 200
     * reason : 成功的返回
     * result : [{"movieid":"234722","rating":"6.8","genres":"网络剧","runtime":null,"language":"汉语普通话","title":"无间道","poster":"http://img5.mtime.cn/mg/2016/12/21/164708.38923170_270X405X4.jpg","writers":"","film_locations":"中国","directors":"","rating_count":"16","actors":"罗嘉良 Gallen Law,罗仲谦 Chung Him Law,刘松仁 Damian Lau,廖碧儿 Bernice Jan Liu","plot_simple":"总剧情 　　王峻轩（罗仲谦饰）是香港警队里一个见习督察，立志要成为史上晋升得最快的督察。一次扫毒行动中，峻轩碰上疑犯五折，公报私仇，让五折药物中毒。事后峻轩发现五折死亡，因此一直感到不安内疚，要靠心理医生胡家琳（朱锐饰）的治疗才能稍稍平复。大陆警察江子丹（化名子弹）（王阳饰）前来探望好友，发现五折服用过量毒品堕楼身亡。子弹对此大感 展开 　　王峻轩（罗仲谦饰）是香港警队里一个见习督察，立志要成为史上晋升得最快的督察。一次扫毒行动中，峻轩碰上疑犯五折，公报私仇，让五折药物中毒。事后峻轩发现五折死亡，因此一直感到不安内疚，要靠心理医生胡家琳（朱锐饰）的治疗才能稍稍平复。大陆警察江子丹（化名子弹）（王阳饰）前来探望好友，发现五折服用过量毒品堕楼身亡。子弹对此大感诧异，认为这是不可能的事，决定要找出真相，以证好友的清白。没过多久，子弹发现五折的死与一个香港黑道社团经营的贩毒网络有关，该网络正与外国贩毒集团勾结，筹划开拓中国这个庞大的市场！于是立即联络香港警方，两地联合部署行动，要捣毁这个跨境的贩毒集团。","year":"2016","country":"中国","type":null,"release_date":"20161221","also_known_as":"剧版无间道"},{"movieid":"12142","rating":null,"genres":"惊悚/剧情/犯罪","runtime":"101 min / Hong Kong:97 min (director's cut) / Argentina:101 min (Mar del Plata Film Festival)","language":"粤语","title":"无间道","poster":"http://img31.mtime.cn/mt/2014/02/22/230340.66768202_270X405X4.jpg","writers":"庄文强,麦兆辉","film_locations":"中国香港","directors":"刘伟强,麦兆辉","rating_count":null,"actors":"刘德华 Andy Lau,梁朝伟 Tony Leung,黄秋生 Anthony Wong,曾志伟 Eric Tsang","plot_simple":"1991年，三合会会员刘建明（刘德华 饰）听大佬韩琛（曾志伟 饰）指示加入警队，七年间已升至警长。92年，警察学员陈永仁（梁朝伟 饰）被逼退学作三合会卧底，现时大佬正是韩琛。2002年，一场失败的重案组突袭令双方卧底浮出水面。","year":"2002","country":"中国香港","type":null,"release_date":"20030905","also_known_as":""}]
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * movieid : 234722
         * rating : 6.8
         * genres : 网络剧
         * runtime : null
         * language : 汉语普通话
         * title : 无间道
         * poster : http://img5.mtime.cn/mg/2016/12/21/164708.38923170_270X405X4.jpg
         * writers :
         * film_locations : 中国
         * directors :
         * rating_count : 16
         * actors : 罗嘉良 Gallen Law,罗仲谦 Chung Him Law,刘松仁 Damian Lau,廖碧儿 Bernice Jan Liu
         * plot_simple : 总剧情 　　王峻轩（罗仲谦饰）是香港警队里一个见习督察，立志要成为史上晋升得最快的督察。一次扫毒行动中，峻轩碰上疑犯五折，公报私仇，让五折药物中毒。事后峻轩发现五折死亡，因此一直感到不安内疚，要靠心理医生胡家琳（朱锐饰）的治疗才能稍稍平复。大陆警察江子丹（化名子弹）（王阳饰）前来探望好友，发现五折服用过量毒品堕楼身亡。子弹对此大感 展开 　　王峻轩（罗仲谦饰）是香港警队里一个见习督察，立志要成为史上晋升得最快的督察。一次扫毒行动中，峻轩碰上疑犯五折，公报私仇，让五折药物中毒。事后峻轩发现五折死亡，因此一直感到不安内疚，要靠心理医生胡家琳（朱锐饰）的治疗才能稍稍平复。大陆警察江子丹（化名子弹）（王阳饰）前来探望好友，发现五折服用过量毒品堕楼身亡。子弹对此大感诧异，认为这是不可能的事，决定要找出真相，以证好友的清白。没过多久，子弹发现五折的死与一个香港黑道社团经营的贩毒网络有关，该网络正与外国贩毒集团勾结，筹划开拓中国这个庞大的市场！于是立即联络香港警方，两地联合部署行动，要捣毁这个跨境的贩毒集团。
         * year : 2016
         * country : 中国
         * type : null
         * release_date : 20161221
         * also_known_as : 剧版无间道
         */

        private String movieid;
        private String rating;
        private String genres;
        private Object runtime;
        private String language;
        private String title;
        private String poster;
        private String writers;
        private String film_locations;
        private String directors;
        private String rating_count;
        private String actors;
        private String plot_simple;
        private String year;
        private String country;
        private Object type;
        private String release_date;
        private String also_known_as;

        public String getMovieid() {
            return movieid;
        }

        public void setMovieid(String movieid) {
            this.movieid = movieid;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public Object getRuntime() {
            return runtime;
        }

        public void setRuntime(Object runtime) {
            this.runtime = runtime;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getWriters() {
            return writers;
        }

        public void setWriters(String writers) {
            this.writers = writers;
        }

        public String getFilm_locations() {
            return film_locations;
        }

        public void setFilm_locations(String film_locations) {
            this.film_locations = film_locations;
        }

        public String getDirectors() {
            return directors;
        }

        public void setDirectors(String directors) {
            this.directors = directors;
        }

        public String getRating_count() {
            return rating_count;
        }

        public void setRating_count(String rating_count) {
            this.rating_count = rating_count;
        }

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
        }

        public String getPlot_simple() {
            return plot_simple;
        }

        public void setPlot_simple(String plot_simple) {
            this.plot_simple = plot_simple;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getAlso_known_as() {
            return also_known_as;
        }

        public void setAlso_known_as(String also_known_as) {
            this.also_known_as = also_known_as;
        }
    }
}
