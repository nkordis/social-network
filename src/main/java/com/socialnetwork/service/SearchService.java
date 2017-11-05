package com.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.socialnetwork.model.dto.SearchResult;
import com.socialnetwork.model.entity.Profile;
import com.socialnetwork.model.repository.ProfileDao;

@Service
public class SearchService {

	@Value("${results.pagesize}")
	private int pageSize;

	@Autowired
	ProfileDao profileDao;

	public Page<SearchResult> search(String text, int pageNumber) {

		PageRequest request = new PageRequest(pageNumber - 1, pageSize);

		Page<Profile> results = profileDao.findByInterestsNameContainingIgnoreCase(text, request);
		
		Converter<Profile, SearchResult> converter = new Converter<Profile, SearchResult>(){

			@Override
			public SearchResult convert(Profile profile) {
				return new SearchResult(profile);
			}
			
		};
		
		return results.map(converter);
	}

}
