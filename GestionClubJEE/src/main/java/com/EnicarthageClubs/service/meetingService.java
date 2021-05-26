package com.EnicarthageClubs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EnicarthageClubs.model.Meeting;
import com.EnicarthageClubs.repository.meetingRepo;
@Service
public class meetingService {
	@Autowired
	meetingRepo MeetingRepository;

	@Transactional
	public List<Meeting> getAllMeetings() {
		return (List<Meeting>) MeetingRepository.findAll();
	}

	

	@Transactional
	public Optional<Meeting> getById(Long id) {
		return MeetingRepository.findById(id);
	}

	@Transactional
	public void deleteMeeting(Long meetingId) {
		MeetingRepository.deleteById(meetingId);
	}

	@Transactional
	public boolean addMeeting(Meeting meeting) {
		return MeetingRepository.save(meeting) != null;
	}

	@Transactional
	public boolean updateMeeting(Meeting meeting) {
		return MeetingRepository.save(meeting) != null;
	}

}
