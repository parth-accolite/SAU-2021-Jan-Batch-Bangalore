import { Component, OnInit } from '@angular/core';
import { Session } from "./session";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-part1',
  templateUrl: './part1.component.html',
  styleUrls: ['./part1.component.css']
})
export class Part1Component implements OnInit {

  newSessionForm = this.formBuilder.group({
    name: '',
    trainer: '',
    date: ''
  });
  constructor(private formBuilder: FormBuilder,) { }
  submitted = false;
  isEditSessionId: number;
  expandSessionDetails: number;
  sessions = [
    {
      id: 0,
      name: "Angular",
      trainer: "Sharanya",
      date: new Date()

    },
    {
      id: 1,
      name: "React Native",
      trainer: "Tajammul",
      date: new Date()

    },
    {
      id: 2,
      name: "React",
      trainer: "Raviteja",
      date: new Date()

    },
  ]
  initNewSession(isEdit) {
    this.isEditSessionId = isEdit;
    console.log("init new session ", this.isEditSessionId)
    var sessionListDiv = document.getElementById("sessionListDiv");
    sessionListDiv.style.display = "none";
    var editSessionHeading = document.getElementById("editSessionHeading");
    editSessionHeading.style.display = "none";
    var addNewSessionDiv = document.getElementById("addNewSessionDiv");
    addNewSessionDiv.style.display = "block";
    this.newSessionForm.get("name").setValue("")
    this.newSessionForm.get("trainer").setValue("")
    this.newSessionForm.get("date").setValue("")

  }

  addNewSession() {
    this.expandSessionDetails = -1;
    this.submitted = true;
    if (this.isEditSessionId === -1) {
      var newSession = {
        id: this.sessions.length,
        ...this.newSessionForm.value
      };
      this.sessions.push(newSession);
      this.newSessionForm.reset();
    } else {
      this.sessions[this.isEditSessionId] = {
        id: this.isEditSessionId,
        ...this.newSessionForm.value
      }
    }
    console.log("added/edited session id ", this.isEditSessionId)

    this.isEditSessionId = -1;
    console.log("reset session id to", this.isEditSessionId)

    var sessionListDiv = document.getElementById("sessionListDiv");
    sessionListDiv.style.display = "block";
    var editSessionHeading = document.getElementById("editSessionHeading");
    editSessionHeading.style.display = "block";
    var addNewSessionDiv = document.getElementById("addNewSessionDiv");
    addNewSessionDiv.style.display = "none";

  }

  deleteSession(id) {
    this.expandSessionDetails = -1
    console.log(this.sessions.length);
    if (this.sessions.length === 1) {
      this.sessions = [];
      return;
    }
    for (var i in this.sessions) {
      if (this.sessions[i].id == id) {
        console.log(i, this.sessions[i].id)
        this.sessions.splice(parseInt(i), 1);

      }
    }
  }

  SetDate(date) {
    var day = date.getDate().toString();
    var month = (date.getMonth() + 1).toString();
    var year = date.getFullYear();

    if (parseInt(month) < 10) month = "0" + month;
    if (parseInt(day) < 10) day = "0" + day;

    var editedDate = day + "/" + month + "/" + year;

    return editedDate;
  }

  editSession(sessionId) {
    this.expandSessionDetails = -1
    this.isEditSessionId = sessionId;
    this.initNewSession(sessionId);
    this.newSessionForm.get("name").setValue(this.sessions[sessionId].name)
    this.newSessionForm.get("trainer").setValue(this.sessions[sessionId].trainer)
    this.newSessionForm.get("date").setValue(new Date())

    var sessionDate = this.SetDate(this.sessions[sessionId].date);
    console.log(sessionDate);
    this.newSessionForm.get("date").setValue(sessionDate);
    document.getElementById("date").innerHTML = sessionDate;
    //  Date Sat Jan 16 2021 19:37:34 GMT+0530 (India Standard Time) 
    console.log("Not able to populate the date field ");
    console.log(typeof sessionId);
    console.log("edit todo no", sessionId);
  }

  expandSession(sessionId) {
    console.log(sessionId);
    this.expandSessionDetails = sessionId;
    console.log(this.expandSessionDetails)
  }

  ngOnInit(): void {
  }
}