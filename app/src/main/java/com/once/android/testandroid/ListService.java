package com.once.android.testandroid;

import com.once.android.testandroid.datamodel.Array;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by mehdi on 18/05/2017.
 */

public interface ListService {
  @GET("bins/2hjg2") @Headers("Cache-Control: max-age=3600") Single<Array> fetchList();
}
