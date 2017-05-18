package com.once.android.testandroid;

import android.support.annotation.NonNull;
import com.once.android.testandroid.datamodel.RequestModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

public class MainPresenter {

  private final CompositeDisposable disposable;
  private final ListRepository repository;

  private MainView view;

  @Inject public MainPresenter(ListRepository repository) {
    disposable = new CompositeDisposable();
    this.repository = repository;
  }

  public void setView(@NonNull MainView view) {
    this.view = view;
  }

  public void start() {
    disposable.add(repository.fetchList().subscribe(new Consumer<List<RequestModel>>() {
      @Override
      public void accept(@io.reactivex.annotations.NonNull List<RequestModel> requestModels)
          throws Exception {
        view.displayList(requestModels);
      }
    }, new Consumer<Throwable>() {
      @Override public void accept(@io.reactivex.annotations.NonNull Throwable throwable)
          throws Exception {
        view.displayError("An error as occurred");
      }
    }));
  }

  public void stop() {
    disposable.clear();
  }
}
