package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;



@RestController
@RequestMapping("/demo")
public class DemoRestController {
	
	@PostMapping("/getFileContent")
	public ResponseEntity<Object> getFileContent(@RequestBody ObjectNode inputJsonObj) throws JsonMappingException, JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseWrapper wrapper = new ResponseWrapper();
		String schema = objectMapper.readValue(inputJsonObj.get("schema").toString(), String.class);
		//Parse schema
		Schema reqSchema = new Schema.Parser().parse(schema);
		List<SchemaField> fields = GetSchema(reqSchema);

		wrapper.setData(fields);
		return ok(wrapper);
	}

	//Extracts schema from request
	public static List<SchemaField> GetSchema(Schema schema) {
		List<SchemaField> schemaFields = new ArrayList<SchemaField>();
		for (Field field : schema.getFields()) {
			Field thisField = schema.getField(field.name());
			String fieldType = new String();
			if (Schema.Type.UNION.equals(thisField.schema().getType())) {
				List<Schema> types = thisField.schema().getTypes();
				fieldType = "Union(";
				for (int i=0; i< types.size();i++ ){
					fieldType += " "+types.get(i).getType();
				}
				fieldType += " )";
			}else{
				fieldType = String.valueOf(thisField.schema().getType());
			}
			System.out.println( " FieldName: "+ thisField.toString()+" FieldDoc: "+ thisField.doc()+ " FieldType: " +fieldType );

			schemaFields.add(new SchemaField(field.name(), fieldType, thisField.doc()));
		}
		return schemaFields;
	}
	

}
