package com.once.android.testandroid.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import java.util.List;

/**
 * Created by mehdi on 18/05/2017.
 */
@AutoValue @JsonDeserialize(builder = AutoValue_Array.Builder.class) public abstract class Array {

  @JsonProperty("array") public abstract List<RequestModel> array();

  @AutoValue.Builder public static abstract class Builder {

    @JsonProperty("array") public abstract Builder array(List<RequestModel> models);

    public abstract Array build();
  }
}
