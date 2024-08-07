package com.example.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Images;
import com.example.entity.Student;
import com.example.service.ImageService;
import com.example.service.StudentService; 

@RestController
@RequestMapping("/stud")
public class Controller {
	
	@Autowired
	StudentService studservice;
	
	@Autowired
	private ImageService imageservice;
	
	private static final String dectory = "C:\\Users\\ADMIN\\Desktop\\aws   devops";
	
	@Value("${file.read.anykey}")
	private String fileloacation ; // this variable will get the value from the application.prp using @value
	
	@GetMapping("/demo")
	public String getstringfrom() {
		return "tushar from suit";
	}
	
	@GetMapping("/stud")
	public List<Student> getthelistofstud(){
		System.out.println("jakdsjf");
		return  studservice.getlistofstudent();
	}
	
	@PostMapping("/save")
	public Student savethestudent(@Valid  @RequestBody Student sud) {	
		return studservice.savethestudent(sud);
	}
	//save insert --@PostMapping
	//update ---@PutMapping
	@PutMapping("/update")
	public ResponseEntity<Student>  updatethestudentcity(@RequestBody Student stud){
		System.out.println(1123);
		Optional<Student> optinalstud =  studservice.findthestudentbyid(stud.getId());
		if(optinalstud.isPresent())
		{
			Student student = optinalstud.get();
			student.setCity(stud.getCity());
			studservice.updatethecityusingrollno(student.getId(),student.getCity().toString());
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}
		return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);	
	}
	
	@GetMapping("/getbyname")
	public List<Student> getthelistofname(@RequestParam String name ){
		return  studservice.getthesudentbyname(name);
	}
	
	@PostMapping("/salstfstdnt")
	public List<Student> savthstdntlst(@RequestBody List<Student> stdlst){
		System.out.println(stdlst);
		return studservice.savthstdntthghlst(stdlst);
	}
	@PutMapping("/updatebyusingsave")
	public String datsngsav(@RequestParam Integer id,@RequestBody  Student stdlst) {
		Optional<Student> optinalstud =  studservice.findthestudentbyid(id);
		if(optinalstud.isPresent())
		{
			Student std =  optinalstud.get();
			std.setCity(stdlst.getCity());
			std.setEmail(stdlst.getEmail());
			studservice.savethestudent(std);
			return "succeesssfully saved";
		}
		return "errror occured " ;
	} 
	
	@GetMapping("/deletestudent")
	public String  DeleteTheStudentById(@RequestParam Integer  num)
	{
		return  studservice.DeleteStudentbyId(num);
	}
	
	
	@PostMapping("/uplodecsv")
	public ResponseEntity<List<Student>> savethestudentlistbycsafiled(@RequestParam("field") MultipartFile file){
		try {
			List<Student> studentlistasResponse =  studservice.savethestudentlistfromcsvfile(file);
			 return new ResponseEntity<>(studentlistasResponse ,HttpStatus.CREATED);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		//in postman while giving the request with csv file  we use the form-data option 
		//key as field in that select file and then browse the file 
	}
	
	@PostMapping("/savetheimage")
	public ResponseEntity<?> savethestudentimage(@RequestParam("field") MultipartFile photo) throws IOException {
		Images image =  imageservice.savetheimagetodb(photo);
		  return new ResponseEntity<>( image,HttpStatus.CREATED);
	}
	
	@GetMapping("/getimagebyid/{id}")
	public ResponseEntity<?> gettheimagesasperid(@PathVariable Integer id ) throws IOException{
		Optional<Images> image =  imageservice.gettheimagebyid(id);
		if(image.isPresent()) {
			Images imagreal = image.get();
			//return  ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"").body(imagreal.getImagedata());
			//return  ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"inline").body(imagreal.getImagedata());
			return  ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"")
					.contentType(MediaType.IMAGE_PNG)  // this is helping us to direclty view the image  
					.body(imagreal.getImagedata());
		}  
		return  new  ResponseEntity<>( "Please check the id of image ",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/readthefile")
	public ResponseEntity<?> readthefilefromtheurl(@RequestParam("onlyfilenamewithextension") String  filename ) {
		Path paht =  Paths.get(dectory, filename);
		System.out.println(paht);
		String  respoinse =   studservice.readthefile(paht);
		return  new ResponseEntity<>(respoinse ,HttpStatus.OK); 
	}
	///this method will get  the url from the appl.properties file 
	@GetMapping("/readrthefrom_app_prop")
	public ResponseEntity<?> readthefilefromapplicationproperties(@RequestParam("filename") String filename ){
		Path path =  Paths.get(fileloacation, filename);
		System.out.println("path "+path);
		String response = studservice.readthefile(path);
		return  new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>  methodforvalisation(MethodArgumentNotValidException ErrorGenerated){
		Map<String,String> errors = new HashMap<>();
		List<ObjectError> allerrors =  ErrorGenerated.getBindingResult().getAllErrors();
		for(ObjectError error :  allerrors )
		{
			String fieldname = ((org.springframework.validation.FieldError)error).getField();
			String errormessage = error.getDefaultMessage();
			errors.put(fieldname, errormessage);
		}
		return errors;
	}
	
	
}
