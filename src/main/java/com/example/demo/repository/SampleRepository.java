package com.example.demo.repository;

import java.time.OffsetDateTime;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SampleObject;

@Repository
public class SampleRepository {

	public SampleObject sampleGet() {
		SampleObject sample = new SampleObject();
		sample.setid("Some Id");
		sample.setCreatedTime(OffsetDateTime.now());
		sample.setMessage("GET API Return SUCCESS!");
		return sample;
	}
	
	public SampleObject samplePost(SampleObject sample) {
		sample.setCreatedTime(OffsetDateTime.now());
		sample.setMessage("POST API Return SUCCESS!");
		return sample;
	}
	
	public SampleObject sampleUpdate(String id, SampleObject sample) {
		sample.setid(id);
		sample.setCreatedTime(OffsetDateTime.now());
		sample.setMessage("PUT API Return SUCCESS!");
		return sample;
	}

	public SampleObject sampleDelete(String id) {
		SampleObject sample = new SampleObject();
		sample.setid(id);
		sample.setCreatedTime(OffsetDateTime.now());
		sample.setMessage("DELETE API Return SUCCESS!");
		return sample;
	}
}
