package bg.elsys.places.api;

import bg.elsys.places.api.responses.PlacesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Deyan Genovski.
 */

public interface PlacesAPI {

    @GET("/maps/api/place/nearbysearch/json")
    public Call<PlacesResponse> getPlacesByLocation(@Query("location") String location,
                                                    @Query("key") String key,
                                                    @Query("rankby") String rankby,
                                                    @Query("type") String type);

}
