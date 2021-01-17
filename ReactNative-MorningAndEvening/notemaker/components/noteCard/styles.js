import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    detailsContainer: {
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
    },
    contentContainer: {
        flex: 1,
        flexWrap: 'wrap',
        borderBottomColor: "black",
        borderBottomWidth: 1,
        paddingLeft: Dimensions.get("window").width * 0.1,
        paddingRight: Dimensions.get("window").width * 0.03,

    },
    noteId: {
        width: '10%',
        fontSize: 16,
        color: "black",
        fontWeight: "700",
        padding: 5,
        borderRightColor: "red",
        borderRightWidth: 0.5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    },
    noteTitle: {
        width: '60%',
        fontSize: 14,
        color: "black",
        fontWeight: "500",
        padding: 5,
        borderRightColor: "red",
        borderRightWidth: 0.5
    },
    noteDate: {
        width: '20%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",
        padding: 5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    },
    noteDelete:{
        width: '5%',
        fontSize: 12,
        color: "black",
        fontWeight: "100",
        padding: 5,
        borderBottomColor: "red",
        borderBottomWidth: 0.5
    }
});


export default styles;