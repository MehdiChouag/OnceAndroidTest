package com.once.android.testandroid;

import com.once.android.testandroid.datamodel.Array;
import com.once.android.testandroid.datamodel.RequestModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by mehdi on 18/05/2017.
 */
public class ListRepositoryImpl implements ListRepository {

  private final ListService listService;

  @Inject public ListRepositoryImpl(ListService listService) {
    this.listService = listService;
  }

  @Override public Single<List<RequestModel>> fetchList() {
    return listService.fetchList().map(new Function<Array, List<RequestModel>>() {
      @Override public List<RequestModel> apply(@NonNull Array array) throws Exception {
        return array.array();
      }
    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
}
