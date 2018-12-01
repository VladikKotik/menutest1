package things.test.ru.menutest1;

import android.os.Parcel;
import android.os.Parcelable;

public class SpacePhoto implements Parcelable {

    private String mUrl;
    private String mTitle;
    private String mDescription;

    public SpacePhoto(String url, String title, String description) {
        mUrl = url;
        mTitle = title;
        mDescription = description;
    }

    protected SpacePhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
        mDescription=in.readString();
    }

    public static final Creator<SpacePhoto> CREATOR = new Creator<SpacePhoto>() {
        @Override
        public SpacePhoto createFromParcel(Parcel in) {
            return new SpacePhoto(in);
        }

        @Override
        public SpacePhoto[] newArray(int size) {
            return new SpacePhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDescription(String description){mDescription=description;}

    public String getDescription() {

        //mDescription="zaglushka_description";
        return mDescription;
    }

    public static  SpacePhoto[] getSpacePhotos() {

        return new SpacePhoto[]{
                new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy", "Galaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n"),
                new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle", "Space Shuttledesc"),
                new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion", "Galaxy Oriondesc"),
                new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth", "Earthdesc"),
                new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut", "Astronautdesc"),
                new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite", "Satellitedesc"),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
    }
}