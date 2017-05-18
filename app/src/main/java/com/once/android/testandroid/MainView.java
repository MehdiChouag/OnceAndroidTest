package com.once.android.testandroid;

import com.once.android.testandroid.datamodel.RequestModel;
import java.util.List;

/**
 * Created by mehdi on 18/05/2017.
 */
public interface MainView {

  void displayList(List<RequestModel> models);

  void displayError(String error);
}
