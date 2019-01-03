package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SampleObject;
import com.example.demo.repository.SampleRepository;

@Service
public class SampleService {
	
	@Autowired
	SampleRepository sampleRepository;

	public  SampleObject sampleGet() {
		return sampleRepository.sampleGet();
	}
	
	public  SampleObject samplePost(SampleObject sample) {
		return sampleRepository.samplePost(sample);
	}
	
	public SampleObject sampleUpdate(String id,SampleObject sample) {
		return sampleRepository.sampleUpdate(id, sample);
	}

	public SampleObject sampleDelete(String id) {
		return sampleRepository.sampleDelete(id);
	}
}
