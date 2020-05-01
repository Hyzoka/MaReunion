package com.ocr.mareunion.event;

import com.ocr.mareunion.model.Meeting;

public class CreateReunionEvent {
    public Meeting mReunion;

    public CreateReunionEvent(Meeting reunion) {
        mReunion = reunion;
    }
}
