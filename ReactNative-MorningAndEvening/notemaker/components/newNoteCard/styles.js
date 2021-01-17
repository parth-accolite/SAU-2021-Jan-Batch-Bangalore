import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        // flex: 1,
        height: Dimensions.get("window").height * 0.5,
        width: Dimensions.get('window').width * 0.9,
        justifyContent: "center",
        // marginRight:"15%",
        // marginLeft:"15%",
        alignSelf: "center",
    },
    titleTextStyle: {
        fontSize: 23,
        fontWeight: "bold",
        marginVertical: 20,
    },
    contentTextStyle: {
        // width: Dimensions.get('window').width * 0.9,
        borderColor: "blue",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 18,
        padding: 4,
        width: "95%",
        height:"60%",
        marginBottom: 20,
    },

    btn: {
        padding: 5,
        margin: 3,
        borderColor: "blue",
        borderWidth: 3,
        width: Dimensions.get('window').width * 0.2,
    },
    btnText: {
        color: "blue",
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default styles;