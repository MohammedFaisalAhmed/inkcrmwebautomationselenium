package com.inkcrmwebautomationselenium.utilities;

import java.io.FileInputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil
{
	static ObjectMapper objectMapper;
	
	public static JsonNode getDataFromJson(String fileName,String arrayName,String  key, String value)
	{
		try
		{
			objectMapper = new ObjectMapper();
			FileInputStream fis = new FileInputStream(fileName);
			JsonNode rootNode=objectMapper.readTree(fis);
			for(JsonNode node:rootNode.get(arrayName))
			{
				if(node.get(key).asText().equals(value))
				{
					return node;
				}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static JsonNode getUserDataFromJson(String key)
	{
		return getDataFromJson("src/main/resources/testdata/json/data.json",arrayName,key,key)
	}
}
