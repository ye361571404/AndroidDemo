package com.hua.demos.dependencies.rxjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;

import com.hua.R;

import org.xutils.common.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout clContent;
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rx_java);
        initView();
        setListener();


    }

    private void setListener() {
    }

    private void initView() {

        clContent = (ConstraintLayout)findViewById(R.id.cl_content);
        int childCount = clContent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = clContent.getChildAt(i);
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn01:
                test();
                break;
            case R.id.btn02:
                test2();
                break;
            case R.id.btn03:
                test3();
                break;
            case R.id.btn04:
                test4();
                break;
            case R.id.btn05:
                test5();
                break;
            case R.id.btn06:
                test6();
                break;
            case R.id.btn07:
                test7();
                break;
            case R.id.btn08:
                test8();
                break;
            case R.id.btn09:
                test9();
                break;
            case R.id.btn10:
                test10();
                break;
            case R.id.btn11:
                test11();
                break;
            case R.id.btn12:
                test12();
                break;
            case R.id.btn13:
                test13();
                break;
            case R.id.btn14:
                test14();
                break;
            case R.id.btn15:
                test15();
                break;
            case R.id.btn16:
                test16();
                break;
            case R.id.btn17:
                test17();
                break;
            case R.id.btn18:
                test18();
                break;
        }
    }

    private void test18() {
        // 去除发送间隔时间小于 500 毫秒的发射事件，所以 1 和 3 被去掉了。
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                Thread.sleep(400);
                emitter.onNext(2);
                Thread.sleep(505);
                emitter.onNext(3);
                Thread.sleep(100);
                emitter.onNext(4);
                Thread.sleep(605);
                emitter.onNext(5);
                Thread.sleep(510);
            }
        }).debounce(500,TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtil.e("debounce :" + integer);
            }
        });
    }

    private void test17() {
        Single.just(new Random().nextInt())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.e("");
                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        LogUtil.e("integer = " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(e.getMessage());
                    }
                });
    }

    private void test16() {
        Observable.just(1,2,3,4,5)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtil.e("integer = " + integer);
                    }
                });
    }

    private void test15() {
        LogUtil.e("timer start" + com.blankj.utilcode.utils.TimeUtils.getCurTimeString());
        disposable = Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtil.e("interval:" + aLong + "at" + com.blankj.utilcode.utils.TimeUtils.getCurTimeString());
                    }
                });
    }

    private void test14() {
        LogUtil.e("timer start" + com.blankj.utilcode.utils.TimeUtils.getCurTimeString());
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtil.e("timer:" + aLong + "at" + com.blankj.utilcode.utils.TimeUtils.getCurTimeString());
                    }
                });
    }

    private void test13() {
        Observable.just(1,2,3,4,5)
                .buffer(3,2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        LogUtil.e("buffer size" + integers.size());
                        for (int i = 0; i < integers.size(); i++) {
                            LogUtil.e("buffer value = " + integers.get(i));
                        }
                    }
                });
    }

    private void test12() {
        Observable.just(3, 1, 7, 4, 9, 6)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                })
        .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtil.e("filter -> " + integer);
            }
        });
    }

    private void test11() {
        Observable.just(1,2,1,1,2,3,4)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtil.e("integer = " + integer);
                    }
                });
    }

    private void test10() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("i am value " + integer);
                }
                int delayTime = (int)(1 + Math.random() * 10);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        LogUtil.e("concatMap:accept:" + s);
                    }
                });
    }

    private void test9() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("i am value " + integer);
                }
                int delayTime = (int)(1 + Math.random() * 10);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.e("flatMap:accept:" + s);
            }
        });
    }

    private void test8() {
        Observable.concat(Observable.just(1,2,3),Observable.just(4,5,6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtil.e("integer = " + integer);
                    }
                });
    }

    private void test7() {
        Observable.zip(getStringObservable(), getIntegerObservable(), new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.e("zip: " + s);
            }
        });

    }

    private Observable<String> getStringObservable(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext("A");
                    LogUtil.e("String emit A");
                    emitter.onNext("B");
                    LogUtil.e("String emit B");
                    emitter.onNext("C");
                    LogUtil.e("String emit C");
                }
            }
        });
    }

    private Observable<Integer> getIntegerObservable(){
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext(1);
                    LogUtil.e("Integer emit 1");
                    emitter.onNext(2);
                    LogUtil.e("Integer emit 2");
                    emitter.onNext(3);
                    LogUtil.e("Integer emit 3");

                }
            }
        });
    }


    private void test6() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "this is result" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.e(s);
            }
        });


    }

    private void test5() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                LogUtil.e("Observable thread is : " + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        LogUtil.e("After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        LogUtil.e("After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                    }
                });
    }

    private void test() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                //执行一些其他操作
                //.............
                //执行完毕，触发回调，通知观察者
                e.onNext("我来发射数据");
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtil.e("onSubscribe");
            }

            @Override
            //观察者接收到通知,进行相关操作
            public void onNext(String aLong) {
                LogUtil.e("我接收到数据:" + aLong);
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.e("onError");
            }

            @Override
            public void onComplete() {
                LogUtil.e("onComplete");
            }
        };

        observable.subscribe(observer);
    }

    private void test2() {
        Observable<String> observable = Observable.just("just");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtil.e("test2");
            }

            @Override
            public void onNext(String s) {
                LogUtil.e("接收数据:" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    private void test3() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("hello" + i);
        }
        Observable<String> observable = Observable.fromIterable((Iterable<String>)list);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtil.e("test3");
            }

            @Override
            public void onNext(String s) {
                LogUtil.e("接收数据:" + s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                LogUtil.e("test3");
            }
        };
        observable.subscribe(observer);
    }

    private void test4() {
        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                LogUtil.e("Observable emit 1");
                e.onNext(1);
                LogUtil.e("Observable emit 2");
                e.onNext(2);
                LogUtil.e("Observable emit 3");
                e.onNext(3);
                e.onComplete();
                LogUtil.e("Observable emit 4");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() { // 第三步：订阅

            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                LogUtil.e("integer = " + integer);
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.e("onError : value : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                LogUtil.e("onComplete");
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
