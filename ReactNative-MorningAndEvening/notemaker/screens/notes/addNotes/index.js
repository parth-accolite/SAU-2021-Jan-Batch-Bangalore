import React from "react";
import { Text, TextInput, View } from "react-native";
import { NewNoteCard } from "../../../components/index";
const AddNotes = ({ navigation }) => {
    return (
        <View>
            {/* <Text> Add New Note shere</Text> */}
            <NewNoteCard navigation={navigation} />
        </View>
    );
}

export default AddNotes;