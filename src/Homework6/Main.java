package Homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("228014")
                .addEncodedQueryParameter("apikey", "57kzRnfQbCpCOWSmcwn0vL48YxO948Hd")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(url);
        System.out.println(response.code());
        System.out.println(response.headers());
        String responseBody = response.body().string();
        System.out.println(responseBody);


    }

}
