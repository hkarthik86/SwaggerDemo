package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SampleObject;
import com.example.demo.service.SampleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="onlinestore", description="Operations pertaining to teh DEMO API's")
@RequestMapping("/demo/api")
public class SampleController {
	
	@Autowired
    private SampleService sampleService;
	
	/*
	 * This is a sample Get API for Swagger Integration.
	 * All GET API's need to be implemented in a similar fashion, and this method need to be deleted at the end
	 */
	@RequestMapping(value = "/sampleGet/", method = RequestMethod.GET)
	@ApiOperation(value = "Sample Get API for Swagger Integration", response = String.class)
    //Below annotation will override the default API response code descriptions in SWAGGER 2
  	@ApiResponses(value = {
  	   @ApiResponse(code = 200, message = "Successfully retrieved list"),
  	   @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
  	   @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
  	   @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  	})
    SampleObject sampleGet() {
        return sampleService.sampleGet();
    }
    
    
    /*
	 * This is a sample Create API for Swagger Integration.
	 * All Create API's need to be implemented in a similar fashion, and this method need to be deleted at the end
	 */
	@RequestMapping(value = "/samplePost/", method = { RequestMethod.POST })
	@ApiOperation(value = "Sample POST API for Swagger Integration", response = SampleObject.class)
    SampleObject samplePost(@RequestBody final SampleObject sample) {
        return sampleService.samplePost(sample);
    }
    
    /*
	 * This is a sample Update API for Swagger Integration.
	 * All Update API's need to be implemented in a similar fashion, and this method need to be deleted at the end
	 */
	@RequestMapping(value = "/samplePut/{id}", method = { RequestMethod.PUT })
	@ApiOperation(value = "Sample PUT API for Swagger Integration", response = String.class)
    public SampleObject sampleUpdate(@PathVariable("id") final String id, @RequestBody final SampleObject sample) {
		return sampleService.sampleUpdate(id, sample);
    }
	
    
    /*
	 * This is a sample DELETE API for Swagger Integration.
	 * All Delete API's need to be implemented in a similar fashion, and this method need to be deleted at the end
	 */
	@RequestMapping(value = "/sampleDelete/{id}", method = { RequestMethod.DELETE })
	@ApiOperation(value = "Sample DELETE API for Swagger Integration", response = SampleObject.class)
    SampleObject sampleDelete(@PathVariable("id") final String id) {
        return sampleService.sampleDelete(id);
    }
}
