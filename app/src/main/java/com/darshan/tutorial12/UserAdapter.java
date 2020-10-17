package com.darshan.tutorial12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private JSONArray jsonArray;
    Context context;

    public UserAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.materialCardView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.txtName.setText(jsonObject.getString("name"));
            holder.txtEmail.setText(jsonObject.getString("email"));
            holder.txtPhone.setText(jsonObject.getString("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtEmail, txtPhone;
        MaterialCardView materialCardView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardView = itemView.findViewById(R.id.cv_lstUser);
            txtName = (TextView) itemView.findViewById(R.id.header_name);
            txtEmail = (TextView) itemView.findViewById(R.id.data_email);
            txtPhone = (TextView) itemView.findViewById(R.id.data_number);
        }
    }
}
