package com.ocr.mareunion.event;

import com.ocr.mareunion.model.Meeting;

public class DeleteReunionEvent {

    public Meeting mReunion;

    public DeleteReunionEvent(Meeting reunion) {
        mReunion = reunion;
    }
}
