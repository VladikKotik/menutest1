package things.test.ru.menutest1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<PostPreviewModel> posts;
    private Context mContext;

    public PostsAdapter(Context context, List<PostPreviewModel> posts) {
        this.posts = posts;
        mContext = context;
    }//кэшстратегия

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostPreviewModel post = posts.get(position);

        ImageView imageView = holder.image;
        GlideUrl url = new GlideUrl(post.getGuid(), new LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .build());
        Glide.with(mContext)
                .load(url)
                .placeholder(R.drawable.ic_cloud_off_red)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)// не катит чета!!!
                .into(imageView);


        holder.title.setText(post.getPostTitle());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TextView post;
        TextView title;
        ImageView image;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.postpreviewitem_title);
            image=(ImageView) itemView.findViewById(R.id.postpreviewitem_photo);
            cv=(CardView) itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                PostPreviewModel onePost = posts.get(position);
                Intent intent = new Intent(mContext, PostActivity.class);
                intent.putExtra("post_ID", Integer.parseInt(onePost.getID()));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
    }
}