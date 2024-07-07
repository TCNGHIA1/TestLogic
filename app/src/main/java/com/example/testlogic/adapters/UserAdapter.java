package com.example.testlogic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testlogic.R;
import com.example.testlogic.models.User;
import com.example.testlogic.utils.OnClickListener;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.Shapeable;

import java.util.Objects;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private final AsyncListDiffer<User> differ = new AsyncListDiffer<>(this,new DifferCallback());

    public AsyncListDiffer<User> getDiffer() {
        return differ;
    }

    static class DifferCallback extends DiffUtil.ItemCallback<User>{

        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return Objects.equals(oldItem.getHtmlUrl(), newItem.getHtmlUrl());
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return Objects.equals(oldItem.getHtmlUrl(), newItem.getHtmlUrl());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user,parent,false);

        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView user_name;
        private TextView user_html;
        private ShapeableImageView user_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_name = itemView.findViewById(R.id.user_name);
            user_html = itemView.findViewById(R.id.user_html);
            user_image = itemView.findViewById(R.id.user_image);
        }
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = differ.getCurrentList().get(position);

        holder.user_name.setText(user.getLogin());
        holder.user_html.setText(user.getHtmlUrl());

        Glide.with(holder.itemView).load(user.getAvatarUrl()).into(holder.user_image);

        holder.itemView.setOnClickListener(view->{
            if(onClickListener!=null){
                onClickListener.onClickItem(user);
            }
        });
    }

    private static OnClickListener<User> onClickListener;

    public void setOnClickListener(OnClickListener<User> onClickListener) {
        UserAdapter.onClickListener = onClickListener;
    }
}
