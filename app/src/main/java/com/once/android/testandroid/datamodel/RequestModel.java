package com.once.android.testandroid.datamodel;

import android.support.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

/**
 * Created by mehdi on 18/05/2017.
 */

@AutoValue @JsonDeserialize(builder = AutoValue_RequestModel.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL) @JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestModel {

  @JsonProperty("id") public abstract Integer id();

  @JsonProperty("name") @Nullable public abstract String name();

  @JsonProperty("picture_url") @Nullable public abstract String pictureUrl();

  @JsonProperty("age") @Nullable public abstract Integer age();

  @JsonProperty("device_name") @Nullable public abstract String deviceName();

  @JsonProperty("brand") @Nullable public abstract String brand();

  @JsonProperty("awesomeness") @Nullable public abstract Integer awesomeness();

  @AutoValue.Builder public static abstract class Builder {

    @JsonProperty("id") public abstract Builder id(Integer id);

    @JsonProperty("name") public abstract Builder name(@Nullable String name);

    @JsonProperty("picture_url") public abstract Builder pictureUrl(@Nullable String pictureUrl);

    @JsonProperty("device_name") public abstract Builder deviceName(@Nullable String deviceName);

    @JsonProperty("brand") public abstract Builder brand(@Nullable String brand);

    @JsonProperty("age") public abstract Builder age(@Nullable Integer age);

    @JsonProperty("awesomeness") public abstract Builder awesomeness(@Nullable Integer awesomeness);

    public abstract RequestModel build();
  }
}
