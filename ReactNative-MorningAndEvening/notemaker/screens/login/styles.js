import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
        // flex: 1,
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    textInputStyle: {
        borderColor: "blue",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 18,
        padding: 4,
        width: "60%",
        marginBottom: 20,
    },
    loginTextStyle: {
        fontSize: 23,
        fontWeight: "bold",
        marginVertical: 20,
    },
    btn: {
        padding: 5,
        margin: 3,
        borderColor: "blue",
        borderWidth: 3
    },
    btnText: {
        color: "blue",
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default styles;