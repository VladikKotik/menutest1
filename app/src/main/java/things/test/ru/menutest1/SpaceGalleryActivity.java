package things.test.ru.menutest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SpaceGalleryActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gallery);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ImageGalleryAdapter adapter = new ImageGalleryAdapter(this, SpacePhoto.getSpacePhotos());
        recyclerView.setAdapter(adapter);
    }


    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {//закинуть св активити спейс галереи

        private SpacePhoto[] mSpacePhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, SpacePhoto[] spacePhotos) {
            mContext = context;
            mSpacePhotos = spacePhotos;
        }

        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View photoView = inflater.inflate(R.layout.item_photo, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            SpacePhoto spacePhoto = mSpacePhotos[position];
            ImageView imageView = holder.mPhotoImageView;
            Glide.with(mContext)
                    .load(spacePhoto.getUrl())
                    .placeholder(R.drawable.ic_cloud_off_red)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mSpacePhotos.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {
                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    SpacePhoto spacePhoto = mSpacePhotos[position];
                    Intent intent = new Intent(mContext, SpacePhotoActivity.class);
                    intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
                    startActivity(intent);//все активити над прописывать в манифесте!!
                }
            }
        }

    }
}