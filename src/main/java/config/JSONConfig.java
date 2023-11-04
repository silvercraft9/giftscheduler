/**
 * 
 */
package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import core.exclusion.IExclusion;
import core.member.IMember;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * @author roland
 *
 */
public class JSONConfig implements IConfig {

	
	private String path;
	private JSONParser parser;
	private Object content;
	
	public JSONConfig(String path) {
		this.path = path;
		this.parser = new JSONParser();
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean init() {
		boolean res = true;
		try (FileReader reader = new FileReader(this.getPath())) {
			
			this.content = this.parser.parse(reader);
			
			JSONArray memberArray = (JSONArray) this.content;
			
		} catch(FileNotFoundException e) {
			res = false;
			e.printStackTrace();
		} catch(IOException e) {
			res = false;
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			res = false;
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String getEventName() {
		 return null;
	}
	
	public ArrayList<IMember> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<IExclusion> getExclusions() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
