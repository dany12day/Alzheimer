package com.example.alzheimer.Notes

import java.io.Serializable
import java.time.LocalDateTime

class NoteModel (
    var title: String,
    var content: String,
    var date: LocalDateTime
    ) : Serializable