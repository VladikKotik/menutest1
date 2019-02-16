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
//                new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy", "Galaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n"),
//                new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle", "Space Shuttledesc"),
//                new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion", "Galaxy Oriondesc"),
//                new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth", "Earthdesc"),
//                new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut", "Astronautdesc"),
//                new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite", "Satellitedesc"),
//                new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy", "Galaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n"),
//                new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle", "Space Shuttledesc"),
//                new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion", "Galaxy Oriondesc"),
//                new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth", "Earthdesc"),
//                new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut", "Astronautdesc"),
//                new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite", "Satellitedesc"),
                new SpacePhoto("https://news.rambler.ru/img/2018/08/17172603.149361.6667.jpg", "Galaxy", "Galaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n"),
                new SpacePhoto("https://www.eg.ru/wp-content/uploads/2017/12/91814095815080047.jpg", "Space Shuttle", "Space Shuttledesc"),
                new SpacePhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Wassilij_Grigorjewitsch_Perow_004.jpg/1200px-Wassilij_Grigorjewitsch_Perow_004.jpg", "Galaxy Orion", "«Охотники на привале» — картина русского художника-передвижника Василия Григорьевича Перова, написанная в 1871 году и относящаяся к позднему периоду творчества художника.\n Сюжет картины: На картине изображены три охотника, которые ведут между собой разговор. Главной чертой картины являются психологические портреты героев: один из них (слева) — пожилой, опытный охотник, видимо, из оскудевших дворян с увлечением и страстью рассказывающий о своих охотничьих «подвигах», второй (на втором плане) — средних лет, в русской крестьянской одежде, недоверчиво и с ухмылкой слушающий охотничьи байки своего собеседника, третий же (справа) — одетый «с иголочки» доверчивый молодой новичок, с трепетом выслушивающий россказни первого охотника, настолько заморочившими его, что он даже забывает зажечь папиросу в правой руке заготовленным в левой огоньком.\n" +
                        "\n" +
                        "Вся эта сцена происходит на фоне довольно мрачного осеннего пейзажа, что вносит тревожный оттенок в её комическое содержание.\n" +
                        "\n" +
                        "Любопытно также и сочетание в картине и жанровой бытовой картины, и пейзажа, и натюрморта из охотничьих вещей и дичи."),
                new SpacePhoto("https://24smi.org/public/media/news/2015/03/30/1427700820_3.jpg", "Earth", "Earthdesc"),
                new SpacePhoto("https://uznayvse.ru/images/stories2016/uzn_1459856908.jpg", "Astronaut", "Astronautdesc"),
                new SpacePhoto("https://upload.wikimedia.org/wikipedia/commons/9/96/Vincent_van_Gogh_-_Self_Portrait_with_Bandaged_Ear_and_Pipe.jpg", "Satellite", "Satellitedesc"),
                new SpacePhoto("https://uznayvse.ru/images/stories2016/uzn_1459857456.jpg", "Galaxy", "Galaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydesssscGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\n\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\nGalaxydessssc\n"),
                new SpacePhoto("http://art-assorty.ru/uploads/posts/2017-02/1487493290_avtoportret.jpg", "Space Shuttle", "Space Shuttledesc"),
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