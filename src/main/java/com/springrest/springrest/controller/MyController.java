package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courceService;

//	@GetMapping("/home")
//	public String home() {
//		return "Welcome to courses Application";
//	}
	
	//get the courses
	
	/*Alt for this
	 * @GetMapping("/courses")
	 *          or
	 * @RequestMapping(path="/courses",method=RequestMethod.GET)
	 * */
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		
		return this.courceService.getCourses();
	}
	
	//single course get
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courceService.getCourse(Long.parseLong(courseId));
	}
	
	//course add
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courceService.addCourse(course);
	}
	
	//
	@PutMapping("/courses")
	public Courses putCourse(@RequestBody Courses course) {
		return this.courceService.putCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courceService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
