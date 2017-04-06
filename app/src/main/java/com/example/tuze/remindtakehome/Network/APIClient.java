package com.example.tuze.remindtakehome.Network;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class APIClient {

    static final String CLIENT_ID_TAG = "client_id";
    static final String CLIENT_ID = "L0URPJYAFVTGZXSPW40DM3NKKQBDXACRR220X4H2DB4E0PCN";
    static final String CLIENT_SECRET_TAG = "client_secret";
    static final String CLIENT_SECRET = "GGLH3MP0MSWGV5J1UYTIETIK1NFTDGAKP0BS0BTC1BNP10KZ";
    static final String VERSION_TAG = "v";
    static final String VERSION = "20170326";
    static final String API_BASE_URL = "https://api.foursquare.com/v2/";
    static final String API_SEARCH_URL = "venues/explore?";
    static final String API_VENUE_PHOTOS_URL = "venues/";
    static final String API_PHOTOS_URL = "/photos";
    static final String API_QUERY_TAG = "query";
    static final String API_NEAR_TAG = "near";
    static final String API_LIMIT_TAG = "limit";
    static final String API_VENUE_PHOTOS_TAG = "venuePhotos";
    static final String VENUE_LIMIT = "25";
    static final String PHOTO_LIMIT = "50";
    static final String PHOTO_NUMBER = "1";

    private OkHttpClient client;


    public APIClient() {
        this.client = new OkHttpClient();
    }

    //Get all venues according to city name, category
    public void getVenues(String city, String query, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_BASE_URL + API_SEARCH_URL).newBuilder();
        urlBuilder.addQueryParameter(API_NEAR_TAG, city);
        urlBuilder.addQueryParameter(API_LIMIT_TAG, VENUE_LIMIT);
        urlBuilder.addQueryParameter(API_VENUE_PHOTOS_TAG, PHOTO_NUMBER);
        if (query != null)
            urlBuilder.addQueryParameter(API_QUERY_TAG, query);
        urlBuilder.addQueryParameter(CLIENT_ID_TAG, CLIENT_ID);
        urlBuilder.addQueryParameter(CLIENT_SECRET_TAG, CLIENT_SECRET);
        urlBuilder.addQueryParameter(VERSION_TAG, VERSION);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    //Get venue photos
    public void getVenuePhotos(String venueId, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_BASE_URL + API_VENUE_PHOTOS_URL + venueId + API_PHOTOS_URL).newBuilder();
        urlBuilder.addQueryParameter(API_LIMIT_TAG, PHOTO_LIMIT);
        urlBuilder.addQueryParameter(CLIENT_ID_TAG, CLIENT_ID);
        urlBuilder.addQueryParameter(CLIENT_SECRET_TAG, CLIENT_SECRET);
        urlBuilder.addQueryParameter(VERSION_TAG, VERSION);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
