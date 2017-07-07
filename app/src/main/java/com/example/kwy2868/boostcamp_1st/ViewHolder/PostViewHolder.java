package com.example.kwy2868.boostcamp_1st.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwy2868.boostcamp_1st.Model.Post;
import com.example.kwy2868.boostcamp_1st.Model.PostList;
import com.example.kwy2868.boostcamp_1st.R;

/**
 * Created by kwy2868 on 2017-07-04.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{
    private ImageView authorImage;
    private TextView authorName;
    private TextView content;
    private ImageView contentImage;
    private PostList postList;

    private Button likeButton;
    private Button commentButton;
    private Button shareButton;

    public void setPostList(PostList postList) {
        this.postList = postList;
    }

    public PostViewHolder(View itemView) {
        super(itemView);

        authorImage = (ImageView)itemView.findViewById(R.id.author_image);
        authorName = (TextView)itemView.findViewById(R.id.author_name);
        content = (TextView)itemView.findViewById(R.id.content);
        contentImage = (ImageView)itemView.findViewById(R.id.content_image);

        likeButton = (Button)itemView.findViewById(R.id.like);
        commentButton = (Button)itemView.findViewById(R.id.comment);
        shareButton = (Button)itemView.findViewById(R.id.share);
    }

    public void bind(int position){
        final Post post = (Post)postList.getArrayList().get(position);
        authorImage.setImageResource(post.getAuthor_image());
        authorName.setText(post.getAuthor());
        content.setText(post.getContent());
        contentImage.setImageResource(post.getContent_image());

        authorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), post.getAuthor() + "님의 타임라인으로 이동합니다", Toast.LENGTH_SHORT).show();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), post.getAuthor() + "님의 게시물을 좋아합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), post.getAuthor() + "님의 게시물에 댓글을 답니다.", Toast.LENGTH_SHORT).show();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), post.getAuthor() + "님의 게시물을 공유합니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
