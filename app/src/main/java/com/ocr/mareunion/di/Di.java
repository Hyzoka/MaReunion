package com.ocr.mareunion.di;

import com.ocr.mareunion.service.DummyMeetingApiService;
import com.ocr.mareunion.service.MeeetingApiService;

public class Di {
    public static MeeetingApiService myApiService = new DummyMeetingApiService();

    public static MeeetingApiService getReunionApiService(){return myApiService;}

    public static MeeetingApiService getNewInstanceApiService(){
        return new DummyMeetingApiService();
    }
}
