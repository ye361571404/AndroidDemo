package hua.demo.feature.rxjava;

/**
 * Created by Administrator on 2017/3/9.
 *
 * 男生
 *
 * T    看电影
 * Subscrible<? super>  看电影的女生
 *
 * super    用于限定传入参数
 * extends  用于限定返回参数
 *
 * Subscrible   女生
 *
 */

public interface OnSubscrible<T> extends Action1<Subscrible<? super T>> {
}
