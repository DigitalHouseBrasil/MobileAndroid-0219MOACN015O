
package com.example.albunsmusicasapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = "album")
public class Album {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @Expose
    private String idAlbum;
    @Expose
    private String idArtist;
    @Expose
    private String idLabel;
    @Expose
    private Object intLoved;
    @Expose
    private String intSales;
    @Expose
    private String intScore;
    @Expose
    private String intScoreVotes;
    @Expose
    private String intYearReleased;
    @Expose
    private String strAlbum;
    @Expose
    private Object strAlbum3DCase;
    @Expose
    private Object strAlbum3DFace;
    @Expose
    private Object strAlbum3DFlat;
    @Expose
    private Object strAlbum3DThumb;
    @Expose
    private String strAlbumCDart;
    @Expose
    private Object strAlbumSpine;
    @Expose
    private String strAlbumStripped;
    @Expose
    private String strAlbumThumb;
    @Expose
    private Object strAlbumThumbBack;
    @Expose
    private Object strAlbumThumbHQ;
    @Expose
    private Object strAllMusicID;
    @Expose
    private Object strAmazonID;
    @Expose
    private String strArtist;
    @Expose
    private String strArtistStripped;
    @Expose
    private Object strBBCReviewID;
    @Expose
    private Object strDescriptionCN;
    @Expose
    private Object strDescriptionDE;
    @Expose
    private String strDescriptionEN;
    @Expose
    private String strDescriptionES;
    @Expose
    private String strDescriptionFR;
    @Expose
    private Object strDescriptionHU;
    @Expose
    private Object strDescriptionIL;
    @Expose
    private Object strDescriptionIT;
    @Expose
    private Object strDescriptionJP;
    @Expose
    private Object strDescriptionNL;
    @Expose
    private Object strDescriptionNO;
    @Expose
    private Object strDescriptionPL;
    @Expose
    private String strDescriptionPT;
    @Expose
    private Object strDescriptionRU;
    @Expose
    private String strDescriptionSE;
    @Expose
    private Object strDiscogsID;
    @Expose
    private Object strGeniusID;
    @Expose
    private String strGenre;
    @Expose
    private Object strItunesID;
    @Expose
    private String strLabel;
    @Expose
    private Object strLocation;
    @Expose
    private String strLocked;
    @Expose
    private Object strLyricWikiID;
    @Expose
    private String strMood;
    @Expose
    private String strMusicBrainzArtistID;
    @Expose
    private String strMusicBrainzID;
    @Expose
    private Object strMusicMozID;
    @Expose
    private Object strRateYourMusicID;
    @Expose
    private String strReleaseFormat;
    @Expose
    private String strReview;
    @Expose
    private String strSpeed;
    @Expose
    private String strStyle;
    @Expose
    private String strTheme;
    @Expose
    private Object strWikidataID;
    @Expose
    private Object strWikipediaID;

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(String idArtist) {
        this.idArtist = idArtist;
    }

    public String getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(String idLabel) {
        this.idLabel = idLabel;
    }

    public Object getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(Object intLoved) {
        this.intLoved = intLoved;
    }

    public String getIntSales() {
        return intSales;
    }

    public void setIntSales(String intSales) {
        this.intSales = intSales;
    }

    public String getIntScore() {
        return intScore;
    }

    public void setIntScore(String intScore) {
        this.intScore = intScore;
    }

    public String getIntScoreVotes() {
        return intScoreVotes;
    }

    public void setIntScoreVotes(String intScoreVotes) {
        this.intScoreVotes = intScoreVotes;
    }

    public String getIntYearReleased() {
        return intYearReleased;
    }

    public void setIntYearReleased(String intYearReleased) {
        this.intYearReleased = intYearReleased;
    }

    public String getStrAlbum() {
        return strAlbum;
    }

    public void setStrAlbum(String strAlbum) {
        this.strAlbum = strAlbum;
    }

    public Object getStrAlbum3DCase() {
        return strAlbum3DCase;
    }

    public void setStrAlbum3DCase(Object strAlbum3DCase) {
        this.strAlbum3DCase = strAlbum3DCase;
    }

    public Object getStrAlbum3DFace() {
        return strAlbum3DFace;
    }

    public void setStrAlbum3DFace(Object strAlbum3DFace) {
        this.strAlbum3DFace = strAlbum3DFace;
    }

    public Object getStrAlbum3DFlat() {
        return strAlbum3DFlat;
    }

    public void setStrAlbum3DFlat(Object strAlbum3DFlat) {
        this.strAlbum3DFlat = strAlbum3DFlat;
    }

    public Object getStrAlbum3DThumb() {
        return strAlbum3DThumb;
    }

    public void setStrAlbum3DThumb(Object strAlbum3DThumb) {
        this.strAlbum3DThumb = strAlbum3DThumb;
    }

    public String getStrAlbumCDart() {
        return strAlbumCDart;
    }

    public void setStrAlbumCDart(String strAlbumCDart) {
        this.strAlbumCDart = strAlbumCDart;
    }

    public Object getStrAlbumSpine() {
        return strAlbumSpine;
    }

    public void setStrAlbumSpine(Object strAlbumSpine) {
        this.strAlbumSpine = strAlbumSpine;
    }

    public String getStrAlbumStripped() {
        return strAlbumStripped;
    }

    public void setStrAlbumStripped(String strAlbumStripped) {
        this.strAlbumStripped = strAlbumStripped;
    }

    public String getStrAlbumThumb() {
        return strAlbumThumb;
    }

    public void setStrAlbumThumb(String strAlbumThumb) {
        this.strAlbumThumb = strAlbumThumb;
    }

    public Object getStrAlbumThumbBack() {
        return strAlbumThumbBack;
    }

    public void setStrAlbumThumbBack(Object strAlbumThumbBack) {
        this.strAlbumThumbBack = strAlbumThumbBack;
    }

    public Object getStrAlbumThumbHQ() {
        return strAlbumThumbHQ;
    }

    public void setStrAlbumThumbHQ(Object strAlbumThumbHQ) {
        this.strAlbumThumbHQ = strAlbumThumbHQ;
    }

    public Object getStrAllMusicID() {
        return strAllMusicID;
    }

    public void setStrAllMusicID(Object strAllMusicID) {
        this.strAllMusicID = strAllMusicID;
    }

    public Object getStrAmazonID() {
        return strAmazonID;
    }

    public void setStrAmazonID(Object strAmazonID) {
        this.strAmazonID = strAmazonID;
    }

    public String getStrArtist() {
        return strArtist;
    }

    public void setStrArtist(String strArtist) {
        this.strArtist = strArtist;
    }

    public String getStrArtistStripped() {
        return strArtistStripped;
    }

    public void setStrArtistStripped(String strArtistStripped) {
        this.strArtistStripped = strArtistStripped;
    }

    public Object getStrBBCReviewID() {
        return strBBCReviewID;
    }

    public void setStrBBCReviewID(Object strBBCReviewID) {
        this.strBBCReviewID = strBBCReviewID;
    }

    public Object getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(Object strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public Object getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(Object strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(String strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public String getStrDescriptionFR() {
        return strDescriptionFR;
    }

    public void setStrDescriptionFR(String strDescriptionFR) {
        this.strDescriptionFR = strDescriptionFR;
    }

    public Object getStrDescriptionHU() {
        return strDescriptionHU;
    }

    public void setStrDescriptionHU(Object strDescriptionHU) {
        this.strDescriptionHU = strDescriptionHU;
    }

    public Object getStrDescriptionIL() {
        return strDescriptionIL;
    }

    public void setStrDescriptionIL(Object strDescriptionIL) {
        this.strDescriptionIL = strDescriptionIL;
    }

    public Object getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(Object strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public Object getStrDescriptionJP() {
        return strDescriptionJP;
    }

    public void setStrDescriptionJP(Object strDescriptionJP) {
        this.strDescriptionJP = strDescriptionJP;
    }

    public Object getStrDescriptionNL() {
        return strDescriptionNL;
    }

    public void setStrDescriptionNL(Object strDescriptionNL) {
        this.strDescriptionNL = strDescriptionNL;
    }

    public Object getStrDescriptionNO() {
        return strDescriptionNO;
    }

    public void setStrDescriptionNO(Object strDescriptionNO) {
        this.strDescriptionNO = strDescriptionNO;
    }

    public Object getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(Object strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
    }

    public String getStrDescriptionPT() {
        return strDescriptionPT;
    }

    public void setStrDescriptionPT(String strDescriptionPT) {
        this.strDescriptionPT = strDescriptionPT;
    }

    public Object getStrDescriptionRU() {
        return strDescriptionRU;
    }

    public void setStrDescriptionRU(Object strDescriptionRU) {
        this.strDescriptionRU = strDescriptionRU;
    }

    public String getStrDescriptionSE() {
        return strDescriptionSE;
    }

    public void setStrDescriptionSE(String strDescriptionSE) {
        this.strDescriptionSE = strDescriptionSE;
    }

    public Object getStrDiscogsID() {
        return strDiscogsID;
    }

    public void setStrDiscogsID(Object strDiscogsID) {
        this.strDiscogsID = strDiscogsID;
    }

    public Object getStrGeniusID() {
        return strGeniusID;
    }

    public void setStrGeniusID(Object strGeniusID) {
        this.strGeniusID = strGeniusID;
    }

    public String getStrGenre() {
        return strGenre;
    }

    public void setStrGenre(String strGenre) {
        this.strGenre = strGenre;
    }

    public Object getStrItunesID() {
        return strItunesID;
    }

    public void setStrItunesID(Object strItunesID) {
        this.strItunesID = strItunesID;
    }

    public String getStrLabel() {
        return strLabel;
    }

    public void setStrLabel(String strLabel) {
        this.strLabel = strLabel;
    }

    public Object getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(Object strLocation) {
        this.strLocation = strLocation;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    public Object getStrLyricWikiID() {
        return strLyricWikiID;
    }

    public void setStrLyricWikiID(Object strLyricWikiID) {
        this.strLyricWikiID = strLyricWikiID;
    }

    public String getStrMood() {
        return strMood;
    }

    public void setStrMood(String strMood) {
        this.strMood = strMood;
    }

    public String getStrMusicBrainzArtistID() {
        return strMusicBrainzArtistID;
    }

    public void setStrMusicBrainzArtistID(String strMusicBrainzArtistID) {
        this.strMusicBrainzArtistID = strMusicBrainzArtistID;
    }

    public String getStrMusicBrainzID() {
        return strMusicBrainzID;
    }

    public void setStrMusicBrainzID(String strMusicBrainzID) {
        this.strMusicBrainzID = strMusicBrainzID;
    }

    public Object getStrMusicMozID() {
        return strMusicMozID;
    }

    public void setStrMusicMozID(Object strMusicMozID) {
        this.strMusicMozID = strMusicMozID;
    }

    public Object getStrRateYourMusicID() {
        return strRateYourMusicID;
    }

    public void setStrRateYourMusicID(Object strRateYourMusicID) {
        this.strRateYourMusicID = strRateYourMusicID;
    }

    public String getStrReleaseFormat() {
        return strReleaseFormat;
    }

    public void setStrReleaseFormat(String strReleaseFormat) {
        this.strReleaseFormat = strReleaseFormat;
    }

    public String getStrReview() {
        return strReview;
    }

    public void setStrReview(String strReview) {
        this.strReview = strReview;
    }

    public String getStrSpeed() {
        return strSpeed;
    }

    public void setStrSpeed(String strSpeed) {
        this.strSpeed = strSpeed;
    }

    public String getStrStyle() {
        return strStyle;
    }

    public void setStrStyle(String strStyle) {
        this.strStyle = strStyle;
    }

    public String getStrTheme() {
        return strTheme;
    }

    public void setStrTheme(String strTheme) {
        this.strTheme = strTheme;
    }

    public Object getStrWikidataID() {
        return strWikidataID;
    }

    public void setStrWikidataID(Object strWikidataID) {
        this.strWikidataID = strWikidataID;
    }

    public Object getStrWikipediaID() {
        return strWikipediaID;
    }

    public void setStrWikipediaID(Object strWikipediaID) {
        this.strWikipediaID = strWikipediaID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
