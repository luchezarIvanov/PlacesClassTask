package bg.elsys.places.api.responses;

import java.util.List;

/**
 * Created by Deyan Genovski.
 */
public class PlacesResponse {

    private List<PlaceResponse> results;

    public List<PlaceResponse> getResults() {
        return results;
    }

    public void setResults(List<PlaceResponse> results) {
        this.results = results;
    }
}
