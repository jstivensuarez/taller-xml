package co.com.poli.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.com.poli.music.model.Playlist;
import co.com.poli.music.services.IPlaylistServices;
import co.com.poli.music.util.Response;

@RestController
public class PlaylistController {

	@Autowired
	private IPlaylistServices playlistServices;

	@GetMapping("/playlist")
	public Response getAll() {
		Response response;
		try {
			response = createResponse(playlistServices.getAll(), "Get", 200, Boolean.TRUE);
		} catch (Exception e) {
			response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
		}
		return response;
	}

	@GetMapping("/playlist/{id}")
	public Response get(@PathVariable int id) {
		Response response;
		try {
			response = createResponse(playlistServices.get(id), "Get id", 200, Boolean.TRUE);
		} catch (Exception e) {
			response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
		}
		return response;
	}
	
	@PostMapping("/playlist")
	public Response create(@RequestBody Playlist playlist) {
		Response response;
		try {
			boolean result = playlistServices.create(playlist);
			response = createResponse(playlistServices.getAll(), "Created", 201, Boolean.TRUE);
		} catch (Exception e) {
			response = createResponse(null, e.getMessage(), 400, Boolean.FALSE);
		}
		return response;
	}

	@PutMapping("/playlist")
	public Response update(@RequestBody Playlist playlist) {
		Response response;
		try {
			boolean result = playlistServices.update(playlist);
			response = createResponse(playlistServices.getAll(), "Updated", 204, Boolean.TRUE);
		} catch (Exception e) {
			response = createResponse(null, e.getMessage(), 404, Boolean.FALSE);
		}
		return response;
	}

	@DeleteMapping("/playlist/{id}")
	public Response delete(@RequestBody Playlist playlist) {
		Response response;
		try {
			boolean result = playlistServices.delete(playlist);
			response = createResponse(playlistServices.getAll(), "Deleted", 204, Boolean.TRUE);
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
