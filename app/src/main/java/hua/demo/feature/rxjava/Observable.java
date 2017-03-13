package hua.demo.feature.rxjava;

/**
 * Created by Administrator on 2017/3/9.
 *
 * 黑屋子
 *
 * T 看电影
 *
 *
 */

public class Observable<T> {

    /**
     * 男生
     */
    private OnSubscrible<T> onSubscrible;

    public Observable(OnSubscrible<T> onSubscrible) {
        this.onSubscrible = onSubscrible;
    }

    public static <T>Observable create(OnSubscrible<T> onSubscrible){
        return new Observable<T>(onSubscrible);
    }


    public void subscrible(Subscrible<? super T> subscrible){
        onSubscrible.call(subscrible);
    }

}
