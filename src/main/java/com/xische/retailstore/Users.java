package com.xische.retailstore;

import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import com.xische.retailstore.dtos.UserDto;

/**
 * The Users class is a singleton that manages a collection of UserDto objects.
 * It reads user data from a file and initializes the users list.
 * 
 * This class ensures that only one instance of the Users class exists and
 * provides a global point of access to it.
 * 
 * @author shanmugamr
 */
public class Users {

	private static Users instance;
	private ArrayList<UserDto> userInfo = new ArrayList<>();

	/**
	 * Private constructor for the singleton pattern. Reads user data from a file
	 * and initializes the users list.
	 * 
	 * The file is expected to be located at "classpath:templates/userinfo.db" and
	 * should contain user data in a tab-separated format.
	 */
	private Users() {
		try {
			File file = ResourceUtils.getFile("classpath:templates/userinfo.db");
			List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			for (String line : lines) {
				if (line.startsWith("#")) {
					continue;
				}
				UserDto user = new UserDto();
				String[] lineSplit = line.split("\t");

				user.setId(Integer.parseInt(lineSplit[0]));
				user.setName(lineSplit[1]);
				user.setSubscriptionDate(sdf.parse(lineSplit[2]));
				user.setType(lineSplit[3]);

				this.userInfo.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the singleton instance of the Users class.
	 * 
	 * @return the singleton instance of the Users class.
	 */
	public static synchronized Users getInstance() {
		if (instance == null) {
			instance = new Users();
		}
		return instance;
	}

	/**
	 * Returns the list of UserDto objects.
	 * 
	 * @return an ArrayList of UserDto objects.
	 */
	public ArrayList<UserDto> getUserInfo() {
		return userInfo;
	}
}
