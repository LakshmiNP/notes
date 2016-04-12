package controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import model.*;
import dao.notesDao;
@SuppressWarnings("unused")
@Controller
@RequestMapping("/notes")
public class NotesService {
				
					
			@RequestMapping(value = "/createNote/{txtNote}",  method = RequestMethod.POST,produces="application/json")
			@ResponseBody
			public String  createNote(@PathVariable("txtNote") String txtNote) throws JSONException, ParseException, ClassNotFoundException, JsonGenerationException, JsonMappingException  {
			
			NotesServiceImpl twtImpl = NotesServiceImpl.getInstance();
			String json = new Gson().toJson(twtImpl.insertNote(txtNote));
			return json;
			}
			
			
			@RequestMapping(value = "/getNote/{txtNote}",  method = RequestMethod.GET,produces="application/json")
			@ResponseBody
			public String  getNoteByText(@PathVariable("txtNote") String txtNote) throws JSONException, ParseException, ClassNotFoundException, JsonGenerationException, JsonMappingException  {	
			
			NotesServiceImpl twtImpl = NotesServiceImpl.getInstance();
			String json = new Gson().toJson(twtImpl.getNote(txtNote));
			return json;
			}
			
			
			@RequestMapping(value = "/updateNote/{txtNote}",  method = RequestMethod.PUT,produces="application/json")
			@ResponseBody
			public String  updateNote(@PathVariable("txtNote") String txtNote) throws JSONException, ParseException, ClassNotFoundException, JsonGenerationException, JsonMappingException  {
			
			NotesServiceImpl twtImpl = NotesServiceImpl.getInstance();
			String json = new Gson().toJson(twtImpl.updateNoteText(txtNote));
			return json;
			}
			
			
			@RequestMapping(value = "/removeNote/{txtNote}",  method = RequestMethod.DELETE,produces="application/json")
			@ResponseBody
			public String  removeNote(@PathVariable("txtNote") String txtNote) throws JSONException, ParseException, ClassNotFoundException, JsonGenerationException, JsonMappingException  {
			
			NotesServiceImpl twtImpl = NotesServiceImpl.getInstance();
			String json = new Gson().toJson(twtImpl.deleteNote(txtNote));
			return json;
			}
						
}
