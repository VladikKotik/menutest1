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

public class ExposAdapter extends RecyclerView.Adapter<ExposAdapter.ViewHolder> {

    private List<ExpoPreviewModel> expos;
    private Context mContext;

    public ExposAdapter(Context context, List<ExpoPreviewModel> expos) {
        this.expos = expos;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expo_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ExpoPreviewModel expo = expos.get(position);   //тут

        ImageView imageView = holder.image;
        GlideUrl url = new GlideUrl(expo.getGuid(), new LazyHeaders.Builder()
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
        holder.title.setText(expo.getPostTitle());

    }

    @Override
    public int getItemCount() {
        if (expos == null)
            return 0;
        return expos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView image;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.expopreview_title);
            image=(ImageView) itemView.findViewById(R.id.expopreview_photo);
            cv=(CardView) itemView.findViewById(R.id.cv_expo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                ExpoPreviewModel oneExpo = expos.get(position);
                Intent intent = new Intent(mContext, ExpoActivity.class);
                intent.putExtra("expo_ID", Integer.parseInt(oneExpo.getID()));
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent);
            }
        }
    }
}