/**
 * 
 */
package config;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import core.exclusion.IExclusionSet;
import core.member.IMember;

/**
 * @author ro6k4
 *
 */
public class XmlConfigParser implements IConfigParser {
	
	private String filename;
	private final DocumentBuilderFactory factory;
	private final DocumentBuilder builder;
	private final Document document;
	
	//TODO add members and exclusion set
	
	public XmlConfigParser(String filename) throws ParserConfigurationException, SAXException, IOException{
		this.filename = filename;
		this.factory = DocumentBuilderFactory.newInstance();
		this.builder = factory.newDocumentBuilder();
		this.document = builder.parse(this.getFilename());
	}

	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<IMember> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IExclusionSet getExclusions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}


	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
