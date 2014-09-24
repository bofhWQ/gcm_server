/*
 * Copyright 2014 BOFH@willstequatschen.de.
 *
 * Read Config from XML File
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 
 */
package com.grokkingandroid.sampleapp.samples.gcm.ccs.server;
import java.io.File;
import java.io.IOException;


import nu.xom.Builder;
import nu.xom.Document;

import nu.xom.ParsingException;

public class Config {
  
	public String gcmserver;
	public int gcmport;
	public String projectid;
	public String serverkey;
	public String dbserver;
	public String db;
	public String dbuser;
	public String dbpassword;
	public int idle;
	
	private Builder builder;
	public  Config(String name)
	{
		builder=new Builder();
		Document doc=null;
		try {
			File file=new File(name);
			 doc = builder.build(file);
		} catch (ParsingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 gcmserver = doc.query("//gcm/server").get(0).getValue();
		 gcmport = Integer.parseInt(doc.query("//gcm/port").get(0).getValue());
		 projectid = doc.query("//gcm/projectid").get(0).getValue();
		 serverkey=doc.query("//gcm/serverkey").get(0).getValue();
		 dbserver=doc.query("//jdbc/server").get(0).getValue();
		 db=doc.query("//jdbc/db").get(0).getValue();
		 dbuser=doc.query("//jdbc/user").get(0).getValue();
		 dbpassword=doc.query("//jdbc/password").get(0).getValue();
		 idle=Integer.parseInt(doc.query("//sheduler/idle").get(0).getValue());
	}
}
