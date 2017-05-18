package com.once.android.testandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.once.android.testandroid.R;
import com.once.android.testandroid.datamodel.RequestModel;
import java.util.List;
import javax.inject.Inject;

/**
 * Adapter containing items.
 */
public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final int ITEM_PERSON = 0;
  private final int ITEM_DEVICE = 1;

  private final Context mContext;
  private List<RequestModel> mItems;

  @Inject public ItemsAdapter(Context context) {
    mContext = context.getApplicationContext();
  }

  public void setItem(List<RequestModel> model) {
    mItems = model;
    notifyDataSetChanged();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (viewType == ITEM_PERSON) {
      return new PersonViewHolder(LayoutInflater.from(mContext)
          .inflate(android.R.layout.simple_list_item_1, parent, false));
    } else {
      return new DeviceViewHolder(
          LayoutInflater.from(mContext).inflate(R.layout.item_device, parent, false));
    }
  }

  @Override public int getItemViewType(int position) {
    return mItems.get(position).name() != null ? ITEM_PERSON : ITEM_DEVICE;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (getItemViewType(position) == ITEM_PERSON) {
      ((PersonViewHolder) holder).showData(mItems.get(position));
    } else {
      ((DeviceViewHolder) holder).showData(mItems.get(position));
    }
  }

  @Override public int getItemCount() {
    return mItems == null ? 0 : mItems.size();
  }

  public class DeviceViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView age;
    ImageView profilePic;

    View mItemView;

    public DeviceViewHolder(View itemView) {
      super(itemView);
      mItemView = itemView;
      name = (TextView) itemView.findViewById(R.id.name);
      age = (TextView) itemView.findViewById(R.id.age);
      profilePic = (ImageView) itemView.findViewById(R.id.profile_pics);
    }

    public void showData(RequestModel model) {
      name.setText(model.name());
      age.setText(model.age());
    }
  }

  public class PersonViewHolder extends RecyclerView.ViewHolder {

    TextView deviceName;
    TextView awsomeness;

    public PersonViewHolder(View itemView) {
      super(itemView);

      deviceName = (TextView) itemView.findViewById(R.id.device_name);
      awsomeness = (TextView) itemView.findViewById(R.id.awesomeness);
    }

    public void showData(RequestModel model) {
      deviceName.setText(model.deviceName());
      awsomeness.setText(model.awesomeness());
    }
  }
}
