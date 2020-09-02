package com.amannirala13.mobilesiu.main.model

data class Assignment(
    var assignmentNumber: Int,
    var title: String = "No Title",
    var description: String = "No description",
    var author: String = "Aman Kumar Nirala",
    var runnable: AssignmentRunnable
)