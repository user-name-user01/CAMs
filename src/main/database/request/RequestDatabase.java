package main.database.request;

import main.database.Database;
import main.model.request.Request;
import main.model.request.RequestFactory;
import main.utils.config.Location;

import java.util.List;
import java.util.Map;

/**
 * The RequestRepository class is a repository that stores and retrieves Request objects
 * through file I/O operations.
 * It extends the Repository class, which provides basic CRUD operations for the repository.
 */
public class RequestDatabase extends Database<Request> {

    /**
     * The path of the repository file.
     */
    private static final String FILE_PATH = "/data/request/request.txt";

    /**
     * Constructor to create an instance of RequestRepository.
     */
    RequestDatabase() {
        super();
        load();
    }

    /**
     * Gets a new instance of RequestRepository.
     *
     * @return the instance of RequestRepository
     */
    public static RequestDatabase getInstance() {
        return new RequestDatabase();
    }

    /**
     * Gets the file path of the RequestRepository.
     *
     * @return the file path of the RequestRepository
     */
    @Override
    public String getFilePath() {
        return Location.RESOURCE_LOCATION + FILE_PATH;
    }

    /**
     * Sets the list of mappable objects.
     *
     * @param listOfMappableObjects the list of mappable objects
     */
    @Override
    public void setAll(List<Map<String, String>> listOfMappableObjects) {
        List<Request> requests = getAll();
        for (Map<String, String> map : listOfMappableObjects) {
            Request request = RequestFactory.createRequest(map);
            requests.add(request);
        }
    }
}
