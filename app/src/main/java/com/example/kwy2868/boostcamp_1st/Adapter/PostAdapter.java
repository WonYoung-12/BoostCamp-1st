package com.example.kwy2868.boostcamp_1st.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kwy2868.boostcamp_1st.Model.PostList;
import com.example.kwy2868.boostcamp_1st.ViewHolder.PostViewHolder;
import com.example.kwy2868.boostcamp_1st.R;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{
    // 글 수.
    private int count;
    // 뷰홀더.
    private PostViewHolder postViewHolder;
    private PostList postList;

    public PostAdapter(int count) {
        this.count = count;
    }

    public void setPostList(PostList postList) {
        this.postList = postList;
    }

    // 헤더나 푸터를 사용할 때는 이 부분 사용해서 int 값을 반환해준다.
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.posting;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutForListItem, parent, shouldAttachToParentImmediately);
        postViewHolder = new PostViewHolder(view);
        postViewHolder.setPostList(postList);

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Log.d("Item Number", "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
