/**
 * 
 */
package com.xische.retailstore.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xische.retailstore.daos.BillingDao;
import com.xische.retailstore.daos.BillingDaoImpl;

/**
 * The BillingController class provides RESTful endpoints for handling billing
 * operations. It includes methods to generate bills for users based on request
 * data.
 * 
 * The class uses Spring MVC annotations to map HTTP requests to handler
 * methods.
 * 
 * @author shanmugamr
 *
 */
@Controller
public class BillingController {

	/**
	 * Handles HTTP POST requests to the /bill/{userId} endpoint. This method
	 * generates a bill for the specified user based on the provided request data.
	 * 
	 * The {@code @RequestMapping} annotation maps this method to the specified URL
	 * pattern and HTTP method. The {@code @PathVariable} annotation extracts the
	 * userId from the URL path. The {@code @RequestBody} annotation binds the HTTP
	 * request body to the dftRequest parameter. The {@code @ResponseBody}
	 * annotation ensures that the returned ResponseEntity's body is serialized into
	 * JSON and written directly to the HTTP response.
	 * 
	 * @param httpRequest the HttpServletRequest object, which provides information
	 *                    about the HTTP request.
	 * @param response    the HttpServletResponse object, which provides information
	 *                    about the HTTP response.
	 * @param userId      the ID of the user for whom the bill is to be generated.
	 * @param request     the request body containing data necessary to generate the
	 *                    bill.
	 * @return a ResponseEntity containing a String message indicating the result of
	 *         the bill generation process.
	 */

	@RequestMapping(value = "/bill/{userId}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> generateBill(final HttpServletRequest httpRequest,
			final HttpServletResponse response, final @PathVariable String userId, final @RequestBody String request) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			JSONObject responseJSON = new JSONObject();

			BillingDao billingDao = new BillingDaoImpl();

			JSONObject requestJSON = new JSONObject(request);

			responseJSON = billingDao.generateBill(requestJSON, Integer.parseInt(userId));

			return new ResponseEntity<String>(responseJSON.toString(), headers, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
