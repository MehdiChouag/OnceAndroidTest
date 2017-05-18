package com.once.android.testandroid;

import com.once.android.testandroid.datamodel.RequestModel;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by mehdi on 18/05/2017.
 */
public interface ListRepository {
  public Single<List<RequestModel>> fetchList();
}
