package com.hostelapp.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jakarta.servlet.http.Part;
import java.util.UUID;

public class ImageUtil {

	// Generate a unique image name to prevent conflicts
	private String generateUniqueImageName(String originalFileName) {
		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		return UUID.randomUUID().toString() + fileExtension;
	}

	public String getImageNameFromPart(Part part) {
		// Retrieve the content-disposition header from the part
		String contentDisp = part.getHeader("content-disposition");

		// Split the header by semicolons to isolate key-value pairs
		String[] items = contentDisp.split(";");

		// Initialize imageName variable to store the extracted file name
		String imageName = null;

		// Iterate through the items to find the filename
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// Extract the file name from the header value
				imageName = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}

		// Return the extracted file name or a generated unique name
		return imageName != null && !imageName.isEmpty() ? generateUniqueImageName(imageName) : "default_image.png";
	}

	/**
	 * Uploads the image file from the given {@link Part} object to a specified
	 * directory on the server.
	 * 
	 * @param part       the {@link Part} object representing the uploaded image
	 *                   file.
	 * @param rootPath   the root directory where images will be saved.
	 * @param saveFolder the subfolder where the images will be saved.
	 * @return {@code true} if the file was successfully uploaded, {@code false}
	 *         otherwise.
	 */
	public boolean uploadImage(Part part, String rootPath, String saveFolder, String imageName) {
		String savePath = getSavePath(rootPath, saveFolder);
		File fileSaveDir = new File(savePath);

		if (!fileSaveDir.exists() && !fileSaveDir.mkdirs()) {
			return false;
		}

		try {
			String filePath = Paths.get(savePath, imageName).toString();
			part.write(filePath);
			System.out.println("successfully created ");
			System.out.println("Saving image to: " + filePath);
			System.out.println("Root path: " + rootPath);
			System.out.println("Save path: " + savePath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns the full path where the image should be saved, including the root
	 * path and save folder.
	 * 
	 * @param rootPath   the root directory path.
	 * @param saveFolder the subfolder to save the image in.
	 * @return the full save path as a String.
	 */
	public String getSavePath(String rootPath, String saveFolder) {
		// Use relative paths for portability
		return rootPath + "/resources/images/" + saveFolder + "/";
	}
}
