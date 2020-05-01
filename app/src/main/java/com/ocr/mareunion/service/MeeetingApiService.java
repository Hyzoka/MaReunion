package com.ocr.mareunion.service;

import com.ocr.mareunion.model.Meeting;
import java.util.List;

public interface MeeetingApiService {

    List<Meeting> getReunions();

    void createReunion(Meeting reunion);

    void deleteReunion(Meeting mReunion);
}

