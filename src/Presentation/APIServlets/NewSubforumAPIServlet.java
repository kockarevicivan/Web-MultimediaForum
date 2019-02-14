package Presentation.APIServlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Subforum;
import Domain.Entities.User;
import Presentation.Viewmodels.ToastResponseModel;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(name = "NewSubforumAPIServlet", urlPatterns = { "/NewSubforumAPIServlet" }, loadOnStartup = 1)
public class NewSubforumAPIServlet extends HttpServlet {

	private Database db;

	public NewSubforumAPIServlet() {
		db = Database.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User current = (User)request.getSession().getAttribute("CurrentUser");
		ToastResponseModel responseModel = new ToastResponseModel();

		Part subforumNamePart;
		Part subforumDescriptionPart;
		Part filePart;
		Part rulesPart;
		Scanner s;
		InputStream filecontent;
		String subforumName = "";
		String subforumDescription = "";
		String iconPath = "";
		ArrayList<String> rules = new ArrayList<String>();

		try {
			rulesPart = request.getPart("rules");
			s = new Scanner(rulesPart.getInputStream());
			String rulesLine = s.nextLine();

			String[] tokens = rulesLine.split(",");
			for (String t : tokens) {
				rules.add(t);
			}
		} catch (Exception e) {

		}

		try {
			subforumNamePart = request.getPart("subforumName");
			s = new Scanner(subforumNamePart.getInputStream());
			subforumName = s.nextLine();
		} catch (Exception ex) {
			responseModel.status = "ERROR";
			responseModel.message = "Subforum name is required.";
			String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);
			response.getWriter().write(jsonContent);
			return;
		}

		try {
			subforumDescriptionPart = request.getPart("subforumDescription");
			s = new Scanner(subforumDescriptionPart.getInputStream());
			subforumDescription = s.nextLine();
		} catch (Exception ex) {
			responseModel.status = "ERROR";
			responseModel.message = "Subforum description is required.";
			String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);
			response.getWriter().write(jsonContent);
			return;
		}

		try {
			filePart = request.getPart("icon");
			filecontent = filePart.getInputStream();

			String fileName = getFileName(filePart);

			String rootPath = getServletContext().getRealPath("/images/userImages");

			iconPath = rootPath + "/" + fileName;

			OutputStream out = new FileOutputStream(new File(iconPath));
			IOUtils.copy(filecontent, out);
			filecontent.close();
			out.close();
		} catch (Exception ex) {
			responseModel.status = "ERROR";
			responseModel.message = "Subforum icon is required.";

			String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);
			response.getWriter().write(jsonContent);
			return;
		}

		Subforum newSubforum = new Subforum();
		newSubforum.name = subforumName;
		newSubforum.description = subforumDescription;
		newSubforum.iconPath = iconPath;
		newSubforum.rules = rules;
		newSubforum.id = UUID.randomUUID().toString();
		newSubforum.responsibleModerator = current;

		db.subforums.add(newSubforum);

		responseModel.status = "OK";
		responseModel.message = "Subforum created!";

		String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);
		response.getWriter().write(jsonContent);
		return;
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
