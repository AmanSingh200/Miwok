package com.example.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;

import java.security.PublicKey;

public class word {
    /**
     * default translation of the word
     */
    private String mdefaultTranslation;

    /**
     * Miwok Translation of the word
     */
    private String mMiwokTranslation;


    private static final int NO_IMG_PROVIDED = -1;
    private int mimageResourceID = NO_IMG_PROVIDED;
    private int maudioResourceID;

    /**
     * constructor
     */
    public word(String defaultTranslation, String MiwokTranslation, int audioResourceID) {
        mdefaultTranslation = defaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        maudioResourceID = audioResourceID;
    }

    public word(String defaultTranslation, String MiwokTranslation, int imageResourceID, int audioResourceID) {
        mdefaultTranslation = defaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mimageResourceID = imageResourceID;
        maudioResourceID = audioResourceID;
    }

    /**
     * get default translation
     */
    public String getDefaultTranslation() {
        return mdefaultTranslation;
    }

    /**
     * get miwok translation
     */

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


    public int getImageResourceID() {
        return mimageResourceID;
    }

    /**
     * returns whether there is an image for this word or not
     */

    public boolean hasImage() {
        return mimageResourceID != NO_IMG_PROVIDED;
    }
    public int getAudioResourceID(){
        return maudioResourceID;
    }
}