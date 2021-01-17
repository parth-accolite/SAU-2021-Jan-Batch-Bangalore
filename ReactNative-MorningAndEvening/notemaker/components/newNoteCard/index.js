import React, { useState } from "react";
import { Text, TextInput, View } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import Button from "./Button";
import styles from "./styles";

// import moment from "moment";
const NewNoteCard = ({ navigation }) => {
    // const newNote = {};
    const [noteTitle, setNoteTitle] = useState("");
    const [noteContent, setNoteContent] = useState("");
    // const [noteDate, setNoteDate] = useState("");

    const submitNote = async () => {
        var date = new Date().getDate(); //Current Date
        console.log(date, "date is ")
        var month = new Date().getMonth() + 1; //Current Month
        var year = new Date().getFullYear(); //Current Year
        var hours = new Date().getHours(); //Current Hours
        var min = new Date().getMinutes(); //Current Minutes
        var sec = new Date().getSeconds(); //Current Seconds
        var noteDate = hours + ':' + min + ':' + sec + " " + date + '/' + month + '/' + year;
        console.log(noteDate);
        var newNote = {
            "title": noteTitle,
            "content": noteContent,
            "date": noteDate,
        }
        console.log(newNote);
        var notesList = await AsyncStorage.getItem("notesList");
        console.log("notesList", JSON.parse(notesList))
        notesList = JSON.parse(notesList);
        if (notesList === null) {
            notesList = [
                {
                    id: "1",
                    note: newNote,
                }
            ]
        } else {
            let noteId = notesList.length + 1;
            notesList.push(
                {
                    id: noteId,
                    note: newNote,
                }
            )
        }

        console.log(notesList);
        await AsyncStorage.setItem('notesList', JSON.stringify(notesList));
        var noteListFetched = await AsyncStorage.getItem('notesList');
        console.log("noteListFetched", JSON.parse(noteListFetched));

        console.log("done")
        navigation.goBack();
    }
    return (
        <View style={styles.container}>
            <TextInput multiline style={styles.titleTextStyle} placeholder="Enter note Title" onChangeText={setNoteTitle} />
            <TextInput multiline style={styles.contentTextStyle} placeholder="Enter note " onChangeText={setNoteContent} />
            {/* <TextInput placeholder="Enter Date" onChangeText={setNoteDate} /> */}
            <Button title="ADD" action={submitNote} />


        </View>
    );
}

export default NewNoteCard;
