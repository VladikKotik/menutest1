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

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<CategoryModel> categories;
    private Context mContext;

    public CategoriesAdapter(Context context, List<CategoryModel> categories) {
        this.categories = categories;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryModel category = categories.get(position);

        ImageView imageView = holder.image;
        GlideUrl url = new GlideUrl(category.getGuid(), new LazyHeaders.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .build());
        Glide.with(mContext)
                .load(url)
                .placeholder(R.drawable.ic_cloud_off_red)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)// не катит чета!!!
                .into(imageView);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            holder.post.setText(Html.fromHtml(post.getPostContent(), Html.FROM_HTML_MODE_LEGACY));
//        } else {
//            holder.post.setText(Html.fromHtml(post.getPostContent()));
//        }
        holder.title.setText(category.getTitle());

    }

    @Override
    public int getItemCount() {
        if (categories == null)
            return 0;
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //TextView post;
        TextView title;
        ImageView image;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.category_title);
            image=(ImageView) itemView.findViewById(R.id.category_photo);
            cv=(CardView) itemView.findViewById(R.id.cv_category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                CategoryModel oneCategory = categories.get(position);
                Intent intent = new Intent(mContext, ExposActivity.class);
                intent.putExtra("category_ID", Integer.parseInt(oneCategory.getID()));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
    }
}