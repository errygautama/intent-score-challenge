package id.putraprima.skorbola;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class DataScore implements Parcelable {
    private String homeText, awayText, namescorer;
    private int homeScore, awayScore, scorer;
    private Uri homeUri, awayUri;
    private String homeScorer, awayScorer;

    public DataScore(String homeText, String awayText, int homeScore, int awayScore, Uri homeUri, Uri awayUri) {
        this.homeText = homeText;
        this.awayText = awayText;
        this.namescorer = namescorer;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.scorer = scorer;
        this.homeUri = homeUri;
        this.awayUri = awayUri;
        this.homeScorer = homeScorer;
        this.awayScorer = awayScorer;
    }

    public String getHomeText() {
        return homeText;
    }

    public void setHomeText(String homeText) {
        this.homeText = homeText;
    }

    public String getAwayText() {
        return awayText;
    }

    public void setAwayText(String awayText) {
        this.awayText = awayText;
    }

    public String getNamescorer() {
        return namescorer;
    }

    public void setNamescorer(String namescorer) {
        this.namescorer = namescorer;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getScorer() {
        return scorer;
    }

    public void setScorer(int scorer) {
        this.scorer = scorer;
    }

    public Uri getHomeUri() {
        return homeUri;
    }

    public void setHomeUri(Uri homeUri) {
        this.homeUri = homeUri;
    }

    public Uri getAwayUri() {
        return awayUri;
    }

    public void setAwayUri(Uri awayUri) {
        this.awayUri = awayUri;
    }

    public String getHomeScorer() {
        return homeScorer;
    }

    public void setHomeScorer(String homeScorer) {
        this.homeScorer = homeScorer;
    }

    public String getAwayScorer() {
        return awayScorer;
    }

    public void setAwayScorer(String awayScorer) {
        this.awayScorer = awayScorer;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.homeText);
        dest.writeString(this.awayText);
        dest.writeString(this.namescorer);
        dest.writeInt(this.homeScore);
        dest.writeInt(this.awayScore);
        dest.writeInt(this.scorer);
        dest.writeParcelable(this.homeUri, flags);
        dest.writeParcelable(this.awayUri, flags);
        dest.writeString(this.homeScorer);
        dest.writeString(this.awayScorer);
    }

    protected DataScore(Parcel in) {
        this.homeText = in.readString();
        this.awayText = in.readString();
        this.namescorer = in.readString();
        this.homeScore = in.readInt();
        this.awayScore = in.readInt();
        this.scorer = in.readInt();
        this.homeUri = in.readParcelable(Uri.class.getClassLoader());
        this.awayUri = in.readParcelable(Uri.class.getClassLoader());
        this.homeScorer = in.readString();
        this.awayScorer = in.readString();
    }

    public static final Creator<DataScore> CREATOR = new Creator<DataScore>() {
        @Override
        public DataScore createFromParcel(Parcel source) {
            return new DataScore(source);
        }

        @Override
        public DataScore[] newArray(int size) {
            return new DataScore[size];
        }
    };
}


