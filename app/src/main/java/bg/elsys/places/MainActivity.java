package bg.elsys.places;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import bg.elsys.places.api.PlacesAPI;
import bg.elsys.places.api.responses.PlacesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        PlacesAPI placesAPI = retrofit.create(PlacesAPI.class);

        String location = "51.515580, -0.115356";
        String key = "AIzaSyCSDVKLdil7HKDgMbpT-E6eyqasbmtM8JY";
        String rankBy = "distance";
        String type = "bar";

        Call<PlacesResponse> request = placesAPI.getPlacesByLocation(location, key, rankBy, type);

        request.enqueue(new Callback<PlacesResponse>() {
            @Override
            public void onResponse(Call<PlacesResponse> call, Response<PlacesResponse> response) {
                if (response.isSuccessful()) {
                    PlacesResponse responseBody = response.body();
                    Log.d(TAG, "onResponse: " + responseBody.getResults().size());
                }
            }

            @Override
            public void onFailure(Call<PlacesResponse> call, Throwable t) {

            }
        });


    }
}
