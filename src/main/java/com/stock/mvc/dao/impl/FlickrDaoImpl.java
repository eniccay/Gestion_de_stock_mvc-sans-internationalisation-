package com.stock.mvc.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stock.mvc.dao.IFlickrDao;

import org.scribe.model.Token;
import org.scribe.model.Verifier;


/*import org.scribe.model.Token;
import org.scribe.model.Verifier;

import.com.flick4java.flickr.Flickr;
import.com.flick4java.flickr.FlickrException;
import.com.flick4java.flickr.REST;
import.com.flick4java.flickr.RequestContext;
import.com.flick4java.flickr.auth.Auth;
import.com.flick4java.flickr.auth.AuthInterface;
import.com.flick4java.flickr.auth.Permission,
import.com.flick4java.flickr.uploader.UploadMetaData;*/

public class FlickrDaoImpl implements IFlickrDao {
	
	
	private Flickr flickr ;
	private UploadMetaData uploadMetaData =new UploadMetaData();
	private String apikey="24169cb19ec25da6bdc63eef937c4b03";
	private String sharedSecret="2451b57abb92bbea";
	
	//methode connect
	private void connect (){
		flickr =new Flickr(apikey,sharedSecret,new REST());
		Auth auth =new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157672211502557-7f4eef3018f9a46b");
		auth.setTokenSecret("1a57daae0ff8fa0e");
		RequestContext  requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
		}
		
	
	//methode save photo
		@Override
		public String savePhoto(InputStream photo ,String title) throws Exception{
		connect();
		uploadMetaData.setTitle(title);
		String photoId =flickr.getUploader().upload(photo,uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
		}
		
		
		//ùethode d'authentification a flickr
		public void auth(){
			flickr=new Flickr(apikey,sharedSecret,new REST());
			AuthInterface authInterface =flickr.getAuthInterface();
			Token token = authInterface.getRequestToken();
			System.out.println("token:" + token);
			String url=authInterface.getAuthorizationUrl(token,Permission.DELETE);
			System.out.println("FOLLOW THIS URL TO authorise yourself on flickr");
			System.out.println(url);
			System.out.println("Paste in the token it gives  you :");
			System.out.println(">>");
			
			String tokenKey = JOptionPane.showInputDialog("null");
			
			Token requestToken =authInterface.getAccessToken(token, new Verifier(tokenKey)); 
			System.out.println("Authentification sucess");
			Auth auth=null;
			try{
				auth = authInterface.checkToken(requestToken);
				}catch(FlickrException e){
				e.printStackTrace();
				}
			//this token can be used until teh user rovokes it
			System.out.println("token:" +requestToken.getToken());
			System.out.println("secret :"+requestToken.getSecret());
			System.out.println("nsid:"+auth.getUser().getId());
			System.out.println("realname:"+auth.getUser().getRealName());
			System.out.println("username:"+auth.getUser().getUsername());
			System.out.println("permission:"+auth.getPermission().getType());
			}
			
			

}
