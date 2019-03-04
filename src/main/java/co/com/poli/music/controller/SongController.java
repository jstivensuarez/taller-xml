package co.com.poli.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.com.poli.music.model.Song;
import co.com.poli.music.services.ISongServices;
import co.com.poli.music.util.Response;

@RestController
public class SongController {

    @Autowired
    private ISongServices songServices;

    @GetMapping("/song")
    public Response getAll() {
        Response response;
        try {
            response = createResponse(songServices.getAll(), "Get", 201, Boolean.TRUE);
        } catch (Exception e) {
            response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @GetMapping("/song/{id}")
    public Response get(@PathVariable int id) {
        Response response;
        try {
            response = createResponse(songServices.get(id), "Get id", 201, Boolean.TRUE);
        } catch (Exception e) {
            response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @PostMapping("/song")
    public Response create(@RequestBody Song song) {
        Response response;
        try {
            boolean result = songServices.create(song);
            response = createResponse(songServices.getAll(), "Created", 201, Boolean.TRUE);
        } catch (Exception e) {
            response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @PutMapping("/song")
    public Response update(@RequestBody Song song) {
        Response response;
        try {
            boolean result = songServices.update(song);
            response = createResponse(songServices.getAll(), "Updated", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    @DeleteMapping("/song/{id}")
    public Response delete(@RequestBody Song song) {
        Response response;
        try {
            boolean result = songServices.delete(song);
            response = createResponse(songServices.getAll(), "Deleted", 204, Boolean.TRUE);
        } catch (Exception e) {
            response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
        }
        return response;
    }

    public Response createResponse(Object responseBody, String message, int codeResponse, boolean status) {
        Response response = new Response();

        response.setBody(responseBody);
        response.setMessage(message);
        response.setCode(codeResponse);
        response.setStatus(status);

        return response;
    }

}
