package com.example.dudgn.retrofitexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dudgn.retrofitexample.model.Article;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Article> articlelist = new ArrayList<>();
    public void setData(List<Article> articleList){
        this.articlelist = articleList;
        notifyDataSetChanged(); // 데이터가 바뀐다음에 새로고침 해줘야 갱신됨.
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext()); //inflator는 뷰를 갖다 붙히는 느낌?
        View view = inflater.inflate(R.layout.item_articles,viewGroup,false); //뷰그룹은 뷰홀더들의 모임?
        return new ViewHolder(view);
    }

    //onBinderViewHoleder = 데이터 집어넣는거
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article article = articlelist.get(i);

        viewHolder.tvTitle .setText(article.getTitle());
        viewHolder.tvUsername.setText(article.getAuthor().getUsername());
        viewHolder.tvDay.setText(article.getCreatedAt());
        viewHolder.tvConetent.setText(article.getBody());
    }

    @Override
    public int getItemCount() { //요 사이즈만큼 리스트가 출력됨.
        return articlelist.size();
    }

    //어댑터에 뷰홀더가 필요함
    //뷰홀더는 하나의 뷰라고 보면 됨
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView tvUsername;
        public TextView tvDay;
        public TextView tvTitle;
        public TextView tvConetent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView); //super는 지우면 안됨
            imageView = itemView.findViewById(R.id.article_img);
            tvUsername = itemView.findViewById(R.id.article_txt1);
            tvDay = itemView.findViewById(R.id.article_txt2);
            tvTitle = itemView.findViewById(R.id.article_txt3);
            tvConetent = itemView.findViewById(R.id.article_txt4);
        }
    }
}
